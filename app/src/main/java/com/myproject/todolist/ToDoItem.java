package com.myproject.todolist;

import android.os.Parcelable;

import java.io.Serializable;
import java.sql.Time;

/**
 * Created by gaurav.gs on 15/12/15.
 */
@SuppressWarnings("serial")
public class ToDoItem implements Serializable {

    private String title;
    private String discription;
    private Time dueTime;
    private int priority;

    public ToDoItem(String title, String discription) {
        this.title = title;
        this.discription = discription;
        this.dueTime = dueTime;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Time getDueTime() {
        return dueTime;
    }

    public void setDueTime(Time dueTime) {
        this.dueTime = dueTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
