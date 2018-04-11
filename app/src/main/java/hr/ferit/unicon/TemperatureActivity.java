package hr.ferit.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner temperatureSpinner1, temperatureSpinner2;
    private Integer fromSpinner, toSpinner;
    private TextView textviewToValue;
    private EditText etUserInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        Spinner temperatureSpinner1 = (Spinner) findViewById(R.id.spinnerTemp1);
        Spinner temperatureSpinner2 = (Spinner) findViewById(R.id.spinnerTemp2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperatureUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatureSpinner1.setAdapter(adapter);
        temperatureSpinner2.setAdapter(adapter);
        temperatureSpinner1.setOnItemSelectedListener(this);
        temperatureSpinner2.setOnItemSelectedListener(this);

        final EditText etTemperature = (EditText) findViewById(R.id.inputTemperature);
        Button convertBtn = (Button) findViewById(R.id.convertTemperatureBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(TemperatureActivity.this, ShowResultActivity.class);
                result.putExtra("temperatureInput", etTemperature.getText().toString());
                startActivity(result);
            }
        });
    }

    private void initialize(){
        this.etUserInput = (EditText) findViewById(R.id.inputSpeed);
        this.textviewToValue = (TextView) findViewById(R.id.etConvertedTemperature);
    }

    private void calculation(View view){
        double userInput = Double.parseDouble(etUserInput.getText().toString());
        double userOutput;

        if(fromSpinner == 0 && toSpinner == 0) {
            userOutput = userInput;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 0 && toSpinner == 1){
            userOutput = (userInput * 1.8) + 32;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 1 && toSpinner == 0){
            userOutput = (userInput - 32) * 0.5555555;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 1 && toSpinner == 1){
            userOutput = userInput;
            textviewToValue.setText(String.valueOf(userOutput));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        adapterView.getItemAtPosition(position);
        switch (adapterView.getId()) {
            case R.id.spinnerTemp1:
                temperatureSpinner1.setSelection(position);
                fromSpinner = temperatureSpinner1.getSelectedItemPosition();
                Log.e("message", String.valueOf(fromSpinner));
                break;
            case R.id.spinnerTemp2:
                temperatureSpinner2.setSelection(position);
                toSpinner = temperatureSpinner2.getSelectedItemPosition();
                Log.e("message", String.valueOf(toSpinner));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
