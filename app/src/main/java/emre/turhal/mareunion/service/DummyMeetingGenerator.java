package emre.turhal.mareunion.service;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import emre.turhal.mareunion.model.Meeting;

public abstract class DummyMeetingGenerator {

    public static List<String> participants = Arrays.asList(
            "nouveau@gmail.com, ancien@gmail.com, super@gmail.com, nul@gmail.com");

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1, "14:00", "Room A", " Future Project ", participants ));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
