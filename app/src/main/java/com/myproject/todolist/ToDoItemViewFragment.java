package com.myproject.todolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoItemViewFragment extends Fragment {

    TextView titleTextView;


    public ToDoItemViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_to_do_item_view, container, false);
        Bundle bundle = getArguments();
        ToDoItem item = (ToDoItem) bundle.getParcelable("ITEM");
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(item.getTitle());
        titleTextView.setText(sBuffer);
        return fragView;

    }

}
