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

