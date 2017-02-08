# RecyclerView 

**Steps:**

1) Create new project New -> New Project
![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step1.png)

2) 
![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step2.png)

3) 
![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step3.png)

4) 
![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step4.png)

5) open build.gradle(Module:app) and add dependancy

**compile 'com.android.support:recyclerview-v7:25.1.0'** 

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step5.png)

6) In activity_main.xml file 

```

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.shridharmali.recyclerview.MainActivity">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical" >
    </android.support.v7.widget.RecyclerView>


</RelativeLayout>


```

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step6.png)



7) Create Adapter class:

**Adapter** : 

A subclass of RecyclerView.Adapter responsible for providing views that represent items in a data set.
	
**position** :

The position of a data item within an Adapter.
	
**Recycle (view)** :

   A view previously used to display data for a specific adapter position may be placed in a cache for later reuse to display the same type of data again later. This can drastically improve performance by skipping initial layout inflation or construction.
   
8) Create item_list.xml resource file, this resource file used create fields in the recycler view.

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step8.png)

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step8-1.png)

9) Replace item_list.xml file 

```

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:focusable="true"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:paddingTop="10dp"
    android:paddingBottom="10dp"
    android:clickable="true"
    android:background="?android:attr/selectableItemBackground"
    android:orientation="vertical">

    <TextView
        android:id="@+id/name"
        android:textColor="#c73164"
        android:textSize="16dp"
        android:textStyle="bold"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentStart="true" />


</RelativeLayout>

```

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step9.png)

10) Create a model java class for **Student** 

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step10.png)

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step10-1.png)


11) Create accessor and mutator method for Student name.

```

public class Student {
    private String name;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step11.png)
	
12) Now, Create Adpater class for RecyclerView 

Name it **Student** and superclass **android.support.v7.widget.RecyclerView**

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step12.png)

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step12-1.png)


13) Changes in the StudentAdapter class.

**From**

```

public class StudentAdapter extends RecyclerView{

}

```

**To**

```

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {


}

```

**Add below method in student Adpater class for extend MyViewHolder from RecyclerView.ViewHolder **

```

public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public MyViewHolder(View view) {
            super(view);
        }
    }


```

**Override RecyclerView method**

- onCreateViewHolder() : create View(Cell). 
- onBindViewHolder() : used when list view bind with data
- getItemCount() : Used for get / set the size of the student list.

**Complete code**

```

package com.example.shridharmali.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shridharmali on 2/8/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        // Constructor
        this.studentList = studentList;
    }

    // Override  onCreateViewHolder method
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student stud = studentList.get(position);
        holder.name.setText(stud.getName());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public MyViewHolder(View view) {
            super(view);
            name = (TextView)view.findViewById(R.id.name);
        }
    }
}

```


14) Come back to MainActivity java class and declare 

```
	private List<Student> studentList = new ArrayList<>();   
	private RecyclerView recyclerView;   
	private StudentAdapter studentAdapter;
    
```

15) In onCreate() Method 

```
	recyclerView = (RecyclerView)findViewById(R.id.recycler_view);            
	patientAdapter = new PatientAdapter(patientList);
	RecyclerView.LayoutManager patientLayoutManager = new LinearLayoutManager(getApplicationContext());
	recyclerView.setLayoutManager(patientLayoutManager);
	recyclerView.setHasFixedSize(true);
	recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
	recyclerView.setItemAnimator(new DefaultItemAnimator());
	recyclerView.setAdapter(patientAdapter);
            
```


**Code looks like in MainActivity java class

```

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
    }
}


```

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step15.png)

**RecyclerView will looks like following image**

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step15-1.png)


16) Add more student names so we get the proper list view

```

public void getStudentData() {
        Student stud = new Student("Shridhar");
        studentList.add(stud);

        stud = new Student("Hari");
        studentList.add(stud);

        stud = new Student("Krishna");
        studentList.add(stud);
    }
    
```

![](https://github.com/shridharmalimca/Android/blob/master/Tutorials/RecyclerView/Step16.png)

17) In above output image shows recyclerview with some item but not looks what we expect to look like TableView in iOS or like proper list view with separators, For add separator in list we have to use ***RecyclerView.ItemDecoration***


18) Add DeviderItemDecoration java class which is extends from RecyclerView.ItemDecoration.

**Complete Code**

```

package com.example.shridharmali.appointment;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[] {
            android.R.attr.listDivider
    };


    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable pDevider;
    private int pOrientation;

    public DividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        pDevider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST  && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("Illegal Orientation");
        }

        pOrientation = orientation;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (pOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }

    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right =  parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + pDevider.getIntrinsicHeight();
            pDevider.setBounds(left, top, right, bottom);
            pDevider.draw(c);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + pDevider.getIntrinsicHeight();
            pDevider.setBounds(left, top, right, bottom);
            pDevider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (pOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, pDevider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, pDevider.getIntrinsicWidth(), 0);
        }
    }
}


```

![]()

![]()



19) **Output**

![]()



