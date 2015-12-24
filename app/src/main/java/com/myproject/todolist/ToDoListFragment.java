package com.myproject.todolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends Fragment {

    ListView toDoListView;
    ArrayList<ToDoItem> toDoItems;

    public ToDoListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toDoItems = new ArrayList<ToDoItem>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        toDoListView = (ListView) fragView.findViewById(R.id.listView);
        toDoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToDoItemViewFragment itemViewFragment = new ToDoItemViewFragment();
                ToDoItem item = toDoItems.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ITEM", item);
                itemViewFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(ToDoListFragment.this);
                fragmentTransaction.add(R.id.contentLayout, itemViewFragment, "ITEMVIEW");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return fragView;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }

    public void updateList() {
        
    }

}
