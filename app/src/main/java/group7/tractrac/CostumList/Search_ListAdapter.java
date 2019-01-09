package group7.tractrac.CostumList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import group7.tractrac.R;

import java.util.ArrayList;

public class Search_ListAdapter extends ArrayAdapter<SearchListItems> {

    private Context context;
    private ArrayList<SearchListItems> arrayList;
    private int res;

    public Search_ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SearchListItems> objects) {
        super(context, resource, objects);
        context = context;
        res = resource;
        arrayList = objects;

    }
    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int imageView = getItem(position).imageView;
        String eventName = getItem(position).eventName;
        String event = getItem(position).event;

        SearchListItems itemsForSale = new SearchListItems(imageView,eventName,event);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(res,parent,false);

        ImageView eventflag = convertView.findViewById(R.id.eventFlag);
        TextView eventname = convertView.findViewById(R.id.eventText01);
        TextView textPrice = convertView.findViewById(R.id.eventText02);

        eventflag.setImageResource(imageView);
        //eventflag.setImage(imageView);
        eventname.setText(eventName);
        textPrice.setText(event);
        return convertView;
    }

    public void newDataForList(ArrayList<SearchListItems> newArrayList) {
        this.arrayList.clear();
        for (int i = 0; i < newArrayList.size(); i++) { // copy global ArrayList
            this.arrayList.add(newArrayList.get(i));
    }
        this.notifyDataSetChanged();
    }
/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.costume_search_list,parent, false);


    }
    */
}
