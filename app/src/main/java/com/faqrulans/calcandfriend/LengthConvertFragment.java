package com.faqrulans.calcandfriend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;


public class LengthConvertFragment extends Fragment {

    Spinner spinnerLength1;
    Spinner spinnerLength2;
    EditText inputLengthET;
    TextView resultLengthTV;
    Button convertBT;
    int selectedLength1;    //0 meter, 1 mile, 2 feet, 3 inch
    int selectedLength2;    //0 meter, 1 mile, 2 feet, 3 inch
    BigDecimal mileToMeterCoef;
    BigDecimal feetToMeterCoef;
    BigDecimal inchToMeterCoef;

    BigDecimal meterToMile;
    BigDecimal meterToFeet;
    BigDecimal meterToInch;

    BigDecimal result;


    public LengthConvertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_length_convert, container, false);
        InitVar(view);
        return view;
    }

    private void InitVar(View view){

        spinnerLength1 = (Spinner) view.findViewById(R.id.spinnerLength1);
        spinnerLength2 = (Spinner) view.findViewById(R.id.spinnerLength2);
        inputLengthET = (EditText) view.findViewById(R.id.inputLengthET);
        resultLengthTV = (TextView) view.findViewById(R.id.resultLengthTV);
        convertBT = (Button) view.findViewById(R.id.convertLengthBT);
        selectedLength1 = 0;
        selectedLength2 = 0;

        mileToMeterCoef = new BigDecimal(1609.34);
        feetToMeterCoef = new BigDecimal(0.3048);
        inchToMeterCoef = new BigDecimal(0.0254);

        meterToMile = new BigDecimal(0.000621371);
        meterToFeet = new BigDecimal(3.28084);
        meterToInch = new BigDecimal(39.3701);

        result = null;
        setSpinnerListener();
        setButtonConvertListener();


    }

    private void setSpinnerListener(){
        spinnerLength1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLength1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerLength2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLength2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setButtonConvertListener(){
        convertBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartConvert();
            }
        });
    }

    private void StartConvert(){

        String input = inputLengthET.getText().toString();

        if(input.length() > 0) {
            result = new BigDecimal(input);

            if (selectedLength1 == 0 && selectedLength2 == 1) {
                MeterToMile();
            } else if (selectedLength1 == 0 && selectedLength2 == 2) {
                MeterToFeet();
            } else if (selectedLength1 == 0 && selectedLength2 == 3) {
                MeterToInch();
            } else if (selectedLength1 == 1 && selectedLength2 == 0) {
                MileToMeter();
            } else if (selectedLength1 == 1 && selectedLength2 == 2) {
                MileToFeet();
            } else if (selectedLength1 == 1  && selectedLength2 == 3) {
                MileToInch();
            }else if (selectedLength1 == 2 && selectedLength2 == 0) {
                FeetToMeter();
            }else if (selectedLength1 == 2 && selectedLength2 == 1) {
                FeetToMile();
            }else if (selectedLength1 == 2 && selectedLength2 == 3) {
                FeetToInch();
            }else if (selectedLength1 == 3 && selectedLength2 == 0) {
                InchToMeter();
            }else if (selectedLength1 == 3 && selectedLength2 == 1) {
                InchToMile();
            }else if (selectedLength1 == 3 && selectedLength2 == 2) {
                InchToFeet();
            }

            resultLengthTV.setText("" + result);
            result = null;
        }

    }

    private void MeterToMile(){
        result = result.multiply(meterToMile);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void MeterToFeet() {
        result = result.multiply(meterToFeet);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void MeterToInch(){
        result = result.multiply(meterToInch);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void MileToMeter(){
        result = result.multiply(mileToMeterCoef);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void MileToFeet(){
        result = result.multiply(mileToMeterCoef);
        result = result.multiply(meterToFeet);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void MileToInch(){
        result = result.multiply(mileToMeterCoef);
        result = result.multiply(meterToInch);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void FeetToMeter(){
        result = result.multiply(feetToMeterCoef);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void FeetToMile(){
        result = result.multiply(feetToMeterCoef);
        result = result.multiply(meterToMile);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void FeetToInch(){
        result = result.multiply(feetToMeterCoef);
        result = result.multiply(meterToInch);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void InchToMeter(){
        result = result.multiply(inchToMeterCoef);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    private void InchToMile(){
        result = result.multiply(inchToMeterCoef);
        result = result.multiply(meterToMile);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void InchToFeet(){
        result = result.multiply(inchToMeterCoef);
        result = result.multiply(meterToFeet);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
    }


}
