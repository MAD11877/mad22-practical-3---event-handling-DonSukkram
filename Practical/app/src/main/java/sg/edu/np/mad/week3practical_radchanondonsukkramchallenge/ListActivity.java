package sg.edu.np.mad.week3practical_radchanondonsukkramchallenge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private String TAG = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView androidIcon = findViewById(R.id.android_icon);

        androidIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Button pressed");
                questionUser();

            }
        });
    }

    private int randomInt(){
        Random ran = new Random();
        int ran_int = ran.nextInt(999999);
        return ran_int;
    }

    private void questionUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // launch
                Bundle extras = new Bundle();
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                extras.putInt("New Name", randomInt());
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { }});

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}