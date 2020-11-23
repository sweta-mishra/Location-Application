package com.example.locationpage;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.RecyclerViewHolder> {


    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private final Context context;



    private List<Location> locations;

    private LocationListener locationListener;

    public LocationsAdapter(Context context, List<Location> locations, LocationListener locationListener) {
        this.context = context;
        this.locations = locations;
        this.locationListener = locationListener;

    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder recyclerViewHolder;

        if(viewType == TYPE_HEAD){
            //Inflating header view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.header_layout,
                    parent,
                    false

            );
            recyclerViewHolder = new RecyclerViewHolder(itemView,viewType);

            return recyclerViewHolder;
        }
        else if (viewType == TYPE_LIST){
            //Inflating list view
            View itemView =  LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_container_location,
                    parent,
                    false
            );

            recyclerViewHolder = new RecyclerViewHolder(itemView,viewType);

            return recyclerViewHolder;



        }
        else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {




        if(holder.view_type == TYPE_HEAD){
            //holder.bindHeader(headers.get(position));
            holder.search.setText("SEARCH");
            holder.sort.setText("SORT");
            holder.filter.setText("FILTER");

        }
        else if(holder.view_type == TYPE_LIST){
            holder.bindLocation(locations.get(position-1));
        }


    }

    @Override
    public int getItemCount() {
        return locations.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return TYPE_HEAD;
        return  TYPE_LIST;
    }

    public List<Location> getSelectedLocations() {
        List<Location> selectedLocations = new ArrayList<>();
        for(Location location : locations){
            if(location.isSelected){
                selectedLocations.add(location);
            }
        }

        return selectedLocations;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        int view_type;

        //Variables for the list
        ConstraintLayout layoutLocation;
        ImageView imageLocation;
        TextView textName,textAddress,textAuctionDate;
        TextView salesList;
        LinearLayout containerAuction;

        //Variables for the head section
        EditText search;
        TextView sort;
        TextView filter;

        public RecyclerViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if(viewType == TYPE_LIST){
                layoutLocation = itemView.findViewById(R.id.layoutLocation);
                imageLocation = itemView.findViewById(R.id.imageLocaton);
                textName = itemView.findViewById(R.id.textName);
                textAddress = itemView.findViewById(R.id.textAddress);
                textAuctionDate= itemView.findViewById(R.id.textNextAuction);
                salesList = itemView.findViewById(R.id.textSaleLists);
                containerAuction = itemView.findViewById(R.id.container_Auction);
                view_type = 1;



                salesList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        LayoutInflater inflater = LayoutInflater
                                .from(context);
                        View v = inflater.inflate(R.layout.upcoming_auctions, null);
                        containerAuction.addView(v);


                        //Log.i("Info", "TextView Pressed");

                        


                    }
                });

            }

            else if(viewType == TYPE_HEAD){
                search = itemView.findViewById(R.id.search);
                sort = itemView.findViewById(R.id.sort);
                filter = itemView.findViewById(R.id.filter);
                view_type = 0;

            }



        }
        void bindLocation(final Location location){
            imageLocation.setImageResource(location.image);
            textName.setText(location.name);
            textAddress.setText(location.address);
            textAuctionDate.setText(location.auctionDate);



        }

    }
}


