package sg.edu.rp.c346.id21045028.myndpsong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sg.edu.rp.c346.id21045028.myndpsong.R;
import sg.edu.rp.c346.id21045028.myndpsong.NDPSong;

public class CustomAdapter extends ArrayAdapter {


    Context parent_context;
    int layout_id;
    ArrayList<Note> NDPList;

    public CustomAdapter(Context context, int resource, ArrayList<Note> objects){
        super(context, resource , objects);
        parent_context = context;
        layout_id = resource;
        NDPList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvRating = rowView.findViewById(R.id.textViewRating);

        // Obtain the Android Version information based on the position
        Note currentVersion = NDPList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvSinger.setText(currentVersion.getSinger());
        tvYear.setText(currentVersion.getYear());
        tvRating.setText(currentVersion.getRating());

        return rowView;
    }

}
