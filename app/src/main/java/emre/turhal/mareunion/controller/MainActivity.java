package emre.turhal.mareunion.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;

public class
MainActivity extends AppCompatActivity {


    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;


    ListMeetingPagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }


    @OnClick(R.id.add_meeting)
    void addMeeting() {
        AddMeetingActivity.navigate(this);
    }
}

// afficher les mail que dans un seul textview passer une liste de participat en parametre de mEeting

    // android:ellipsize="end" ajouter dans textview pour afficher les mails

// filtrer par heure et par lieu la liste des meetings




//https://developer.android.com/guide/topics/ui/dialogs#AddingAList


