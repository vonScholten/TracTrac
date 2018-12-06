package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Clubs_Fragment extends Fragment {

    int[] images = {R.drawable.twentyfourhourfinale, R.drawable.boldhorizons, R.drawable.dof, R.drawable.ifkgoteborg};
    int[] imagestwo = {R.drawable.abeamconsulting, R.drawable.cya, R.drawable.fedo, R.drawable.knoxgs};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflaterview = inflater.inflate(R.layout.fragment_clubs, container, false);

        ListView clubs = inflaterview.findViewById(R.id.clubslist);
        CustomAdapter clubsadapter = new CustomAdapter();
        clubs.setAdapter(clubsadapter);
        return inflaterview;

    }

    class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.custom_layout_clubs, null);
            ImageView clubsimageview = view.findViewById(R.id.clubsimage);
            ImageView clubsimageviewtwo = view.findViewById(R.id.clubsimagetwo);

            clubsimageview.setImageResource(images[i]);
            clubsimageviewtwo.setImageResource(imagestwo[i]);

            return view;
        }
    }

}
