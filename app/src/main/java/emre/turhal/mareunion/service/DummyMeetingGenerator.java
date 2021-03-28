package emre.turhal.mareunion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1, "14:00", "Salle A", " Dossier en attente"));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
