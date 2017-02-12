package com.faqrulans.calcandfriend;

import android.content.Context;
import android.net.Uri;
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


public class MassConvertFragment extends Fragment {


    Spinner spinnerMass1;
    Spinner spinnerMass2;
    EditText inputMassET;
    TextView resultMassTV;
    Button convertBT;
    int selectedMass1;    //0 Kilometer, 1 meter, 2 centimeter, 3 mile, 4 feet, 5 inch
    int selectedMass2;    //0 Kilometer, 1 meter, 2 centimeter, 3 mile, 4 feet, 5 inch
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

        if(input.length() > 0) {
            result = new BigDecimal(input);

            if (selectedMass1 == 0 && selectedMass2 == 1) {

            } else if (selectedMass1 == 0 && selectedMass2 == 2) {

            } else if (selectedMass1 == 1 && selectedMass2 == 0) {

            } else if (selectedMass1 == 1 && selectedMass2 == 2) {

            } else if (selectedMass1 == 2 && selectedMass2 == 0) {

            } else if (selectedMass1 == 2 && selectedMass2 == 1) {

            }

            resultMassTV.setText("" + result);
            result = null;
        }

    }


}
