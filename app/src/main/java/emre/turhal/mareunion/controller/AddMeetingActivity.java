package emre.turhal.mareunion.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.di.DI;
import emre.turhal.mareunion.model.Meeting;
import emre.turhal.mareunion.service.MeetingApiService;

public class AddMeetingActivity extends AppCompatActivity {


    @BindView(R.id.my_toolbar2)
    Toolbar   mToolbar;

    @BindView(R.id.in_time)
    EditText txtTime;
    @BindView(R.id.in_place)
    EditText txtPlace;
    @BindView(R.id.in_comment)
    EditText txtComment;
    @BindView(R.id.participant1)
    EditText txtParticipant1;
    @BindView(R.id.participant2)
    EditText txtParticipant2;
    @BindView(R.id.participant3)
    EditText txtParticipant3;
    @BindView(R.id.participant4)
    EditText txtParticipant4;


    private MeetingApiService mApiService;
    private int mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getMeetingApiService();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.create)
    void addMeeting(){
        Meeting meeting = new Meeting(
                System.currentTimeMillis(),

                txtTime.getText().toString(),
                txtPlace.getText().toString(),
                txtComment.getText().toString()
                //Collections.singletonList(txtParticipant1.getText().toString())
                //txtParticipant2.getText().toString(),
                //txtParticipant3.getText().toString(),
                //txtParticipant4.getText().toString()

        );
        mApiService.createMeeting(meeting);
        finish();
    }


    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }


    

    public void  showTimePicker(View view){
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();

    }

    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

        txtPlace.setText(NumberPickerDialog.pickerVals[numberPicker.getValue()]);

    }

    public void showNumberPicker(View view){
        NumberPickerDialog newFragment = new NumberPickerDialog();
        newFragment.setValueChangeListener(this::onValueChange);
        newFragment.show(getSupportFragmentManager(), "time picker");
    }
}
