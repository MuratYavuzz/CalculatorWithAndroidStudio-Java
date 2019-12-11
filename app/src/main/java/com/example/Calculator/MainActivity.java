package com.example.Calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtPost,txtResult,txtInfix;
    EditText txtInput;
    Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPost= findViewById(R.id.txtPostfix);
        txtResult = findViewById(R.id.txtSonuc);
        txtInput =findViewById(R.id.eTxtGirdi);
        btnCalculate =findViewById(R.id.btnHesapla);
        txtInfix = findViewById(R.id.txtInfix);

    }
    public void hesapla(View view){
        String expression=txtInput.getText().toString();
        txtInfix.setText("Girilen denklem: " + expression);
        PostfixConverter pc = new PostfixConverter(expression);
        txtPost.setText("PostFix: "  + pc.printExpression());

        PostfixCalculator calc = new PostfixCalculator(pc.getPostfixAsList());
        String myResult = String.valueOf(calc.result());
        txtResult.setText("Sonuç: " + myResult);


    }

}