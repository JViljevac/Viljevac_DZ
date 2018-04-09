package hr.ferit.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Button massBtn;
    private Button temperatureBtn;
    private Button lengthBtn;
    private Button speedBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        massBtn = (Button) findViewById(R.id.btnMass);
        massBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMassActivity();
            }
        });

        temperatureBtn = (Button) findViewById(R.id.btnTemp);
        temperatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTemperatureActivity();
            }
        });

        lengthBtn = (Button) findViewById(R.id.btnLength);
        lengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLengthActivity();
            }
        });

        speedBtn = (Button) findViewById(R.id.btnSpeed);
        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpeedActivity();
            }
        });
    }

    public void openMassActivity(){
        Intent massIntent = new Intent(this, MassActivity.class);
        startActivity(massIntent);
    }

    public void openTemperatureActivity(){
        Intent temperatureIntent = new Intent(this, TemperatureActivity.class);
        startActivity(temperatureIntent);
    }

    public void openLengthActivity(){
        Intent lengthIntent = new Intent(this, LengthActivity.class);
        startActivity(lengthIntent);
    }

    public void openSpeedActivity(){
        Intent speedIntent = new Intent(this, SpeedActivity.class);
        startActivity(speedIntent);
    }
}
