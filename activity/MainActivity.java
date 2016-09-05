package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import edu.feicui.app.phone.base.db.BaseActivity;
import edu.feicui.app.phone.service.MusicService;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.one);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alphaone);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Intent intent1 = new Intent(MainActivity.this, MusicService.class);
                startService(intent1);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this, LeadActivity.class);
                startActivity(intent);
                Intent musicIntent = new Intent(MainActivity.this, MusicService.class);
                stopService(musicIntent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView1.setAnimation(animation);
        imageView1.startAnimation(animation);
    }
}
