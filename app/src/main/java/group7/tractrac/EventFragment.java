package group7.tractrac;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class EventFragment extends Fragment implements View.OnClickListener {
    Button upcoming;
    Button past;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_event, container, false);
        upcoming = (Button) inflaterview.findViewById(R.id.upcomingbtn);
        past = (Button) inflaterview.findViewById(R.id.pastbtn);
        upcoming.setOnClickListener(this);
        past.setOnClickListener(this);

        return inflaterview;
    }



    @Override
    public void onClick(View view) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        UpcomingEventsFragment upcomingFragment = new UpcomingEventsFragment();
        PastEventsFragment pastFragment = new PastEventsFragment();

        if (view == upcoming) {
            transaction.add(R.id.fragment_container_events, upcomingFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else {
            transaction.add(R.id.fragment_container_events, pastFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }


    }

}
