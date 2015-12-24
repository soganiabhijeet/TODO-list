package com.myproject.todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadToDoFragment();
        } else {
            FragmentManager manager = getSupportFragmentManager();
            ToDoListFragment toDoListFragment =
                    (ToDoListFragment) manager.findFragmentByTag("ToDoList");
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                addItem();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addItem() {
        FragmentManager manager = getSupportFragmentManager();
        AddToDoItemFragment addToDoItemFragment = new AddToDoItemFragment();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment toDoListFragment = manager.findFragmentByTag("ToDoList");
        addToDoItemFragment.setTargetFragment(toDoListFragment,101);
        if(toDoListFragment != null){
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out,
                    R.anim.fade_in, R.anim.fade_out);

            transaction.remove(toDoListFragment);
            transaction.add(R.id.contentLayout, addToDoItemFragment, "AddToDo");

            transaction.addToBackStack(null);   // to override back button behaviour

            transaction.commit();
        }

    }

    private void loadToDoFragment(){
        ToDoListFragment toDoListFragment = new ToDoListFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contentLayout, toDoListFragment,"ToDoList");
        transaction.commit();
    }

}
