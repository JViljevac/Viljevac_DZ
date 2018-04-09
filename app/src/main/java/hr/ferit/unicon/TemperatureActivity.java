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

public class TemperatureActivity extends AppCompatActivity{


    private Spinner temperatureSpinner1, temperatureSpinner2;
    private Integer fromSpinner, toSpinner;


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
    //    temperatureSpinner1.setOnItemSelectedListener(this);
    //    temperatureSpinner2.setOnItemSelectedListener(this);

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
}
