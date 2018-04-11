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

public class SpeedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Integer fromSpinner,toSpinner;
    private TextView textviewToValue;
    private EditText etUserInput;
    private Spinner speedSpinner1, speedSpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        this.speedSpinner1 = (Spinner) findViewById(R.id.spinnerSpeed1);
        this.speedSpinner2 = (Spinner) findViewById(R.id.spinnerSpeed2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.speedUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinner1.setAdapter(adapter);
        speedSpinner2.setAdapter(adapter);
        speedSpinner1.setOnItemSelectedListener(this);
        speedSpinner2.setOnItemSelectedListener(this);

        final EditText etSpeed = (EditText) findViewById(R.id.inputSpeed);
        Button convertBtn = (Button) findViewById(R.id.convertSpeedBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(SpeedActivity.this, ShowResultActivity.class);
                result.putExtra("speedInput", etSpeed.getText().toString());
                startActivity(result);
            }
        });
    }

    private void initialize(){
        this.etUserInput = (EditText) findViewById(R.id.inputSpeed);
        this.textviewToValue = (TextView) findViewById(R.id.etConvertedSpeed);
    }

    private void calculation(View view){
        double userInput = Double.parseDouble(etUserInput.getText().toString());
        double userOutput;

        if(fromSpinner == 0 && toSpinner == 0) {
            userOutput = userInput;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 0 && toSpinner == 1){
            userOutput = userInput * 3.6;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 1 && toSpinner == 0){
            userOutput = userInput / 3.6;
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
            case R.id.spinnerSpeed1:
                speedSpinner1.setSelection(position);
                fromSpinner = speedSpinner1.getSelectedItemPosition();
                Log.e("message", String.valueOf(fromSpinner));
                break;
            case R.id.spinnerSpeed2:
                speedSpinner2.setSelection(position);
                toSpinner = speedSpinner2.getSelectedItemPosition();
                Log.e("message", String.valueOf(toSpinner));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}