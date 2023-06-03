package com.example.syncope;


import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorListenerAdapter;


import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setVisibility(View.VISIBLE);

        animateBackground();
        animateText();

    }

    private void animateBackground() {
        Animation shrinkAnimation = AnimationUtils.loadAnimation(this, R.anim.shrink_animation);
        shrinkAnimation.setDuration(2000);
        shrinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setWhiteBackground();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        findViewById(R.id.activity_main).startAnimation(shrinkAnimation);
    }

    private void setWhiteBackground() {
        findViewById(R.id.activity_main).setBackground(new ColorDrawable(getResources().getColor(android.R.color.white)));
    }

    private void animateText() {
        textView.animate()
                .alpha(1f)
                .scaleX(1.5f)
                .scaleY(1.5f)
                .setDuration(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        textView.setVisibility(TextView.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        rotateText();
                    }
                })
                .start();
    }

    private void rotateText() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        textView.startAnimation(rotateAnimation);

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.animate()
                        .alpha(0f)
                        .setDuration(1250)
                        .start();
                neww();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

}
private void neww()
    {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
}