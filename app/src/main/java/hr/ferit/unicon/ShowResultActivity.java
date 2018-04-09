package hr.ferit.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        TextView tvFromMassUnit = (TextView) findViewById(R.id.fromValue);
        tvFromMassUnit.setText(getIntent().getExtras().getString("massInput"));
/*        TextView tvToMassUnit = (TextView) findViewById(R.id.toUnit);
        tvToMassUnit.setText(getIntent().getExtras().getString(""));

        TextView tvFromLengthUnit = (TextView) findViewById(R.id.fromValue);
        tvFromLengthUnit.setText(getIntent().getExtras().getString("lengthInput"));

        TextView tvFromSpeedUnit = (TextView) findViewById(R.id.fromValue);
        tvFromSpeedUnit.setText(getIntent().getExtras().getString("speedInput"));

        TextView tvFromTemperatureUnit = (TextView) findViewById(R.id.fromValue);
        tvFromTemperatureUnit.setText(getIntent().getExtras().getString("temperatureInput"));
*/
    }
}
