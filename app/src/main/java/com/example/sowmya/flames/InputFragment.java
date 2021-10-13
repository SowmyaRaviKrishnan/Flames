package com.example.sowmya.flames;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sowmya on 3/19/2016.
 */
public class InputFragment extends Fragment {
    public EditText name1;
    public EditText name2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("App", "In fragment");
        View rootview = inflater.inflate(R.layout.input_fragment, container, false);

        EditText name1 = (EditText)rootview.findViewById(R.id.name1);
        EditText name2 = (EditText)rootview.findViewById(R.id.name2);
        name1.setText("");
        name2.setText("");
        this.name1 = name1;
        this.name2 = name2;
        return rootview;
    }



}
