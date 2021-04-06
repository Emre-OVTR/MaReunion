package emre.turhal.mareunion.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import emre.turhal.mareunion.model.Meeting;

public interface MeetingApiService {

    List<Meeting> getMeetings();
    List<Meeting> filterMeetingsByTime (String time);



    void deleteMeeting (Meeting meeting);

    void createMeeting (Meeting meeting);

    String timePickerToString(int hour, int minute);



}
