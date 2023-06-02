package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textEdit1;
    private EditText textEdit2;
    private TextView text_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textEdit1 = findViewById(R.id.text_edit1);
        textEdit2 = findViewById(R.id.text_edit2);
        text_equal = findViewById(R.id.text_equal);

        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivision = findViewById(R.id.button_division);
        Button buttonClose = findViewById(R.id.button_close);


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void calculate(char operator) {
        String number1 = textEdit1.getText().toString();
        String number2 = textEdit2.getText().toString();

        if (!number1.isEmpty() && !number2.isEmpty()) {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

            text_equal.setText(String.valueOf(result));
        }
    }
}
