package hr.ferit.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LengthActivity extends AppCompatActivity {

    private Integer fromSpinner,toSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        Spinner lengthSpinner1 = (Spinner) findViewById(R.id.spinnerLength1);
        Spinner lengthSpinner2 = (Spinner) findViewById(R.id.spinnerLength2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lengthUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthSpinner1.setAdapter(adapter);
        lengthSpinner2.setAdapter(adapter);

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
}
