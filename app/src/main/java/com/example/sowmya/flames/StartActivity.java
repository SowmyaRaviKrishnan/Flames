package com.example.sowmya.flames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class StartActivity extends AppCompatActivity {
    public InputFragment ip_fragment = new InputFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Log.d("App", "Got Inputs....");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, ip_fragment,"inputs").commit();
    }

    public void clickButton(View view) {
        EditText name1 = (EditText) findViewById(R.id.name1);
        EditText name2 = (EditText) findViewById(R.id.name2);
        String firstname = name1.getText().toString();
        String secondname = name2.getText().toString();
        HashMap countkey1 = new HashMap();
        HashMap countkey2 = new HashMap();
        countkey1 = arrangeEachName(firstname,countkey1);
        countkey2 = arrangeEachName(secondname,countkey2);
        Log.d("APP---countkey:",countkey1.toString()+""+countkey2.toString());
        Set key = countkey1.keySet();
        Iterator i = key.iterator();
        while (i.hasNext()) {
            char  keyvalue = (char)i.next();
            if (countkey2.containsKey(keyvalue)) {
                if ((int) countkey1.get(keyvalue) < (int) countkey2.get(keyvalue)) {
                    countkey2.put(keyvalue, (int) countkey2.get(keyvalue) - (int) countkey1.get(keyvalue));
                } else {
                    countkey2.put(keyvalue, (int) countkey1.get(keyvalue) - (int) countkey2.get(keyvalue));
                }
            } else {
                countkey2.put(keyvalue, (int) countkey1.get(keyvalue));
            }
        }

        Log.d("APP:", countkey2.toString() + " count key");
        int totalcount = 0;
        Set totalkey = countkey2.keySet();
        Iterator i2 = totalkey.iterator();
        while (i2.hasNext()) {
            totalcount = totalcount + (int) countkey2.get(i2.next());
        }
        Log.d("APP:", totalcount + " totalcount");
        Log.d("APP--FLAMES::","");
        if (totalcount != 0) {
            char[] str = flames("flames".toCharArray(), 0, (totalcount - 1), 6);
            int startposition = 0, endposition = str.length - 1;
            char flameletter = '0';
            while (startposition != endposition) {
                if (str[startposition] != '0') {
                    flameletter = str[startposition];
                    break;
                } else if (str[endposition] != '0') {
                    flameletter = str[endposition];
                    break;
                } else {
                    startposition++;
                    endposition--;
                }
            }
            Bundle new1 = new Bundle();
            new1.putChar("value", flameletter);
            ImageFragment image = new ImageFragment();
            image.setArguments(new1);
            if (getSupportFragmentManager().findFragmentByTag("inputs")!=null) {
                Log.d("APP","came into inputs");
                getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag("inputs")).commit();
            }
            if (getSupportFragmentManager().findFragmentByTag("image")!=null) {
                Log.d("APP","came into image");
                getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag("image")).commit();
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, image, "image").commit();


        }
        else{
            if(name1.getText().toString().equals(name2.getText().toString())){
                Toast error = Toast.makeText(getApplicationContext(),"Sorry both the names are same..\nplease Try giving different names",Toast.LENGTH_LONG);
                error.show();
            }
            else{
                Toast wow = Toast.makeText(getApplicationContext(),"Amazing!!!your relationships is like one soul", Toast.LENGTH_LONG);
                wow.show();
            }

        }
        Log.d("App:", "Got " + totalcount);
    }
    public  HashMap arrangeEachName(String name,HashMap countkey){
        for(int i=0;i<name.length();i++){
            if (countkey.containsKey(name.charAt(i))){
                countkey.put(name.charAt(i),(int)countkey.get(name.charAt(i))+1);
            }
            else{
                countkey.put(name.charAt(i),1);
            }
        }

        return countkey;
    }
    public char[] flames(char[]str,int start,int temp,int n){
        Log.d("APP::", Arrays.toString(str));
        if (n==1){
            return str;
        }
        else{
            while(str[start] == '0'){
                start = (start+1)%6;
            }
            int temp1 = (temp%n)+start;
            int i =start;
            while (i < temp1+1){
                if(str[i%6] == '0'){
                    temp1 = temp1+1;
                }
                i=i+1;
            }
            temp1 = temp1%6;
            while (str[temp1] == '0') {
                temp1 = (temp1+1)%6;
            }
            str[temp1] = '0';
            Log.d("APP:::",Arrays.toString(str));
            str = flames(str,(temp1+1)%6,temp,n-1);
            }
        return  str;
        }

}

