package com.example.administrator.randomcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RandomAndCal randomAndCal;
    private static  final String MyFlag = "randomCal";
    private int roundCount = 0;
    private Button btnRandom;
    private Button btnSubmit;
    private EditText txtProblem;
    private EditText txtAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        randomAndCal = new RandomAndCal(null);
        setContentView(R.layout.activity_main);

        btnRandom = (Button) findViewById(R.id.btnRandom);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtProblem = (EditText) findViewById(R.id.txtProblem);
        txtAnswer = (EditText) findViewById(R.id.txtAnswer);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String problem = randomAndCal.getProblem();
                txtProblem.setText(problem);
                randomAndCal.setProblem(problem);
                int result = randomAndCal.calculate();
                Toast.makeText(getBaseContext(), String.valueOf(result), Toast.LENGTH_LONG).show();
            }
        });


    }
}
