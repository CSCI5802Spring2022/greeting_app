package edu.umn.cs.csci5802.greeting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String LOWER = "lower";
    public static final String UPPER = "upper";
    public static final String NO_MOD = "no_mod";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void display(View view){
        EditText nameView = (EditText) findViewById(R.id.name);
        String nameText = "";
        if(nameView.getText()==null){
            nameText = "";
        }
        else {
            if (view.getId() == R.id.displayLower) {
                nameText = processName(MainActivity.LOWER, nameView);
            } else if (view.getId() == R.id.displayUpper) {
                nameText = processName(MainActivity.UPPER, nameView);
            } else {
                nameText = processName(MainActivity.NO_MOD, nameView);
            }
        }
        Intent message = new Intent(getApplicationContext(), DisplayActivity.class);
        message.setAction("edu.umn.cs.csci5802.greeting.DISPLAY");
        message.putExtra("message", nameText);
        startActivity(message);
    }

    public String processName(String type, EditText nameView){
        String name = nameView.getText().toString();
        String processedName="";
        if(type.equals(MainActivity.LOWER)){
            processedName = name.toLowerCase().trim();
        }
        else if(type.equals(MainActivity.UPPER)){
            processedName = name.toUpperCase().trim();
        }
        else{
            processedName = name.trim();
        }
        return processedName;
    }
}

