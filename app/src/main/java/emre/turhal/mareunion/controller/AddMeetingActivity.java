package emre.turhal.mareunion.controller;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

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
    @BindView(R.id.participant)
    EditText txtParticipant;
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
        (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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


        List<String> nP = new ArrayList<>(4);
        nP.add(txtParticipant.getText().toString());
        nP.add(txtParticipant2.getText().toString());
        nP.add(txtParticipant3.getText().toString());
        nP.add(txtParticipant4.getText().toString());


        Meeting meeting = new Meeting(System.currentTimeMillis(),
                txtTime.getText().toString(),
                txtPlace.getText().toString(),
                txtComment.getText().toString(),
                nP

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
        @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view1, hourOfDay, minute) -> txtTime.setText(mApiService.timePickerToString(hourOfDay, minute)), mHour, mMinute, true);
        timePickerDialog.show();

    }

    public void onValueChange(NumberPicker numberPicker) {

        txtPlace.setText(NumberPickerDialog.pickerVals[numberPicker.getValue()]);

    }

    public void showNumberPicker(View view){
        NumberPickerDialog newFragment = new NumberPickerDialog();
        newFragment.setValueChangeListener((numberPicker, oldVal, newVal) -> onValueChange(numberPicker));
        newFragment.show(getSupportFragmentManager(), "time picker");
    }
}
