package com.codetutor.admin.activitytaskstackpart1;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        showNumberTask();
    }

    public void goToActivityA(View view) {
        getIntent(this, ActivityA.class);

    }

    public void goToActivityC(View view) {
        getIntent(this, ActivityC.class);

    }

    public void goToActivityB(View view) {
        getIntent(this, ActivityB.class);

    }

    public void goToActivityD(View view) {
        getIntent(this, ActivityD.class);
    }

    protected String showNumberTask() {
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(10);

        StringBuilder list = new StringBuilder();

        String topActivity = "";
        String numActivities = "";
        String baseActivity = "";
        for (ActivityManager.RunningTaskInfo runningTaskInfo : tasks) {

            numActivities = String.valueOf(runningTaskInfo.numActivities);
            topActivity = runningTaskInfo.topActivity.getClassName();

            baseActivity = runningTaskInfo.baseActivity.getClassName();

            break;
        }

        list.append("Num tasks: ");
        list.append(tasks.size());
        list.append("\n");
        list.append("Top Activity: ");
        list.append(topActivity);
        list.append("\n");
        list.append("Base activity: ");
        list.append(baseActivity);
        list.append("\n");
        list.append("Num activities: ");
        list.append(numActivities);

        return list.toString();
    }

    private void getIntent(Activity currentActivity, Class nextActivity) {
        Intent intent = new Intent(currentActivity, nextActivity);

        if (nextActivity.equals(ActivityB.class)) {

            //TODO UNCOMMENT ONE INTENT TO TEST THE BEHAVIOR

            //if the activity is on the top does not create a new one, if it is not so, create a new one
            //behavior is exactly the same that singleTop in manifest
            //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

            //working as standard mode, it is creating a new instances every time
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //Clear the top but creates a new instances, not reuse the same instances
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Nothing happened... needed to be tested with more task
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            //Reuse the instances and remove all the instances on the top of the stack
            //This is similar to singleTask without affinity
            //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Remove the top of the stack until the position of the instances but creates a new one of it
            //rather than reuse the instance.
            //There is no difference with CLEAR_TOP, because NEW_TASK doesn't work as expected if in the manifest there is not affinity
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //if the activity has taskAffinity then creates a new task and reuse the instance
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(intent);
    }
}
