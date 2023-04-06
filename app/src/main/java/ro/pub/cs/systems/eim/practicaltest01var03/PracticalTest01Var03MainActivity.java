package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {
    Button plusButton;
    Button minusButton;
    Button navigateToSecondaryActivityButton;

    EditText firstEditText;
    EditText secondEditText;

    TextView displayTextView;

    String operation = "nothing";
    String result = "0";

    class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int left;
            int right;

            if (view.getId() == R.id.plus_button) {

                firstEditText.getText().toString();

                try {
                    left = Integer.parseInt(firstEditText.getText().toString());
                    right = Integer.parseInt(secondEditText.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                    return;
                }

                displayTextView.setText(left + " + " + right + " = " + (left + right));

                operation = "Addition";
                result = String.valueOf(left + right);
            }

            if (view.getId() == R.id.minus_button) {

                firstEditText.getText().toString();

                try {
                    left = Integer.parseInt(firstEditText.getText().toString());
                    right = Integer.parseInt(secondEditText.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                    return;
                }

                displayTextView.setText(left + " - " + right + " = " + (left - right));

                operation = "Subtraction";
                result = String.valueOf(left - right);
            }

            if (view.getId() == R.id.navigate_to_secondary_activity_button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);

                intent.putExtra(Constants.OPERATION, operation);
                intent.putExtra(Constants.RESULT, result);

                startActivityForResult(intent, Constants.REQUEST_CODE);
            }
        }
    }

    ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        try {
            outState.putInt(Constants.FIRST_EDIT_TEXT_VAL, Integer.parseInt(firstEditText.getText().toString()));
            outState.putInt(Constants.SECOND_EDIT_TEXT_VAL, Integer.parseInt(secondEditText.getText().toString()));
        } catch (Exception e) {
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);

        navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity_button);

        firstEditText = findViewById(R.id.first_edit_text);
        secondEditText = findViewById(R.id.second_edit_text);

        displayTextView = findViewById(R.id.display_text_view);

        plusButton.setOnClickListener(buttonClickListener);
        minusButton.setOnClickListener(buttonClickListener);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            int first = savedInstanceState.getInt(Constants.FIRST_EDIT_TEXT_VAL);
            int second = savedInstanceState.getInt(Constants.SECOND_EDIT_TEXT_VAL);

            firstEditText.setText(String.valueOf(first));
            secondEditText.setText(String.valueOf(second));
        }
    }
}