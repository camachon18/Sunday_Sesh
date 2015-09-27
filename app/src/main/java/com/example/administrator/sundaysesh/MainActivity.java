package com.example.administrator.sundaysesh;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    Button AddAPerson;
    TextView oNameOfPerson;
    TextView oStatOfPerson;
    EditText iNameOfPerson;
    EditText iStatOfPerson;
    Spinner PersonSpinner;

    ArrayList<String> course;

    HashMap<String, persons> holder;

    persons p1;

    Button goOn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = new persons();
        p1.name = "Hi There";
        p1.stat1= "-1";
        course = new ArrayList<String>();
        course.add("hi there");

        holder = new HashMap<String,persons>();
        holder.put("Hi There", p1);

        goOn = (Button) findViewById(R.id.GoOn);
        goOn.setOnClickListener(this);


        AddAPerson = (Button) findViewById(R.id.AddAPerson);
        AddAPerson.setOnClickListener(this);
        oNameOfPerson=(TextView) findViewById(R.id.oNameofPerson);;
        oStatOfPerson= (TextView) findViewById(R.id.oStatOfPerson);;
        iNameOfPerson= (EditText) findViewById(R.id.NameOfPerson);;
        iStatOfPerson= (EditText) findViewById(R.id.StatOfPerson);;
        PersonSpinner= (Spinner) findViewById(R.id.PersonSpinner);;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,course);
        PersonSpinner.setAdapter(adapter);
        PersonSpinner.setOnItemSelectedListener(this);
        //onSelect action used when you click something from spinner drop down

        course.add("bob");

    }


    @Override
    public void onClick(View v) {
        if (v == AddAPerson)
        {

            persons pTemp = new persons();
            pTemp.name = iNameOfPerson.getText().toString();
            pTemp.stat1 = iStatOfPerson.getText().toString();
            holder.put(iNameOfPerson.getText().toString(),pTemp);
            course.add(iNameOfPerson.getText().toString());

        }
        if (v == goOn)
        {
            Intent intent = new Intent(this,MainActivity2Activity.class);
            intent.putExtra("testing","This is my string");

            intent.putExtra("person",p1);

            intent.putExtra("table",holder);

            startActivityForResult(intent, 100);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == 100){
            if (resultCode == 1){
                String a = data.getStringExtra("goBack");
                oNameOfPerson.setText(a);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (view == PersonSpinner)
        {

            persons pTemp = holder.get(PersonSpinner.getSelectedItem().toString())
            oNameOfPerson.setText(pTemp.name);
            oStatOfPerson.setText(pTemp.stat1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
