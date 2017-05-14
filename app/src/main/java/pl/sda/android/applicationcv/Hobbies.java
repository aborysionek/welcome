package pl.sda.android.applicationcv;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Hobbies extends AppCompatActivity {

    @BindView(R.id.hobbies_1)
    ImageView programowanie;
    @BindView(R.id.hobbies_2)
    ImageView filmy;
    @BindView(R.id.hobbies_3)
    ImageView podroze;
    @BindView(R.id.hobbies_4)
    ImageView multiplayer;
    @BindView(R.id.hobbies_5)
    ImageView ksiazki;
    @BindView(R.id.hobbies_6)
    ImageView grafika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        programowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.programming, Toast.LENGTH_LONG).show();
            }
        });
        filmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.movies_cinema, Toast.LENGTH_LONG).show();
            }
        });
        podroze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.travelling_places, Toast.LENGTH_LONG).show();
            }
        });
        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.games_n_multiplayer, Toast.LENGTH_LONG).show();
            }
        });
        ksiazki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.good_book, Toast.LENGTH_LONG).show();
            }
        });
        grafika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hobbies.this, R.string.graphics_design, Toast.LENGTH_LONG).show();
            }
        });
    }

}
