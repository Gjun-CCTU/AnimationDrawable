package com.example.animationdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Drawable s1, s2, s3, s4, s5, s6;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        Resources resources = getResources();
        s1 =  resources.getDrawable(R.drawable.s1);
        s2 =  resources.getDrawable(R.drawable.s2);
        s3 =  resources.getDrawable(R.drawable.s3);
        s4 =  resources.getDrawable(R.drawable.s4);
        s5 =  resources.getDrawable(R.drawable.s5);
        s6 =  resources.getDrawable(R.drawable.s6);
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(s1,300);
        animationDrawable.addFrame(s2,100);
        animationDrawable.addFrame(s3,200);
        animationDrawable.addFrame(s4,300);
        animationDrawable.addFrame(s5,200);
        animationDrawable.addFrame(s6,100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            animationDrawable.setOneShot(false);
            imageView.setBackground(animationDrawable);
        }
        animationDrawable.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(!animationDrawable.isRunning()){
                animationDrawable.start();
            }else{
                animationDrawable.stop();
                Drawable drawable = animationDrawable.getCurrent();
             if(drawable.equals(s1)){
                 textView.setText("點數1");
             }else if(drawable.equals(s2)){
                 textView.setText("點數2");
             }else if(drawable.equals(s3)){
                 textView.setText("點數3");
             }else if(drawable.equals(s4)){
                 textView.setText("點數4");
             }else if(drawable.equals(s5)){
                 textView.setText("點數5");
             }else if(drawable.equals(s6)){
                 textView.setText("點數6" );
             }
            }
        }
        return super.onTouchEvent(event);
    }
}
