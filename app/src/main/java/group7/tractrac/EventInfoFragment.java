package group7.tractrac;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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



        return inflaterview;
    }


    public View getView(View view) {
        TextView eventInfoTitle = view.findViewById(R.id.event_info_title);

        eventInfoTitle.setText(R.string.event_redbull);

        return view;
    }
}
