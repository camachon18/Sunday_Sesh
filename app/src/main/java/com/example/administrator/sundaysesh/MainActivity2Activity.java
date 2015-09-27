package com.example.administrator.sundaysesh;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity implements View.OnClickListener{


    TextView text;
    Button goBack;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        text = (TextView) findViewById(R.id.text);
        intent = this.getIntent();

        String a = intent.getStringExtra("testing");
        persons b = (persons) intent.getSerializableExtra("person");
        goBack = (Button)findViewById(R.id.goBack);
        goBack.setOnClickListener(this);
        text.setText(a);
    }


    @Override
    public void onClick(View v) {

        intent.putExtra("goBack","yay");
        setResult(1);

        finish();

    }
}
