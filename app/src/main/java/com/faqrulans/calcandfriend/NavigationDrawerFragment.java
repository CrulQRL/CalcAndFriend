package com.faqrulans.calcandfriend;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NavigationDrawerFragment extends Fragment {


    Button page1BT;
    Button page2BT;
    Button page3BT;
    Button page4BT;

    private OnFragmentInteractionListener mListener;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        page1BT = (Button) view.findViewById(R.id.page1BT);
        page2BT = (Button) view.findViewById(R.id.page2BT);
        page3BT = (Button) view.findViewById(R.id.page3BT);
        page4BT = (Button) view.findViewById(R.id.page4BT);

        SetButtonClickListener(page1BT,0);
        SetButtonClickListener(page2BT,1);
        SetButtonClickListener(page3BT,2);
        SetButtonClickListener(page4BT,3);


        return view;
    }

    private void SetButtonClickListener(Button button, final int positionValue){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(positionValue);
            }
        });
    }

    public void onButtonPressed(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
