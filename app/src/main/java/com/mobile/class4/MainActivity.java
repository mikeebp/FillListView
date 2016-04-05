package com.mobile.class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


    ListView list;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        spinner = (Spinner) findViewById(R.id.spinner);

        //Adapter - class that translates a strucutre into a group UI Widget
        String[] students = {"Zamora", "Enciso", "Miguel", "Noe"};
        String[] secondArray = getResources().getStringArray(R.array.myArray);


        ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, secondArray);


        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Andrés", "ISC", 65));
        studentList.add(new Student("Mario", "ISC", 62));
        studentList.add(new Student("Zamora", "ISC", 25));
        studentList.add(new Student("Mike", "ISC", 99.4999999F));

        MyAdapter newAdapter = new MyAdapter(this, studentList);

        spinner.setAdapter(newAdapter);
        list.setAdapter(newAdapter);
        ListView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.d("ITEM CLICK", position + "");
        new JSONRequest(this).execute("http://jsonplaceholder.typicode.com/posts");



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
