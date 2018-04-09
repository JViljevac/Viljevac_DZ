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

public class MassActivity extends AppCompatActivity{

    private Integer fromSpinner,toSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        Spinner massSpinner1 = (Spinner) findViewById(R.id.spinnerMass1);
        Spinner massSpinner2 = (Spinner) findViewById(R.id.spinnerMass2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.massUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        massSpinner1.setAdapter(adapter);
        massSpinner2.setAdapter(adapter);
    //    massSpinner1.setOnItemSelectedListener(this);
    //    massSpinner2.setOnItemSelectedListener(this);

        final EditText etMass = (EditText) findViewById(R.id.inputMass);
        Button convertBtn = (Button) findViewById(R.id.convertMassBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(MassActivity.this, ShowResultActivity.class);
                final EditText etMass = (EditText) findViewById(R.id.inputMass);
                startActivity(result);
            }
        });
    }
}
