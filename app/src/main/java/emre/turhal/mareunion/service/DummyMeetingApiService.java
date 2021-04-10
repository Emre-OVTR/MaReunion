package emre.turhal.mareunion.service;


import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public class DummyMeetingApiService implements MeetingApiService{

    List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();


    @Override
    public List<Meeting> getMeetings() {


        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {

        meetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {

        meetings.add(meeting);

    }

    @Override
    public List<Meeting> filterMeetingsByTime(String time) {

        List<Meeting> filteredMeetings = new ArrayList<>();

//        Log.e("tag", time);

        for (Meeting meeting : meetings){

//          Log.e("tag", meeting.getHour());

            if (meeting.getHour().equals(time)){

                filteredMeetings.add(meeting);


            }


        }
        return filteredMeetings;
    }

    @Override
    public List<Meeting> filterMeetingsByPlace(String place) {

        List<Meeting> placeFilteredMeetings = new ArrayList<>();

        for (Meeting meeting : meetings){

            if (meeting.getPlace().equals(place)){
                placeFilteredMeetings.add(meeting);
            }
        }
        return placeFilteredMeetings;
    }
}
