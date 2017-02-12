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


public class TemperatureFragment extends Fragment {


    //private OnFragmentInteractionListener mListener;

    Spinner spinner1;
    Spinner spinner2;
    EditText inputTempET;
    TextView resultTempTV;
    Button convertBT;
    int selectedTemperature1;    //0 celcius, 1 farenheit, 2 kelvin
    int selectedTemperature2;    //0 celcius, 1 farenheit, 2 kelvin
    BigDecimal coef1;
    BigDecimal coef2;
    BigDecimal coef3;
    BigDecimal coef4;
    BigDecimal result;




    public TemperatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        InitVar(view);
        return view;
    }

    private void InitVar(View view){

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        inputTempET = (EditText) view.findViewById(R.id.inputTempET);
        resultTempTV = (TextView) view.findViewById(R.id.resultTempTV);
        convertBT = (Button) view.findViewById(R.id.convertBT);
        selectedTemperature1 = 0;
        selectedTemperature2 = 0;
        coef1 = new BigDecimal(1.8);
        coef2 = new BigDecimal(32);
        coef3 = new BigDecimal(273.15);
        coef4 = new BigDecimal(459.67);

        result = null;
        setSpinnerListener();
        setButtonConvertListener();


    }

    private void setSpinnerListener(){
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTemperature1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTemperature2 = position;
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

        String input = inputTempET.getText().toString();

        if(input.length() > 0) {
            result = new BigDecimal(input);

            if (selectedTemperature1 == 0 && selectedTemperature2 == 1) {
                CelciusToFahrenheit();
            } else if (selectedTemperature1 == 0 && selectedTemperature2 == 2) {
                CelciusToKelvin();
            } else if (selectedTemperature1 == 1 && selectedTemperature2 == 0) {
                FahrenheitToCelcius();
            } else if (selectedTemperature1 == 1 && selectedTemperature2 == 2) {
                FahrenheitToKelvin();
            } else if (selectedTemperature1 == 2 && selectedTemperature2 == 0) {
                KelvinToCelcius();
            } else if (selectedTemperature1 == 2 && selectedTemperature2 == 1) {
                KelvinToFahrenheit();
            }

            resultTempTV.setText("" + result);
            result = null;
        }

    }

    private void CelciusToFahrenheit(){


        result = result.multiply(coef1);
        result = result.add(coef2);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);


    }

    private void FahrenheitToCelcius(){

        double temp = result.doubleValue() - coef2.doubleValue();
        temp = temp/coef1.doubleValue();
        String tempString = "" + temp;
        if(tempString.length() > 12){
            tempString = tempString.substring(0,12);
        }
        result = new BigDecimal(tempString).setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void CelciusToKelvin(){

        result = result.add(coef3);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void KelvinToCelcius(){

        result = result.subtract(coef3);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void FahrenheitToKelvin(){


        double temp = result.doubleValue() + coef4.doubleValue();
        temp = temp/coef1.doubleValue();
        String tempString = "" + temp;

        if(tempString.length() > 12){
            tempString = tempString.substring(0,12);
        }
        result = new BigDecimal(tempString).setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    private void KelvinToFahrenheit(){

        result = result.multiply(coef1);
        result = result.subtract(coef4);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);

    }

    /**
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    **/
}
