package emre.turhal.mareunion.ui;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.events.FilterMeetingEventByDate;
import emre.turhal.mareunion.events.FilterMeetingEventByPlace;
import emre.turhal.mareunion.ui.meetings_list.MeetingFragment;

public class
MainActivity extends AppCompatActivity {


    @BindView((R.id.my_toolbar))
    Toolbar mToolbar;


    private MeetingFragment mMeetingFragment;
    private static CharSequence dateText;





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


        switch (item.getItemId()){



            case (R.id.filter_date):


                final Calendar calendar = Calendar.getInstance();

                int YEAR = calendar.get(Calendar.YEAR);
                int MONTH = calendar.get(Calendar.MONTH);
                int DATE = calendar.get(Calendar.DATE);

                final DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, year, month, date) -> {
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.YEAR, year);
                    calendar1.set(Calendar.MONTH, month);
                    calendar1.set(Calendar.DATE, date);
                    dateText = DateFormat.format("dd/MM/yyyy", calendar1);

                    EventBus.getDefault().post(new FilterMeetingEventByDate(dateText.toString()));

                }, YEAR, MONTH, DATE);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();

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




