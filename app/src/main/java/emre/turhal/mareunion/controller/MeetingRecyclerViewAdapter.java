package emre.turhal.mareunion.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import emre.turhal.mareunion.R;
import emre.turhal.mareunion.events.DeleteMeetingEvent;
import emre.turhal.mareunion.model.Meeting;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;


    public MeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        holder.mMeetingHour.setText(meeting.getHour());
        holder.mMeetingPlace.setText(meeting.getPlace());
        holder.mMeetingObject.setText(meeting.getObject());
        //Glide.with(holder.mNeighbourAvatar.getContext())
                //.load(neighbour.getAvatarUrl())
                //.apply(RequestOptions.circleCropTransform())
                //.into(holder.mNeighbourAvatar);

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

        @BindView(R.id.item_list_hour)
        public TextView mMeetingHour;
        @BindView(R.id.item_list_place)
        public TextView mMeetingPlace;
        @BindView(R.id.item_list_object)
        public TextView mMeetingObject;
        @BindView(R.id.item_list_delete_btn)
        public ImageButton mDeleteButton;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


}