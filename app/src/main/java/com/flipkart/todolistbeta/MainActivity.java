package com.flipkart.todolistbeta;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            loadToDoListFragment();
        }
        else {
            FragmentManager fManager = getSupportFragmentManager();
            ToDoListFragment toDoListFragment =
                    (ToDoListFragment) fManager.findFragmentByTag("ToDoList");

        }
    }

    private void loadToDoListFragment() {
        ToDoListFragment toDoListFragment = new ToDoListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainLayout, toDoListFragment, "ToDoList");
        fragmentTransaction.commit();
    }


}
