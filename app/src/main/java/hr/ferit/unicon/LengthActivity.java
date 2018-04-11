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

public class LengthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Integer fromSpinner,toSpinner;
    private TextView textviewToValue;
    private EditText etUserInput;
    Spinner lengthSpinner1, lengthSpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        this.lengthSpinner1 = (Spinner) findViewById(R.id.spinnerLength1);
        this.lengthSpinner2 = (Spinner) findViewById(R.id.spinnerLength2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lengthUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthSpinner1.setAdapter(adapter);
        lengthSpinner2.setAdapter(adapter);
        lengthSpinner1.setOnItemSelectedListener(this);
        lengthSpinner1.setOnItemSelectedListener(this);


        final EditText etLength = (EditText) findViewById(R.id.inputLength);
        Button convertBtn = (Button) findViewById(R.id.convertLengthBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(LengthActivity.this, ShowResultActivity.class);
                result.putExtra("lengthInput", etLength.getText().toString());
                startActivity(result);
            }
        });
    }

    private void initialize(){
        this.etUserInput = (EditText) findViewById(R.id.inputSpeed);
        this.textviewToValue = (TextView) findViewById(R.id.etConvertedLength);
    }

    private void calculation(View view){
        double userInput = Double.parseDouble(etUserInput.getText().toString());
        double userOutput;

        if(fromSpinner == 0 && toSpinner == 0) {
            userOutput = userInput;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 0 && toSpinner == 1){
            userOutput = userInput * 3.28084;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 1 && toSpinner == 0){
            userOutput = userInput * 0.30480;
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
            case R.id.spinnerLength1:
                lengthSpinner1.setSelection(position);
                fromSpinner = lengthSpinner1.getSelectedItemPosition();
                Log.e("message", String.valueOf(fromSpinner));
                break;
            case R.id.spinnerLength2:
                lengthSpinner2.setSelection(position);
                toSpinner = lengthSpinner2.getSelectedItemPosition();
                Log.e("message", String.valueOf(toSpinner));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
