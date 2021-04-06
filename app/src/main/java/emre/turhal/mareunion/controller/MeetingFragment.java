package emre.turhal.mareunion.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import emre.turhal.mareunion.R;
import emre.turhal.mareunion.di.DI;
import emre.turhal.mareunion.events.DeleteMeetingEvent;
import emre.turhal.mareunion.events.FilterMeetingEventByTime;
import emre.turhal.mareunion.model.Meeting;
import emre.turhal.mareunion.service.MeetingApiService;

public class MeetingFragment extends Fragment {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetingList;
    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mMeetingRecyclerViewAdapter;


    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getMeetingApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_meeting_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mMeetingRecyclerViewAdapter = new MeetingRecyclerViewAdapter(mMeetingList);
        mRecyclerView.setAdapter(mMeetingRecyclerViewAdapter);
        return view;
    }

    private void initList() {
        mMeetingList = mApiService.getMeetings();
        mMeetingRecyclerViewAdapter.updateMeeting(mMeetingList);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event){
        mApiService.deleteMeeting(event.meeting);
        initList();
    }

    @Subscribe
    public void onFilterMeeting(FilterMeetingEventByTime event){
        mMeetingRecyclerViewAdapter.updateMeeting(mApiService.filterMeetingsByTime(event.timeSelected));
    }
}

