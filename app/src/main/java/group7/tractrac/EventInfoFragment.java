package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EventInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_event_info, container, false);
        getView(inflaterview);



        return inflaterview;
    }


    public View getView(View view) {
        TextView eventInfoTitle = view.findViewById(R.id.event_info_title);
/**
        switch (EventFragment.eventid) {
            case 0: eventInfoTitle.setText(R.string.event_french);

                break;
            case 1: eventInfoTitle.setText(R.string.event_swiss);
                break;
            case 2: eventInfoTitle.setText(R.string.event_ess);
                break;
            case 3: eventInfoTitle.setText(R.string.event_eurosail);
                break;
            case 4: eventInfoTitle.setText(R.string.event_redbull);
                break;
            default: eventInfoTitle.setText("Event");
                break;
        }
 **/

        return view;
    }

    }
