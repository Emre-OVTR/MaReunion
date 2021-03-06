package emre.turhal.mareunion.service;


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
    public List<Meeting> filterMeetingsByDate(String date) {

        List<Meeting> datefilteredMeetings = new ArrayList<>();



        for (Meeting meeting : meetings){



            if (meeting.getDate().equals(date)){

                datefilteredMeetings.add(meeting);


            }


        }
        return datefilteredMeetings;
    }

    @Override
    public List<Meeting> filterMeetingsByPlace(String place) {

        List<Meeting> placeFilteredMeetings = new ArrayList<>();

        for (Meeting meeting : meetings){

            if (meeting.getRoom().equals(place)){
                placeFilteredMeetings.add(meeting);
            }
        }
        return placeFilteredMeetings;
    }
}
