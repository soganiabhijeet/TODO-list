package com.flipkart.todolistbeta;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddToDoFragment extends Fragment {

    EditText titleEditText;
    EditText descriptionEditText;
    Button doneButton;
    Button cancelButton;

    public AddToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView =  inflater.inflate(R.layout.fragment_add_to_do, container, false);

        titleEditText = (EditText) fragView.findViewById(R.id.editText);
        descriptionEditText = (EditText) fragView.findViewById(R.id.editText2);
        doneButton = (Button) fragView.findViewById(R.id.button2);
        cancelButton = (Button) fragView.findViewById(R.id.button3);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                ToDoItem item = new ToDoItem(title, description);
                Intent intent = new Intent();
                intent.putExtra("ITEM",item);
                getTargetFragment().onActivityResult(101, Activity.RESULT_OK, intent);
                FragmentManager manager = getFragmentManager();
                manager.popBackStack();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                manager.popBackStack();
            }
        });
        return fragView;
    }

}
