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
    int selectedLengtherature1;    //0 Kilometer, 1 meter, 2 centimeter, 3 mile, 4 feet, 5 inch
    int selectedLengtherature2;    //0 Kilometer, 1 meter, 2 centimeter, 3 mile, 4 feet, 5 inch
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
        selectedLengtherature1 = 0;
        selectedLengtherature2 = 0;
        result = null;
        setSpinnerListener();
        setButtonConvertListener();


    }

    private void setSpinnerListener(){
        spinnerLength1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLengtherature1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerLength2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLengtherature2 = position;
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

            if (selectedLengtherature1 == 0 && selectedLengtherature2 == 1) {

            } else if (selectedLengtherature1 == 0 && selectedLengtherature2 == 2) {

            } else if (selectedLengtherature1 == 1 && selectedLengtherature2 == 0) {

            } else if (selectedLengtherature1 == 1 && selectedLengtherature2 == 2) {

            } else if (selectedLengtherature1 == 2 && selectedLengtherature2 == 0) {

            } else if (selectedLengtherature1 == 2 && selectedLengtherature2 == 1) {

            }

            resultLengthTV.setText("" + result);
            result = null;
        }

    }

}
