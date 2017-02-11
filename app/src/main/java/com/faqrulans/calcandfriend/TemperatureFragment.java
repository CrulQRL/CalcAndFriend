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


public class TemperatureFragment extends Fragment {


    //private OnFragmentInteractionListener mListener;

    Spinner spinner1;
    Spinner spinner2;
    EditText inputTempET;
    TextView resultTempTV;
    Button convertBT;
    int selectedTemperature1;    //0 celcius, 1 farenheit, 2 kelvin
    int selectedTemperature2;    //0 celcius, 1 farenheit, 2 kelvin



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


    }

    private void setSpinnerListener(){
        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTemperature1 = position;
            }
        });

        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTemperature2 = position;
            }
        });
    }

    private void SetButtonConvertListener(){
        convertBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartConvert();
            }
        });
    }

    private void StartConvert(){

    }

    private void CelciusToFarenheit(){

    }

    private void FarenheitToCelcius(){

    }

    private void KelvinToCelcius(){

    }

    private void CelciusToKelvin(){


    }

    private void KelvinToFarenheit(){

    }

    private void FarenheitToKelvin(){


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
