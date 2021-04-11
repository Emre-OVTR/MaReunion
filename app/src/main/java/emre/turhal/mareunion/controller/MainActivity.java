package emre.turhal.mareunion.controller;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.Utils.TimeUtils;
import emre.turhal.mareunion.di.DI;
import emre.turhal.mareunion.events.FilterMeetingEventByPlace;
import emre.turhal.mareunion.events.FilterMeetingEventByTime;
import emre.turhal.mareunion.model.Meeting;
import emre.turhal.mareunion.service.MeetingApiService;

public class
MainActivity extends AppCompatActivity {


    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;






    int mHour, mMinute;
    private MeetingApiService mApiService;
    private MeetingFragment mMeetingFragment;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mApiService = DI.getMeetingApiService();


        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_baseline_filter_list_24);
        mToolbar.setOverflowIcon(drawable);

        this.configureAndShowMainFragment();

    }

    private void configureAndShowMainFragment(){

        mMeetingFragment = (MeetingFragment) getSupportFragmentManager().findFragmentById(R.id.container);

        if (mMeetingFragment == null) {
            mMeetingFragment = new MeetingFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mMeetingFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch (item.getItemId()){
            case R.id.filter_list:

                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                EventBus.getDefault().post(new FilterMeetingEventByTime(TimeUtils.timePickerToString(hourOfDay, minute)));

                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();
                return true;

            case R.id.filter_place:

                NumberPickerDialog newFragment = new NumberPickerDialog();
                newFragment.setValueChangeListener(this::onValueChange);
                newFragment.show(getSupportFragmentManager(), "time picker");

                return true;

            case R.id.no_filter:

                mMeetingFragment.onResume();




        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.add_meeting)
    void addMeeting() {
        AddMeetingActivity.navigate(this);
    }

    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

        EventBus.getDefault().post(new FilterMeetingEventByPlace(NumberPickerDialog.pickerVals[numberPicker.getValue()]));

    }



}




