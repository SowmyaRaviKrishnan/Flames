package com.example.sowmya.flames;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sowmya.flames.R;

/**
 * Created by sowmya on 3/19/2016.
 */
public class ImageFragment extends Fragment{
    public String FRIENDS = "FRIENDS";
    public String LOVE = "LOVE";
    public String MARRIAGE = "MARRIAGE";
    public String ENEMY = "ENEMY";
    public String SISTER = "SISTER";
    public String AFFECTION = "AFFECTION";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("App","In fragment");
        View rootview = inflater.inflate(R.layout.image_fragment, container, false);
        Bundle args = getArguments();
        Log.d("App","Got info from bundle"+args.getChar("value"));
        TextView title = (TextView)rootview.findViewById(R.id.textView3);
        ImageView im =  (ImageView)rootview.findViewById(R.id.imageView);
        title.bringToFront();
        char flameletter = args.getChar("value");
        switch (flameletter){
            case  'f':
                title.setText(FRIENDS);
                im.setImageResource(R.drawable.f);
                break;
            case 'l':
                title.setText(LOVE);
                im.setImageResource(R.drawable.l);
                break;
            case 'a':
                title.setText(AFFECTION);
                im.setImageResource(R.drawable.a);
                break;
            case 'm':
                title.setText(MARRIAGE);
                im.setImageResource(R.drawable.m);
                break;
            case 'e':
                title.setText(ENEMY);
                im.setImageResource(R.drawable.e);
                break;
            case 's':
                title.setText(SISTER);
                im.setImageResource(R.drawable.s);
                break;

        }
        return rootview;
    }


}
