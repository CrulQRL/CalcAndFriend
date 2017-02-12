package com.faqrulans.calcandfriend;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MassConvertFragment extends Fragment {


    Spinner spinnerMass1;
    Spinner spinnerMass2;
    EditText inputMassET;
    TextView resultMassTV;
    Button convertBT;
    int selectedMass1;    //0 Kilogram, 1 Ton, 2 Pound, 3 Once
    int selectedMass2;    //0 Kilogram, 1 Ton, 2 Pound, 3 Once

    BigDecimal tonToKilogramCoef;
    BigDecimal poundToKilogramCoef;
    BigDecimal onceToKilogramCoef;

    BigDecimal kilogramToTonCoef;
    BigDecimal kilogramToPoundCoef;
    BigDecimal kilogramToOnceCoef;

    BigDecimal result;
    
    public MassConvertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mass_convert, container, false);
        InitVar(view);

        return view;
    }

    private void InitVar(View view){

        spinnerMass1 = (Spinner) view.findViewById(R.id.spinnerMass1);
        spinnerMass2 = (Spinner) view.findViewById(R.id.spinnerMass2);
        inputMassET = (EditText) view.findViewById(R.id.inputMassET);
        resultMassTV = (TextView) view.findViewById(R.id.resultMassTV);
        convertBT = (Button) view.findViewById(R.id.convertMassBT);
        selectedMass1 = 0;
        selectedMass2 = 0;

        tonToKilogramCoef = new BigDecimal(1000);
        poundToKilogramCoef = new BigDecimal(0.453592);
        onceToKilogramCoef = new BigDecimal(0.0283495);

        kilogramToTonCoef = new BigDecimal(0.001);
        kilogramToPoundCoef = new BigDecimal(2.20462);
        kilogramToOnceCoef = new BigDecimal(35.274);

        result = null;
        setSpinnerListener();
        setButtonConvertListener();


    }

    private void setSpinnerListener(){
        spinnerMass1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMass1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerMass2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMass2 = position;
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

        String input = inputMassET.getText().toString();

        if(input!= null && input.length() > 0) {
            result = new BigDecimal(input);

            if(selectedMass1 == 1){
                result = result.multiply(tonToKilogramCoef);
            }else if(selectedMass1 == 2){
                result = result.multiply(poundToKilogramCoef);
            }else if(selectedMass1 == 3){
                result = result.multiply(onceToKilogramCoef);
            }

            if (selectedMass1 == 0 && selectedMass2 == 1) {
                KilogramToTon();
            } else if (selectedMass1 == 0 && selectedMass2 == 2) {
                KilogramToPound();
            } else if (selectedMass1 == 0 && selectedMass2 == 3) {
                KilogramToOnce();
            }  else if (selectedMass1 == 1 && selectedMass2 == 2) {
                TonToPound();
            } else if (selectedMass1 == 1  && selectedMass2 == 3) {
                TonToOnce();
            }else if (selectedMass1 == 2 && selectedMass2 == 1) {
                PoundToTon();
            }else if (selectedMass1 == 2 && selectedMass2 == 3) {
                PoundToOnce();
            }else if (selectedMass1 == 3 && selectedMass2 == 1) {
                OnceToTon();
            }else if (selectedMass1 == 3 && selectedMass2 == 2) {
                OnceToPound();
            }

            ShowToResultET();

        }

    }

    private void ShowToResultET(){

        String strResult = "" + result;
        String[] resultArr = strResult.split("\\.");

        if(resultArr != null && resultArr.length > 1){

            if(resultArr[0].length() < 3) {
                if (resultArr[1].length() > 4) {
                    result = result.setScale(6, RoundingMode.HALF_UP);
                } else {
                    result = result.setScale(4, RoundingMode.HALF_UP);
                }
            }else{
                result = result.setScale(2, RoundingMode.HALF_UP);
            }
        }else{
            result = result.setScale(1, RoundingMode.HALF_UP);
        }

        resultMassTV.setText("" + result);
        result = null;
    }

    private void KilogramToTon(){
        result = result.multiply(kilogramToTonCoef);
    }
    private void KilogramToPound(){
        result = result.multiply(kilogramToPoundCoef);
    }
    private void KilogramToOnce(){
        result = result.multiply(kilogramToOnceCoef);
    }
    private void TonToPound(){
        result = result.multiply(kilogramToPoundCoef);
    }
    private void TonToOnce(){
        result = result.multiply(kilogramToOnceCoef);
    }
    private void PoundToTon(){
        result = result.multiply(kilogramToTonCoef);
    }
    private void PoundToOnce(){
        result = result.multiply(kilogramToOnceCoef);
    }
    private void OnceToTon(){
        result = result.multiply(kilogramToTonCoef);
    }
    private void OnceToPound(){
        result = result.multiply(kilogramToPoundCoef);
    }



}
