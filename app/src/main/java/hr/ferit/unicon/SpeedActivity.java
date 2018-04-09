package hr.ferit.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SpeedActivity extends AppCompatActivity {

    private Integer fromSpinner,toSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        Spinner speedSpinner1 = (Spinner) findViewById(R.id.spinnerSpeed1);
        Spinner speedSpinner2 = (Spinner) findViewById(R.id.spinnerSpeed2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.speedUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinner1.setAdapter(adapter);
        speedSpinner2.setAdapter(adapter);

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
}