package emre.turhal.mareunion.service;


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
    public List<Meeting> filterMeetings(String filter, String type) {
        return null;
    }
}
