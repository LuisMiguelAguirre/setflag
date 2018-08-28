package com.codetutor.admin.activitytaskstackpart1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityC extends BaseActivity {

    public static int counter = 0;

    public ActivityC() {
        super();
        counter++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        TextView textView = findViewById(R.id.tvNumTask);
        textView.setText(showNumberTask());

        TextView textView1 = findViewById(R.id.tvNumInstances);
        textView1.setText(String.valueOf(counter));
    }

}
