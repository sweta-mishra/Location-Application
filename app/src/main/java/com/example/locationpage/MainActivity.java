package com.example.locationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView locationsRecyclerView = findViewById(R.id.locationsRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        locationsRecyclerView.setLayoutManager(linearLayoutManager);
        locationsRecyclerView.setHasFixedSize(true);



        List<Location> locations = new ArrayList<>();

        Location northernNewJersey = new Location();
        northernNewJersey.image=R.drawable.ic_location_city;
        northernNewJersey.name = "Northern New Jersey";
        northernNewJersey.address = "7700 US Highway 277 Hawlington,NJ 79601";
        northernNewJersey.auctionDate = " Thu Oct 22";
        locations.add(northernNewJersey);

        Location carolina = new Location();
        carolina.image=R.drawable.ic_location_city;
        carolina.name = "Northern New Jersey";
        carolina.address = "7700 US Highway 277 Hawlington,NJ 79601";
        carolina.auctionDate = " Thu Oct 22";
        locations.add(carolina);

        final LocationsAdapter locationsAdapter = new LocationsAdapter(locations,this);
        locationsRecyclerView.setAdapter(locationsAdapter);




    }



    @Override
    public void onLocationAction(Boolean isSelected) {

    }
}