package group7.tractrac;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Clubs_Fragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    List<ClubsData> clubsData;

   ListView clubs;

   ImageView clubsimageview;

   TextView clubstitleview;
   TextView clubssportsview;
   TextView clubscountryview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("clubs");

        clubsData = new ArrayList<ClubsData>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clubsData.clear();
                for (DataSnapshot postSnapshot1: dataSnapshot.getChildren()){

                    ClubsData data = postSnapshot1.getValue(ClubsData.class);
                    clubsData.add(data);
                }

                CustomAdapter clubsadapter = new CustomAdapter(clubsData, getContext());
                clubs.setAdapter(clubsadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        View inflaterview = inflater.inflate(R.layout.fragment_clubs, container, false);
        clubs = inflaterview.findViewById(R.id.clubslist);

        CustomAdapter clubsadapter = new CustomAdapter(clubsData, getContext());
        clubs.setAdapter(clubsadapter);
        return inflaterview;
    }

    class CustomAdapter extends BaseAdapter {

        List<ClubsData> dataList;
        Context context;

        public CustomAdapter(List<ClubsData> dataList, Context context) {
            this.dataList = dataList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return dataList.size();
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

            ClubsData temp = dataList.get(i);

            clubsimageview = view.findViewById(R.id.clubsimage);
            Picasso.get().load(temp.getUrl()).into(clubsimageview);

            clubstitleview = view.findViewById(R.id.clubstitle);
            clubstitleview.setText(temp.getName());

            clubssportsview = view.findViewById(R.id.clubssports);
            clubssportsview.setText(temp.getSport());

            clubscountryview = view.findViewById(R.id.clubscountry);
            clubscountryview.setText(temp.getCountry());

            Animation animationtwo = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);
            view.startAnimation(animationtwo);



            return view;
        }
    }

}
