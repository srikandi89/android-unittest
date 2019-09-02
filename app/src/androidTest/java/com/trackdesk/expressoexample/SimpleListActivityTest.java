package com.trackdesk.expressoexample;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SimpleListActivityTest {

    @Rule
    public ActivityTestRule<SimpleListActivity> activityRule
            = new ActivityTestRule<>(SimpleListActivity.class);

    @Test
    public void testIsListShowing() {
        onView(withId(R.id.rv_list)).perform(click());
    }

    @Test
    public void testIsListRowMatch() {
        RecyclerView rvList = activityRule.getActivity().findViewById(R.id.rv_list);
        int listRows = rvList.getAdapter().getItemCount();

        assertEquals(listRows, 20);
    }

    public void testIsRowClickable() {
        RecyclerView rvList = activityRule.getActivity().findViewById(R.id.rv_list);
        int listRows = rvList.getAdapter().getItemCount();

        for (int i=0; i<listRows; i++) {
            onView(
                    ViewMatchers.withId(R.id.rv_list))
                    .inRoot(RootMatchers
                            .withDecorView(Matchers.is(activityRule
                                    .getActivity()
                                    .getWindow()
                                    .getDecorView())))
                    .perform(RecyclerViewActions
                            .actionOnItemAtPosition(i, click()));

            if (i < (listRows-1)) {
                onView(
                        ViewMatchers.withId(R.id.rv_list))
                        .inRoot(RootMatchers
                                .withDecorView(Matchers.is(activityRule
                                        .getActivity()
                                        .getWindow()
                                        .getDecorView())))
                        .perform(RecyclerViewActions
                                .scrollToPosition(i+1));
            }
        }
    }
}