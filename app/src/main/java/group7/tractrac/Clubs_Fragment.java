package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Clubs_Fragment extends Fragment {

   ListView clubs;

   ImageView clubsimageview;

   TextView clubstitleview;
   TextView clubssportsview;
   TextView clubscountryview;

   String[] titles = {"test1", "test2", "test3", "test4", "test1", "test2", "test3", "test4"};
   String[] sports = {"test5", "test6", "test7", "test8", "test5", "test6", "test7", "test8"};
   String[] countries = {"test9", "test10", "test11", "test12", "test9", "test10", "test11", "test12"};
   int[] images = {R.drawable.twentyfourhourfinale, R.drawable.boldhorizons, R.drawable.dof, R.drawable.ifkgoteborg, R.drawable.twentyfourhourfinale, R.drawable.boldhorizons, R.drawable.dof, R.drawable.ifkgoteborg};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflaterview = inflater.inflate(R.layout.fragment_clubs, container, false);
        clubs = inflaterview.findViewById(R.id.clubslist);

        CustomAdapter clubsadapter = new CustomAdapter();
        clubs.setAdapter(clubsadapter);
        return inflaterview;
    }

    class CustomAdapter extends BaseAdapter {


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

            clubsimageview = view.findViewById(R.id.clubsimage);
            clubsimageview.setImageResource(images[i]);

            clubstitleview = view.findViewById(R.id.clubstitle);
            clubstitleview.setText(titles[i]);

            clubssportsview = view.findViewById(R.id.clubssports);
            clubssportsview.setText(sports[i]);

            clubscountryview = view.findViewById(R.id.clubscountry);
            clubscountryview.setText(countries[i]);


            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_in);
            view.startAnimation(animation);

            return view;
        }
    }

}
