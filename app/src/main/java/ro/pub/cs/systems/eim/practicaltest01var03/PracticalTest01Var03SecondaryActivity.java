package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {
    Button correctButton;
    Button incorrectButton;

    EditText operationResultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        correctButton = findViewById(R.id.correct_button);
        incorrectButton = findViewById(R.id.incorrect_button);

        operationResultEditText = findViewById(R.id.operation_result_edit_text);

        correctButton.setOnClickListener(it -> {
            setResult(RESULT_OK, null);
            finish();
        });

        incorrectButton.setOnClickListener(it -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });

        Bundle extras = getIntent().getExtras();

        String operation = extras.get(Constants.OPERATION).toString();
        int result = Integer.parseInt(extras.get(Constants.RESULT).toString());

        operationResultEditText.setText("Operation: " + operation + " Result: " + result);
    }
}