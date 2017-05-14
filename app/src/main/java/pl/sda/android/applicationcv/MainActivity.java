package pl.sda.android.applicationcv;

import android.app.Application;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.i_am_connected_icon)
    ImageView connected_icon;
    @BindView(R.id.i_am_not_connected_icon)
    ImageView not_connected_icon;
    @BindView(R.id.i_am_connected)
    TextView connected_text;
    @BindView(R.id.i_am_not_connected)
    TextView not_connected_text;
    @BindView(R.id.main_act_login)
    EditText mylogin;
    @BindView(R.id.main_act_password)
    EditText mypassword;
    @BindView(R.id.fab)

    FloatingActionButton floatingActionButton;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        showThatYoureNotConnected();
        setFloatButton();
        setDrawer();
        settingNavigationItemSelectedListener();
        playWelcomeSound();
    }

    private void playWelcomeSound() {
        if(getString(R.string.locale).equals("pl")){
        MediaPlayer welcomeSound = MediaPlayer.create(getApplication(), R.raw.plwelcome);
            welcomeSound.start();}
        else{MediaPlayer welcomeSound = MediaPlayer.create(getApplication(), R.raw.engwelcome);
            welcomeSound.start();}
    }

    private void settingNavigationItemSelectedListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setFloatButton() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mypassword.getText().toString().equals("rekrutacja2017") && mylogin.getText().toString().equals("rekruter")){
                    showThatYoureConnected();
                    playBeep();
                }else{
                    showThatYoureNotConnected();
                    Snackbar.make(view, R.string.wrong_pass, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                    playBeeper();
            }}

            private void playBeeper() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.beeper);
                mediaPlayer.start();
            }

            private void playBeep() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplication(), R.raw.beep);
                mediaPlayer.start();
            }

            private void showThatYoureConnected() {
                connected_icon.setVisibility(View.VISIBLE);
                connected_text.setVisibility(View.VISIBLE);
                not_connected_icon.setVisibility(View.GONE);
                not_connected_text.setVisibility(View.GONE);
            }
        });
    }

    private void showThatYoureNotConnected() {
        connected_icon.setVisibility(View.GONE);
        connected_text.setVisibility(View.GONE);
        not_connected_icon.setVisibility(View.VISIBLE);
        not_connected_text.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_experience) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                startActivity(new Intent(this, Experience.class));
            }
        } else if (id == R.id.nav_education) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                startActivity(new Intent(this, EducationAndLanguages.class));
            }
        } else if (id == R.id.nav_knowledge) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                startActivity(new Intent(this, CoursesAndKnowledge.class));
            }
        } else if (id == R.id.nav_hobbies) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                startActivity(new Intent(this, Hobbies.class));
            }
        } else if (id == R.id.nav_sendmail) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "adrianborysionek@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.recruit));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body));
                startActivity(Intent.createChooser(intent, getString(R.string.send_email2)));
            }
        } else if (id == R.id.nav_sendsms) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", getString(R.string.telephone_number), null)));
            }
        } else if (id == R.id.nav_callme) {
            if(mylogin.getText().toString().equals("rekruter") && mypassword.getText().toString().equals("rekrutacja2017")){
                uri = Uri.parse("tel:" + getString(R.string.telephone_number));
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
