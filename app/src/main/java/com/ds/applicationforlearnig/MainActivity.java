package com.ds.applicationforlearnig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView equationText;
    private EditText firstXEditText, secondXEditText;
    private Button calculateButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationText = findViewById(R.id.equationText);
        firstXEditText = findViewById(R.id.firstXEditText);
        secondXEditText = findViewById(R.id.secondXEditText);
        calculateButton = findViewById(R.id.calculateButton);

        initEquation();
    }

    private void initEquation() {
        Equation equation = new Equation();
        equation.generateXCoefficients();

        equationText.setText(equation.toString());

        calculateButton.setOnClickListener(v -> check(equation));
    }

    private void check(@NonNull Equation equation){
        if(!fieldIsEmpty(firstXEditText) & !fieldIsEmpty(secondXEditText)) {
            float x1 = getDataFloat(firstXEditText);
            float x2 = getDataFloat(secondXEditText);

            if (equation.isRight(x1, x2)) {
                Toast.makeText(this, "Значения верны", Toast.LENGTH_LONG).show();
            } else {
                setEditTextError(firstXEditText, "Значение неверно");
                setEditTextError(secondXEditText, "Значение неверно");
            }
        }else{
            if(fieldIsEmpty(firstXEditText)) setEditTextError(firstXEditText, "Заполните поле");
            if(fieldIsEmpty(secondXEditText)) setEditTextError(secondXEditText, "Заполните поле");
        }
    }

    private float getDataFloat(@NonNull EditText editText){
        return Float.parseFloat(editText.getText().toString().trim());
    }

    private void setEditTextError(@NonNull EditText editText, String errorText){
        editText.setError(errorText);
    }

    private boolean fieldIsEmpty(@NonNull EditText editText){
        return editText.getText().toString().isEmpty();
    }
}