package hr.ferit.unicon;

import android.app.ListActivity;
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
import android.widget.Toast;

import java.util.Locale;

public class MassActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Integer fromSpinner,toSpinner;
    private Spinner massSpinner1, massSpinner2;
    private EditText etUserInput;
    private TextView textviewToValue;
    private final String ErrorText = "Enter a number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        this.initialize();

        this.massSpinner1 = (Spinner) findViewById(R.id.spinnerMass1);
        this.massSpinner2 = (Spinner) findViewById(R.id.spinnerMass2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.massUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        massSpinner1.setAdapter(adapter);
        massSpinner2.setAdapter(adapter);
        massSpinner1.setOnItemSelectedListener(this);
        massSpinner2.setOnItemSelectedListener(this);

        Button convertBtn = (Button) findViewById(R.id.convertMassBtn);
    }

    private void initialize(){
        this.etUserInput = (EditText) findViewById(R.id.inputMass);
        this.textviewToValue = (TextView) findViewById(R.id.etConverted);
    }

    public void onClick(View v){
        calculation(v);
        String MassInput = this.etUserInput.getText().toString();
        double UserInput = Double.parseDouble(etUserInput.getText().toString());
//        double converted = this.calculation(UserInput);
//        String convertedString = Double.toString(converted);
//        textviewToValue.setText(convertedString);
    }

    private void calculation(View view){
        double userInput = Double.parseDouble(etUserInput.getText().toString());
        double userOutput;

        if(fromSpinner == 0 && toSpinner == 0) {
            userOutput = userInput;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 0 && toSpinner == 1){
            userOutput = userInput * 2.20462;
            textviewToValue.setText(String.valueOf(userOutput));
        }

        if(fromSpinner == 1 && toSpinner == 0){
            userOutput = userInput * 0.45359;
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
            case R.id.spinnerMass1:
                massSpinner1.setSelection(position);
                fromSpinner = massSpinner1.getSelectedItemPosition();
                Log.e("message", String.valueOf(fromSpinner));
                break;
            case R.id.spinnerMass2:
                massSpinner2.setSelection(position);
                toSpinner = massSpinner2.getSelectedItemPosition();
                Log.e("message", String.valueOf(toSpinner));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void displayToast(String Text){
        Toast T = Toast.makeText(MassActivity.this, Text, Toast.LENGTH_LONG);
        T.show();
    }
}
