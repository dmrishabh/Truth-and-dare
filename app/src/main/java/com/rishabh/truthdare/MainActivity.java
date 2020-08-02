package com.rishabh.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
 public Button button;
 private ImageView imageView;
 private Random random = new Random(); // random decide value bw 0 -- 360
 private int lastDirection; // start point
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
// finding
       button=findViewById(R.id.button);
       imageView=findViewById(R.id.bottle);

   }
   public void spin (View view){
     int newDirection = random.nextInt(3600);

     float pivotX = imageView.getWidth()/2;
     float pivotY = imageView.getHeight()/2;

       Animation rotateImg = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
       rotateImg.setDuration(3000);
       rotateImg.setFillAfter(true);

       rotateImg.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {
               button.setEnabled(false);
           }

           @Override
           public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });

       lastDirection = newDirection;
       imageView.startAnimation(rotateImg);
   }

}