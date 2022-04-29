package com.br.juarezjunior.calculadoradegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText valorConta;
    private TextView percentualGorgeta;
    private SeekBar barraPercentualGorgeta;
    private TextView valorGorgeta;
    private TextView valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Integer valorPercentualGorgeta;

        valorConta = findViewById(R.id.editValorConta);
        percentualGorgeta = findViewById(R.id.textPercentualGorgeta);
        barraPercentualGorgeta = findViewById(R.id.seekPercentualGorgeta);
        valorGorgeta = findViewById(R.id.textValorGorgeta);
        valorTotal = findViewById(R.id.textValorTotal);

        barraPercentualGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                percentualGorgeta.setText(i);
                percentualGorgeta.setText(String.valueOf(i));
//                valorPercentualGorgeta = i;
                atualizaValoresNaTela();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (valorConta.getText() == null) {
//                    Toast.makeText(getApplicationContext(), "Valor da conta tem que ser informado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                valorGorgeta.setText(Integer.parseInt(valorConta.getText().toString()) * valorPercentualGorgeta / 100);
//                valorGorgeta.setText(Integer.parseInt(valorConta.getText().toString()) * Integer.parseInt(percentualGorgeta.getText().toString()) / 100);
//                valorTotal.setText(String.valueOf(Double.parseDouble(valorConta.getText().toString()) + Double.parseDouble(valorGorgeta.getText().toString())));
            }
        });


    }

    public void atualizaValoresNaTela() {
        double mValorGorgeta;
        double mValorConta;
        double mValorTotal;
        int mPercentual;

        if (!valorConta.getText().toString().equals("") &
                !valorConta.getText().toString().equals(null)) {
            if(Double.parseDouble(valorConta.getText().toString()) != 0.0) {
                mPercentual = Integer.parseInt(percentualGorgeta.getText().toString());
                mValorConta = Double.parseDouble(valorConta.getText().toString());
                mValorGorgeta = mValorConta * mPercentual / 100;
                mValorTotal = mValorConta + mValorGorgeta;


                valorGorgeta.setText(String.format("R$ %.2f", mValorGorgeta));
                valorTotal.setText(String.format("R$ %.2f", mValorTotal));
            }else{
                Toast.makeText(getApplicationContext(), "Valor da conta tem que ser diferente de zero (0.00)", Toast.LENGTH_LONG).show();
                barraPercentualGorgeta.setProgress(0);
                valorGorgeta.setText(String.format("R$ %.2f", 0.00));
                valorTotal.setText(String.format("R$ %.2f", 0.00));
            }

        } else {
            Toast.makeText(getApplicationContext(), "Valor da conta tem que ser informado", Toast.LENGTH_LONG).show();
            barraPercentualGorgeta.setProgress(0);
            valorGorgeta.setText(String.format("R$ %.2f", 0.00));
            valorTotal.setText(String.format("R$ %.2f", 0.00));
        }

    }


}
