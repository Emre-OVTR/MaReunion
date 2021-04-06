package emre.turhal.mareunion.controller;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.events.DeleteMeetingEvent;
import emre.turhal.mareunion.model.Meeting;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder> {

    private  List<Meeting> mMeetings;

    int[] images = new int[] {R.drawable.ic_baseline_circle_24, R.drawable.ic_baseline_circle_24_orange, R.drawable.ic_baseline_circle_24_yellow, R.drawable.ic_baseline_circle_24_green};


    public MeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        holder.mMeetingHour.setText(meeting.getHour());
        holder.mMeetingPlace.setText(meeting.getPlace());
        holder.mMeetingObject.setText(meeting.getObject());
        holder.mParticipants.setText(String.join(", ", meeting.getParticipants()));


        int imageId =(int)(Math.random() * images.length);
        holder.mColorCircle.setBackgroundResource(images[imageId]);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_list_color)
        ImageView mColorCircle;
        @BindView(R.id.item_list_hour)
        public TextView mMeetingHour;
        @BindView(R.id.item_list_place)
        public TextView mMeetingPlace;
        @BindView(R.id.item_list_object)
        public TextView mMeetingObject;
        @BindView(R.id.item_list_delete_btn)
        public ImageButton mDeleteButton;
        @BindView(R.id.participants_email_meeting_list)
        public TextView mParticipants;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


    public void updateMeeting(List<Meeting> newMeetings) {

        mMeetings = newMeetings;
        notifyDataSetChanged();





    }


}