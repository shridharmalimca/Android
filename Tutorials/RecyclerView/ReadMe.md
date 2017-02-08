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

![]()
