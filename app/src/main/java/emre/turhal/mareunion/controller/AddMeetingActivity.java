package emre.turhal.mareunion.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.Utils.TimeUtils;
import emre.turhal.mareunion.Utils.ToastUtils;
import emre.turhal.mareunion.di.DI;
import emre.turhal.mareunion.model.Meeting;
import emre.turhal.mareunion.service.MeetingApiService;

public class AddMeetingActivity extends AppCompatActivity {


    @BindView((R.id.my_toolbar2))
    Toolbar mToolbar;
    @BindView((R.id.in_time))
    EditText txtTime;
    @BindView((R.id.in_date))
    EditText txtDate;
    @BindView((R.id.in_place))
    EditText txtPlace;
    @BindView((R.id.in_comment))
    EditText txtComment;
    @BindView((R.id.participant))
    EditText txtParticipant;
    @BindView((R.id.participant2))
    EditText txtParticipant2;
    @BindView((R.id.participant3))
    EditText txtParticipant3;
    @BindView((R.id.participant4))
    EditText txtParticipant4;




    private MeetingApiService mApiService;
    private static CharSequence dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getMeetingApiService();
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }


    @OnClick({R.id.time_btn, R.id.in_time})
    public void showTimePicker(View view) {

        int mHour, mMinute;
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view1, hourOfDay, minute) -> txtTime.setText(TimeUtils.timePickerToString(hourOfDay, minute)), mHour, mMinute, true);
        timePickerDialog.show();


    }

    @OnClick({R.id.date_btn, R.id.in_date})
    public void showDatePicker(View view) {

        final Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year, month, date) -> {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, month);
            calendar1.set(Calendar.DATE, date);
            dateText = DateFormat.format("dd/MM/yyyy", calendar1);
            txtDate.setText(dateText);

        }, YEAR, MONTH, DATE);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    @OnClick({R.id.place_btn, R.id.in_place})
    public void showNumberPicker(View view) {
        NumberPickerDialog newFragment = new NumberPickerDialog();
        newFragment.setValueChangeListener((numberPicker, oldVal, newVal) -> txtPlace.setText(NumberPickerDialog.pickerVals[numberPicker.getValue()]));
        newFragment.show(getSupportFragmentManager(), "time picker");
    }


    @OnClick({R.id.create})
    void addMeeting() {


        if (txtTime.getText().toString().equals("")) {
            ToastUtils.showToastLong(getString(R.string.time_choose), getApplicationContext());
            } else if (txtDate.getText().toString().equals("")) {
            ToastUtils.showToastLong(getString(R.string.date_choose), getApplicationContext());
            } else if (txtParticipant.getText().toString().equals("") &
                txtParticipant2.getText().toString().equals("") &
                txtParticipant3.getText().toString().equals("") &
                txtParticipant4.getText().toString().equals("")) {
            ToastUtils.showToastLong(getString(R.string.add_one_participant), getApplicationContext());
            } else if (txtComment.getText().toString().equals("")) {
            ToastUtils.showToastLong(getString(R.string.object_of_meeting), getApplicationContext());
            } else if (txtPlace.getText().toString().equals("")) {
            ToastUtils.showToastLong(getString(R.string.room_request), getApplicationContext());
            } else {

            List<String> nP = new ArrayList<>();

            if (txtParticipant.getText().toString().length() != 0) {
                nP.add(txtParticipant.getText().toString());
            }

            if (txtParticipant2.getText().toString().length() != 0) {
                nP.add(txtParticipant2.getText().toString());
            }

            if (txtParticipant3.getText().toString().length() != 0) {
                nP.add(txtParticipant3.getText().toString());
            }

            if (txtParticipant4.getText().toString().length() != 0) {
              nP.add(txtParticipant4.getText().toString());
            }


            Meeting meeting = new Meeting(System.currentTimeMillis(),
                    txtTime.getText().toString(),
                    txtDate.getText().toString(),
                    txtPlace.getText().toString(),
                    txtComment.getText().toString(),
                    nP

            );
            mApiService.createMeeting(meeting);
            finish();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
