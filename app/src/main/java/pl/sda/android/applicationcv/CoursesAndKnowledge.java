package pl.sda.android.applicationcv;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursesAndKnowledge extends AppCompatActivity {
@BindView(R.id.course_androids)
    ImageView android;
    @BindView(R.id.course_androids_burning)
    ImageView androidBurning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_and_knowledge);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        androidBurning.setVisibility(View.GONE);

        animatingAndroidDroid();
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.setVisibility(View.GONE);
                androidBurning.setVisibility(View.VISIBLE);
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.kenny);
                mediaPlayer.start();
            }
        });
    }

    private void animatingAndroidDroid() {
        AlphaAnimation blinkanimation= new AlphaAnimation(1, 0);
        blinkanimation.setDuration(6000);
        blinkanimation.setInterpolator(new LinearInterpolator());
        blinkanimation.setRepeatCount(6);
        blinkanimation.setRepeatMode(Animation.REVERSE);
        android.startAnimation(blinkanimation);
    }

}
