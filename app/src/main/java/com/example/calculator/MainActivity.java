package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Properties
    String prevNumber; // Previous number
    String currNumber;  // Current number
    Double result = 0.0;
    String operator;

    // UI components
    TextView textView;
//    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
//    Button buttonAC, buttonArithmetic, buttonPercentage, buttonDecimal;
//    Button buttonAdd, buttonSubstract, buttonMutiply, buttonDivide, buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currNumber = "";
        textView = findViewById(R.id.editText);
        Button button0 = findViewById(R.id.btn0);
        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        Button button3 = findViewById(R.id.btn3);
        Button button4 = findViewById(R.id.btn4);
        Button button5 = findViewById(R.id.btn5);
        Button button6 = findViewById(R.id.btn6);
        Button button7 = findViewById(R.id.btn7);
        Button button8 = findViewById(R.id.btn8);
        Button button9 = findViewById(R.id.btn9);
        Button buttonClear = findViewById(R.id.clearBtn);
        Button buttonChangeSign = findViewById(R.id.arithmeticBtn);
        Button buttonPercentage = findViewById(R.id.percentageBtn);
        Button buttonDecimal = findViewById(R.id.commaBtn);
        Button buttonAdd = findViewById(R.id.additionBtn);
        Button buttonSubtract = findViewById(R.id.subtractionBtn);
        Button buttonMultiply = findViewById(R.id.multiplicationBtn);
        Button buttonDivide = findViewById(R.id.divisionBtn);
        Button buttonEqual = findViewById(R.id.equalBtn);


        button0.setOnClickListener(view -> appendNumber("0"));
        button1.setOnClickListener(view -> appendNumber("1"));
        button2.setOnClickListener(view -> appendNumber("2"));
        button3.setOnClickListener(view -> appendNumber("3"));
        button4.setOnClickListener(view -> appendNumber("4"));
        button5.setOnClickListener(view -> appendNumber("5"));
        button6.setOnClickListener(view -> appendNumber("6"));
        button7.setOnClickListener(view -> appendNumber("7"));
        button8.setOnClickListener(view -> appendNumber("8"));
        button9.setOnClickListener(view -> appendNumber("9"));

        buttonAdd.setOnClickListener(view -> add());
        buttonSubtract.setOnClickListener(view -> subtract());
        buttonMultiply.setOnClickListener(view -> multiply());
        buttonDivide.setOnClickListener(view -> divide());
        buttonEqual.setOnClickListener(view -> calculate());
        buttonClear.setOnClickListener(view -> clear());
        buttonDecimal.setOnClickListener(view -> addDecimal());
        buttonPercentage.setOnClickListener(view -> calculatePercentage());
        buttonChangeSign.setOnClickListener(view -> changeSign());
    }

    private void appendNumber(String number) {
        currNumber += number;
        textView.setText(currNumber);
    }
    private void setOperator(String op) {
        if (!currNumber.isEmpty()) {
            operator = op;
            result = Double.parseDouble(currNumber);
            currNumber = "";
        }
    }
    private void add() {
        setOperator("+");
    }
    private void subtract() {
        setOperator("-");
    }
    private void multiply() {
        setOperator("*");
    }
    private void divide() {
        setOperator("/");
    }
    private void calculate() {
        calculateResult();
    }
    private void calculatePercentage() {
        if (!currNumber.isEmpty()) {
            double number = Double.parseDouble(currNumber);
            double percentage = number / 100;
            currNumber = String.valueOf(percentage);
            textView.setText(currNumber);
        }
    }

    private void changeSign() {
        if (!currNumber.isEmpty()) {
            double number = Double.parseDouble(currNumber);
            number = -number;
            currNumber = String.valueOf(number);
            textView.setText(currNumber);
        }
    }

    private void addDecimal() {
        if (!currNumber.contains(".")) {
            currNumber += ".";
            textView.setText(currNumber);
        }
    }

    private void clear() {
        currNumber = "";
        operator = "";
        result = 0.0;
        textView.setText("0");
    }
    private void calculateResult() {
        if (!currNumber.isEmpty()) {
            double secondOperand = Double.parseDouble(currNumber);
            switch (operator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result /= secondOperand;
                    } else {
                        // Handle division by zero error
                        // ...
                    }
                    break;
            }
            currNumber = String.valueOf(result);
            textView.setText(currNumber);
        }
    }
}