package emre.turhal.mareunion.controller;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;

public class
MainActivity extends AppCompatActivity {


    @BindView(R.id.container)
    ViewPager mViewPager;


    ListMeetingPagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

    }

    @OnClick(R.id.add_meeting)
    void addNeighbour() {
        AddMeetingActivity.navigate(this);
    }
}