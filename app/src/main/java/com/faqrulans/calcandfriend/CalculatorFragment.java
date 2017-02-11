package com.faqrulans.calcandfriend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;


public class CalculatorFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;
    ArrayList<String> operationArs;
    ArrayList<String> operationMathArs;

    TextView aritmaticTV;
    TextView operationTV;
    int lastButtonClicked;
    String mathProcess;
    String lastInputNumber;
    String result;
    Button button_dot;
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_c;
    Button button_del;
    Button button_ans;
    Button button_div;
    Button button_mul;
    Button button_sub;
    Button button_add;
    Button button_equals;



    public CalculatorFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        InitVar(view);
        return view;
    }
    
    public void InitVar(View view){

        operationArs = new ArrayList<>();
        operationMathArs = new ArrayList<>();
        mathProcess = "";
        lastInputNumber = "";
        result = "";
        aritmaticTV = (TextView) view.findViewById(R.id.aritmaticTV);
        operationTV = (TextView) view.findViewById(R.id.operationTV);
        button_dot = (Button) view.findViewById(R.id.button_dot);
        button_dot.setOnClickListener(ButtonClickListener());
        button_0 = (Button) view.findViewById(R.id.button_0);
        button_0.setOnClickListener(ButtonClickListener());
        button_1 = (Button) view.findViewById(R.id.button_1);
        button_1.setOnClickListener(ButtonClickListener());
        button_2 = (Button) view.findViewById(R.id.button_2);
        button_2.setOnClickListener(ButtonClickListener());
        button_3 = (Button) view.findViewById(R.id.button_3);
        button_3.setOnClickListener(ButtonClickListener());
        button_4 = (Button) view.findViewById(R.id.button_4);
        button_4.setOnClickListener(ButtonClickListener());
        button_5 = (Button) view.findViewById(R.id.button_5);
        button_5.setOnClickListener(ButtonClickListener());
        button_6 = (Button) view.findViewById(R.id.button_6);
        button_6.setOnClickListener(ButtonClickListener());
        button_7 = (Button) view.findViewById(R.id.button_7);
        button_7.setOnClickListener(ButtonClickListener());
        button_8 = (Button) view.findViewById(R.id.button_8);
        button_8.setOnClickListener(ButtonClickListener());
        button_9 = (Button) view.findViewById(R.id.button_9);
        button_9.setOnClickListener(ButtonClickListener());
        button_c = (Button) view.findViewById(R.id.button_c);
        button_c.setOnClickListener(ButtonClickListener());
        button_del = (Button) view.findViewById(R.id.button_del);
        button_del.setOnClickListener(ButtonClickListener());
        button_ans = (Button) view.findViewById(R.id.button_ans);
        button_ans.setOnClickListener(ButtonClickListener());
        button_div = (Button) view.findViewById(R.id.button_div);
        button_div.setOnClickListener(ButtonClickListener());
        button_mul = (Button) view.findViewById(R.id.button_mul);
        button_mul.setOnClickListener(ButtonClickListener());
        button_sub = (Button) view.findViewById(R.id.button_sub);
        button_sub.setOnClickListener(ButtonClickListener());
        button_add = (Button) view.findViewById(R.id.button_add);
        button_add.setOnClickListener(ButtonClickListener());
        button_equals = (Button) view.findViewById(R.id.button_equals);
        button_equals.setOnClickListener(ButtonClickListener());
        
    }
    
    public View.OnClickListener ButtonClickListener(){
        
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count(v);
            }
        };
        
    }
    
    public void Count(View v) {

        String text = ((Button) v).getText().toString();
        int pressedButtonId = v.getId();

        if (pressedButtonId == button_0.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "0";
            mathProcess += "0";
            
        } else if (pressedButtonId == button_1.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "1";
            mathProcess += "1";


        } else if (pressedButtonId == button_2.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "2";
            mathProcess += "2";


        } else if (pressedButtonId == button_3.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "3";
            mathProcess += "3";


        } else if (pressedButtonId == button_4.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "4";
            mathProcess += "4";


        } else if (pressedButtonId == button_5.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "5";
            mathProcess += "5";


        } else if (pressedButtonId == button_6.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "6";
            mathProcess += "6";


        } else if (pressedButtonId == button_7.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "7";
            mathProcess += "7";


        } else if (pressedButtonId == button_8.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "8";
            mathProcess += "8";


        } else if (pressedButtonId == button_9.getId()) {
            //aritmaticTV.append(text);
            //operationArs.add(text);
            lastInputNumber += "9";
            mathProcess += "9";


        } else if(pressedButtonId == button_dot.getId()){

            if(mathProcess.length() > 0 || lastInputNumber.length() > 0) {
                lastInputNumber += ".";
                mathProcess += ".";
            }

        } else if (pressedButtonId == button_del.getId()) {

            Delete();

        } else if (pressedButtonId == button_ans.getId()) {

            if(!result.equals("")) {
                lastInputNumber += result;
                mathProcess += result;
            }

        } else {

            if(pressedButtonId != lastButtonClicked ) {

                if(mathProcess.length() > 0 || lastInputNumber.length() > 0) {

                    if (pressedButtonId == button_c.getId()) {
                        RemoveAll();
                    } else if (pressedButtonId == button_equals.getId()) {
                        ShowResult();
                    }else {

                        int lengthMathProess = mathProcess.length();
                        String lastIndexChar = mathProcess.substring(lengthMathProess-1, lengthMathProess);

                        if(!isOperator(lastIndexChar)) {

                            if (pressedButtonId == button_div.getId()) {
                                //aritmaticTV.append(text);
                                //operationArs.add(text);
                                operationArs.add(lastInputNumber);
                                operationArs.add("/");
                                mathProcess += "/";
                                lastInputNumber = "";

                            } else if (pressedButtonId == button_mul.getId()) {
                                //aritmaticTV.append(text);
                                //operationArs.add(text);
                                operationArs.add(lastInputNumber);
                                operationArs.add("*");
                                mathProcess += "*";

                                lastInputNumber = "";

                            } else if (pressedButtonId == button_sub.getId()) {
                                //aritmaticTV.append(text);
                                //operationArs.add(text);
                                operationArs.add(lastInputNumber);
                                operationArs.add("-");
                                mathProcess += "-";

                                lastInputNumber = "";

                            } else if (pressedButtonId == button_add.getId()) {
                                //aritmaticTV.append(text);
                                //operationArs.add(text);
                                operationArs.add(lastInputNumber);
                                operationArs.add("+");
                                mathProcess += "+";

                                lastInputNumber = "";

                            }
                        }
                    }
                }
            }

        }


        aritmaticTV.setText(mathProcess);
        lastButtonClicked = pressedButtonId;
    }

    public void RemoveAll(){
        mathProcess = "";
        lastInputNumber = "";
        operationArs.clear();;
        operationMathArs.clear();
    }

    public void ShowResult(){

            int lengthMathProess = mathProcess.length();
            String lastIndexChar = mathProcess.substring(lengthMathProess-1, lengthMathProess);

            if(lastIndexChar.equals(".")){
                mathProcess = mathProcess.substring(0,mathProcess.length() - 1);
                lastInputNumber = lastInputNumber.substring(0, lastInputNumber.length() - 1);
            }



        if(mathProcess.length() > 1) {
            if (!lastInputNumber.equals("")) {
                operationArs.add(lastInputNumber);
            } else {
                int lastIndex = operationArs.size() - 1;
                if (isOperator(operationArs.get(lastIndex))) {
                    operationArs.remove(lastIndex);
                    mathProcess = mathProcess.substring(0, mathProcess.length() - 1);
                    lastInputNumber = operationArs.get(lastIndex - 1);
                }

            }

            String posfix = InfixToPostfixConvert();
            result = Evaluate(operationMathArs);

            aritmaticTV.setText(result);
            //operationArs.remove(operationArs.size() - 1);
            //operationMathArs.clear();
            operationArs.clear();
            operationMathArs.clear();
            lastInputNumber = result;
            mathProcess = result;
        }

        operationTV.setText(mathProcess);

    }
    
    public void Delete(){

        if(mathProcess.length() > 0) {
            char lastChar = mathProcess.charAt(mathProcess.length() - 1);
            if (CekOperator(lastChar)) {
                operationArs.remove(operationArs.size() - 1);
                lastInputNumber = operationArs.get(operationArs.size() - 1);
                operationArs.remove(operationArs.size() - 1);
            } else {
                lastInputNumber = lastInputNumber.substring(0, lastInputNumber.length() - 1);
            }

            mathProcess = mathProcess.substring(0, mathProcess.length() - 1);
        }

    }
    
    public boolean CekOperator(char lastChar){

        if(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/'){
            return true;
        }
        return false;
    }

    public String Evaluate(ArrayList<String> operation){

        Stack<String> stack = new Stack();

        for(int i = 0 ; i < operation.size() ; i++){

            String element = operation.get(i);
            if(isOperator(element)){
                char charElement = element.charAt(0);
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(DoOperation(operand2,operand1, charElement));


            }else{
                stack.push(element);
            }

        }

        return stack.pop();
    }

    public String DoOperation(String op1, String op2, char operation){

        double operand1 = Double.parseDouble(op1);
        double operand2 = Double.parseDouble(op2);
        Double result = new Double(0);


        if(operation == '+'){
            result = operand1 + operand2;
        }else if(operation == '-'){
            result = operand1 - operand2;
        }else if(operation == '*'){
            result = operand1 * operand2;
        }else if(operation == '/'){
            result = operand1 / operand2;
        }

        if ((result == Math.floor(result)) && !Double.isInfinite(result)) {
            return "" + result.intValue();
        }

        return "" + result;

    }

    public boolean isOperator(String element){

        if(element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-")){
            return true;
        }

        return false;


    }


    public String InfixToPostfixConvert(/**String infixBuffer**/)
    {
        int priority = 0;
        String postfixBuffer = "";

        Stack s1 = new Stack();

        for (int i = 0; i < operationArs.size(); i++)
        {
            String ch = operationArs.get(i);
            if (isOperator(ch))
            {
                // check the precedence
                if (s1.size() <= 0)
                    s1.push(ch);
                else
                {
                    String chTop =  "" + s1.peek();
                    if (chTop.equals("*") || chTop.equals("/"))
                        priority = 1;
                    else
                        priority = 0;
                    if (priority == 1)
                    {
                        if (ch.equals("+") || ch.equals("-"))
                        {
                            operationMathArs.add("" + s1.peek());
                            postfixBuffer += s1.pop();
                            i--;
                        }
                        else
                        { // Same
                            operationMathArs.add("" + s1.peek());
                            postfixBuffer += s1.pop();
                            i--;
                        }
                    }
                    else
                    {
                        if (ch.equals("+") || ch.equals("-"))
                        {
                            operationMathArs.add("" + s1.peek());
                            postfixBuffer += s1.pop();
                            s1.push(ch);
                        }
                        else
                            s1.push(ch);
                    }
                }
            }
            else
            {
                operationMathArs.add("" + ch);
                postfixBuffer += ch;
            }
        }
        int len = s1.size();
        for (int j = 0; j < len; j++){
            operationMathArs.add("" + s1.peek());
            postfixBuffer += s1.pop();
        }

        return postfixBuffer;
    }


    /**
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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
        void onFragmentInteraction(Uri uri);
    }**/

}
