package com.example.yvtc.yvtc2017111302;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yvtc.yvtc2017111302.data.Student;
import com.example.yvtc.yvtc2017111302.data.StudentDAOTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentDAOTest1 t = new StudentDAOTest1();
        t.add(new Student("Bob", "123", "aabb"));
        t.add(new Student("Mary", "234", "ccdd"));

        ArrayList<Student> mylist = t.getData();
        for (Student s: mylist)
        {
            Log.d("DATAS", s.toString());
        }
    }
}
