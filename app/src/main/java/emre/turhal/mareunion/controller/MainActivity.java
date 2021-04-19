package emre.turhal.mareunion.controller;

import android.app.TimePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.Utils.TimeUtils;
import emre.turhal.mareunion.events.FilterMeetingEventByPlace;
import emre.turhal.mareunion.events.FilterMeetingEventByTime;

public class
MainActivity extends AppCompatActivity {


    @BindView((R.id.my_toolbar))
    Toolbar mToolbar;


    private MeetingFragment mMeetingFragment;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

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

        int mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);


        switch (item.getItemId()){


            case (R.id.filter_time):


                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        (view, hourOfDay, minute) -> EventBus.getDefault().post(new FilterMeetingEventByTime(TimeUtils.timePickerToString(hourOfDay, minute))), mHour, mMinute, true);
                timePickerDialog.show();
                return true;

            case (R.id.filter_place):

                NumberPickerDialog newFragment = new NumberPickerDialog();
                newFragment.setValueChangeListener(this::onValueChange);
                newFragment.show(getSupportFragmentManager(), "time picker");

                return true;

            case (R.id.no_filter):

                mMeetingFragment.initList();




        }
        return super.onOptionsItemSelected(item);
    }


    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

        EventBus.getDefault().post(new FilterMeetingEventByPlace(NumberPickerDialog.pickerVals[numberPicker.getValue()]));

    }

    @OnClick({R.id.add_meeting})
    void addMeeting() {
        AddMeetingActivity.navigate(this);
    }

}




