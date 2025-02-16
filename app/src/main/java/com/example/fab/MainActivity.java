package com.example.fab;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private boolean isFABOpen = false;
    FloatingActionButton fabAction1, fabAction2, fabAction3, fabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.mainFa1);
        fabAction1 = findViewById(R.id.fab11);
        fabAction2 = findViewById(R.id.fab21);
        fabAction3 = findViewById(R.id.fab31);

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    fabMain.setImageResource(R.drawable.close_24px);
                    fabAction1.show();
                    fabAction2.show();
                    fabAction3.show();
                    isFABOpen = true;
                    setAnimation();
                } else {
                    fabMain.setImageResource(R.drawable.share_off_24px);
                    fabAction1.hide();
                    fabAction2.hide();
                    fabAction3.hide();
                    isFABOpen = false;
                    setAnimation();
                }
            }
        });

    }

    private void setAnimation(){

        if(!isFABOpen){
            fabMain.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim));
            fabAction1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_buttom_anim));
            fabAction2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_buttom_anim));
            fabAction3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_buttom_anim));
        }else{
            fabMain.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim));
            fabAction1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.from_buttom_anim));
            fabAction2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.from_buttom_anim));
            fabAction3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.from_buttom_anim));
        }
    }
}


