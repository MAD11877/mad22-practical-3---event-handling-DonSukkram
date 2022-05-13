package sg.edu.np.mad.week3practical_radchanondonsukkramchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String description = "This is a random text being used as the user's description...";
        User newUser = new User("NewUser", description, 1, false);

        Intent receivingEnd = getIntent();
        int userText = receivingEnd.getIntExtra("New Name", 0);
        TextView nameText = findViewById(R.id.nameText);
        nameText.setText(newUser.getName() + String.valueOf(userText));

        TextView descText = findViewById(R.id.descText);
        Button followButton = findViewById(R.id.followButton);
        Button messageButton = findViewById(R.id.messageButton);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Button pressed");

                if (newUser.isFollowed() == false){
                    newUser.setFollowed(true);
                    followButton.setText("Unfollow");

                    Context context = getApplicationContext();
                    CharSequence text = "Followed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    newUser.setFollowed(false);
                    followButton.setText("Follow");
                    Context context = getApplicationContext();
                    CharSequence text = "Unfollowed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(myIntent);
            }
        });
    }
}