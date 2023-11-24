package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String firstOperand;

    private Operations operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view instanceof MaterialButton) {
            String number = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0")) {
                textView.setText(number);
            } else {
                textView.append(number);
            }
        }
    }

    public void onClearClick(View view) {
        textView.setText("0");
    }

    public void onOperationClick(View view) {
        if (view instanceof MaterialButton) {
            String number = ((MaterialButton) view).getText().toString();
            if (number.equals("=") && firstOperand != null && operator != null) {
                String result = "0";
                switch (operator) {
                    case PLUS:
                        result = String.valueOf(Double.valueOf(firstOperand) + Double.valueOf(textView.getText().toString()));
                        break;
                    case MINUS:
                        result = String.valueOf(Double.valueOf(firstOperand) - Double.valueOf(textView.getText().toString()));

                        break;
                    case MULTIPLY:
                        result = String.valueOf(Double.valueOf(firstOperand) * Double.valueOf(textView.getText().toString()));

                        break;
                    case DIVIDE:
                        result = String.valueOf(Double.valueOf(firstOperand) / Double.valueOf(textView.getText().toString()));

                        break;
                    default:
                        result = "0";
                        break;
                }
                if (result.contains(".") && result.matches(".*0*$")) {
                    result = result.toString().replaceAll("\\.?0*$", ""); // Remove decimal point and trailing zeros
                }
                textView.setText(result);

            } else if (!textView.getText().toString().equals("0")) {
                firstOperand = textView.getText().toString();
                textView.setText("0");
                if (number.equals("+")) {
                    operator = Operations.PLUS;
                } else if (number.equals("−")) {
                    operator = Operations.MINUS;
                } else if (number.equals("×")) {
                    operator = Operations.MULTIPLY;
                } else if (number.equals("÷")) {
                    operator = Operations.DIVIDE;
                }
            }

        }
    }

    public void onExtraOperationsClick(View view) {
        if (view instanceof MaterialButton) {

            String buttonSymbol = ((MaterialButton) view).getText().toString();
            if (buttonSymbol.equals("+/-")) {
                if (!textView.getText().toString().equals("0")) {
                    if (textView.getText().toString().contains("-")) {
                        textView.setText(textView.getText().toString().substring(1).toString());
                    } else {
                        textView.setText("-" + textView.getText().toString());
                    }
                }
            } else if (buttonSymbol.equals("%")) {
                if (!textView.getText().toString().equals("0")) {
                    Double result = Double.valueOf(textView.getText().toString()) * 0.1;
                    textView.setText(result.toString());
                }
            } else if (buttonSymbol.equals(".")) {
                textView.setText(textView.getText().toString() + ".");
            }
        }
    }
}