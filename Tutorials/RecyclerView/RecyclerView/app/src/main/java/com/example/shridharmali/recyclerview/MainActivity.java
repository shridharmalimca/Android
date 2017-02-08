package com.example.shridharmali.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        studentAdapter = new StudentAdapter(studentList);
        RecyclerView.LayoutManager studentLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(studentLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(studentAdapter);

        getStudentData();
    }

    public void getStudentData() {
        Student stud = new Student("Shridhar");
        studentList.add(stud);

        stud = new Student("Hari");
        studentList.add(stud);

        stud = new Student("Krishna");
        studentList.add(stud);
    }
}
