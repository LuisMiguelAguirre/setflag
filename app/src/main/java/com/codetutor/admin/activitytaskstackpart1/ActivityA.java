package com.codetutor.admin.activitytaskstackpart1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityA extends BaseActivity {


    public static int counter = 0;

    public ActivityA() {
        super();
        counter++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        TextView textView = findViewById(R.id.tvNumTask);
        textView.setText(showNumberTask());

        TextView textView1 = findViewById(R.id.tvNumInstances);
        textView1.setText(String.valueOf(counter));
    }
}
