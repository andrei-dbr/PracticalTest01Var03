package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

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
            }
        }
    }

    ButtonClickListener buttonClickListener = new ButtonClickListener();

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
    }
}