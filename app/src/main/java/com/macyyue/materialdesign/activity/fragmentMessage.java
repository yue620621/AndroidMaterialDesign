package com.macyyue.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.macyyue.materialdesign.R;

/**
 * Created by mingxin_yue on 2016-09-01.
 */
public class fragmentMessage extends Fragment{

    public fragmentMessage(){

    }

    //onCreate(Bundle) called to do initial creation of the fragment
    @Override
    public void onCreate(Bundle savedInstanceState){
        //super keyword refers to the immediate parents property.
        super.onCreate(savedInstanceState);
    }

    //onCreateView(LayoutInflater, ViewGroup, Bundle)
    // creates and returns the view hierarchy associated with the fragment.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        return rootView;
    }

    //onAttach(Activity) called once the fragment is associated with its activity
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    //onDetach() called immediately prior to the fragment no longer being associated with its activity.
    @Override
    public void onDetach(){
        super.onDetach();
    }

}
