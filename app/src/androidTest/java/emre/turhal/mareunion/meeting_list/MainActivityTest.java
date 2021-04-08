package emre.turhal.mareunion.meeting_list;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import emre.turhal.mareunion.R;
import emre.turhal.mareunion.controller.MainActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static emre.turhal.mareunion.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.junit.Assert.assertTrue;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule;

    public MainActivityTest() {
        mActivityRule = new ActivityTestRule<>(MainActivity.class);
    }

    public static void setTime() {
        onView(withId(android.R.id.button1)).perform(click());
    }

    public static void setPlace(){
        onView(withId(android.R.id.button1)).perform(click());
    }


    @Test
    public void fab_shouldStartAddMeetingActivity() {

        onView(ViewMatchers.withId(R.id.add_meeting)).perform(click());

        onView(withId(R.id.create)).check(matches(isDisplayed())).perform(pressBack());
    }

    @Test
    public void filterByTimeAndGetBackAllMeetingsWithSuccess(){

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Filtrer par heure")).perform(click());
        setTime();

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Toutes les réunions")).perform(click());
    }

    @Test
    public void filterByPlaceAndGetBackAllMeetingsWithSuccess(){


        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Filtrer par lieu")).perform(click());
        setPlace();

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Toutes les réunions")).perform(click());
    }


    @Test
    public void createMeetingWithSuccess() {
        onView(withId(R.id.add_meeting)).perform(click());
        onView(withId(R.id.time_btn)).perform(click());
        setTime();

        onView(withId(R.id.button)).perform(click());
        setPlace();

        onView(withId(R.id.participant)).perform(replaceText("test@test.com"), closeSoftKeyboard());

        onView(withId(R.id.participant2)).perform(replaceText("test02@test.com"), closeSoftKeyboard());

        onView(withId(R.id.in_comment)).perform(replaceText("TEST"), closeSoftKeyboard());

        onView(withId(R.id.create)).perform(click()).perform(pressBack());

        onView(ViewMatchers.withId(R.id.list_meetings)).check(withItemCount(4)).perform(pressMenuKey());



    }


}