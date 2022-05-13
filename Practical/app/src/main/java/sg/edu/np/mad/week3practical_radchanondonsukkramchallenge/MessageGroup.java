package sg.edu.np.mad.week3practical_radchanondonsukkramchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Button groupOneButton = findViewById(R.id.group_one_button);
        Button groupTwoButton = findViewById(R.id.group_two_button);
        Fragment textFragment = new TextFragment();
        Fragment imageFragment = new ImageFragment();

        groupOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
                if (!textFragment.isAdded()){
                    fT.add(R.id.frame_layout, textFragment);
                }
                if (imageFragment.isAdded()){
                    fT.remove(imageFragment);
                }
                fT.show(textFragment);

                fT.commit();
            }
        });

        // When group 2 button is clicked
        groupTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                groupTwoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        if (!imageFragment.isAdded()){
                            ft.add(R.id.frame_layout, imageFragment);
                        }
                        if (textFragment.isAdded()){
                            ft.remove(textFragment);
                        }
                        ft.show(imageFragment);

                        ft.commit();
                    }
                });
            }
        });
    }
}