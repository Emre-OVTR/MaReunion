package emre.turhal.mareunion.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import emre.turhal.mareunion.model.Meeting;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(1,"20/12/22", "14:00", "Salle A", " Dossier en attente","emreturhal9@gmail.com",
                    "samettos@gmail.com","sinanos@gmail.com","anenos@gmail.com"));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
