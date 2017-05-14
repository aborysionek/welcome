package pl.sda.android.applicationcv;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.annotation.Annotation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class Experience extends AppCompatActivity {
    @BindView(R.id.exp1)
    ImageView logo1;
    @BindView(R.id.exp2)
    ImageView logo2;
    @BindView(R.id.exp3)
    ImageView logo3;
    @BindView(R.id.exp4)
    ImageView logo4;
    @BindView(R.id.exp5)
    ImageView logo5;
    @BindView(R.id.exp6)
    ImageView logo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo1exp, Toast.LENGTH_LONG).show();
            }
        });

        logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo2exp, Toast.LENGTH_LONG).show();
            }
        });

        logo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo3exp, Toast.LENGTH_LONG).show();
            }
        });

        logo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo4exp, Toast.LENGTH_LONG).show();
            }
        });

        logo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo5exp, Toast.LENGTH_LONG).show();
            }
        });

        logo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, R.string.logo6exp, Toast.LENGTH_LONG).show();
            }
        });

    }
}
