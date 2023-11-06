package com.example.mycalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormatValue = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormatValue = NumberFormat.getPercentInstance();

    private double billAmount = 0.0;
    private double tipPercent = 0.25;
    private TextView txtBillAmount;
    private TextView txtTipPercent;
    private TextView txtTip;
    private TextView txtTotalBillAmount;
    private TextView txtMoneySaved;


    private double totalSalary = 0.0;
    private double savingsPercent = 0.25;
    private TextView txtSavePercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtBillAmount = (TextView) findViewById(R.id.txtBillAmout);
        txtTipPercent = (TextView) findViewById(R.id.txtTipPercent);
        txtTip = (TextView) findViewById(R.id.txtTip);
        txtTotalBillAmount = (TextView) findViewById(R.id.txtTotalBillAmount);

        txtTip.setText(currencyFormatValue.format(0));
        txtTotalBillAmount.setText(currencyFormatValue.format(0));

        txtSavePercent = (TextView) findViewById(R.id.txtSavePercent);
        txtMoneySaved = (TextView) findViewById(R.id.txtMoneySaved);

        txtMoneySaved.setText(currencyFormatValue.format(0));

        EditText edtMoneyAmount = (EditText) findViewById(R.id.edtMoneyAmount);
        edtMoneyAmount.addTextChangedListener(tipEdtMoneyAmountTextWatcher);

        SeekBar seekBarPercent = (SeekBar) findViewById(R.id.seekBarPercent);
        seekBarPercent.setOnSeekBarChangeListener(tipSeekBarChangeListener);


    }

    private final TextWatcher tipEdtMoneyAmountTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                billAmount = Double.parseDouble(s.toString()) / 100;
                txtBillAmount.setText(currencyFormatValue.format(billAmount));

            } catch (NumberFormatException e) {

                txtBillAmount.setText("");
                billAmount = 0.0;

                calculatorTip();


            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final SeekBar.OnSeekBarChangeListener tipSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };


    private void calculatorTip() {
        txtTipPercent.setText(percentFormatValue.format(tipPercent));

        double tipValue = billAmount * tipPercent;
        double totalValue = billAmount + tipValue;

        txtTip.setText(currencyFormatValue.format(tipValue));
        txtTotalBillAmount.setText(currencyFormatValue.format(totalValue));
    }


}