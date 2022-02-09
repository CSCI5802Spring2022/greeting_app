package edu.umn.cs.csci5802.greeting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView messageView = (TextView) findViewById(R.id.message);
        Intent message = getIntent();
        String messageText = message.getStringExtra("message");
        messageView.setText("Hello "+messageText+"!");
    }
}



