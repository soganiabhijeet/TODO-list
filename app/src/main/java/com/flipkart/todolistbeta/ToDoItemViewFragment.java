package com.flipkart.todolistbeta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class ToDoItemViewFragment extends Fragment {

    EditText titleEditText;
    EditText descriptionEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_to_do_item_view, container, false);
        //get access to arguments of that were passed to this fragment
        Bundle bundle = getArguments();
        ToDoItem item = (ToDoItem) bundle.getParcelable("ITEM");
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(item.getTitle());
        titleEditText.setText(sBuffer);
        sBuffer = new StringBuffer();
        sBuffer.append(item.getDiscription());
        descriptionEditText.setText(sBuffer);
        return fragView;
    }
}
