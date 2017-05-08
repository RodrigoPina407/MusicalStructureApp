package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView artist_list;
    private String[] artists = {"Artist 1", "Artist 2", "Artist 3", "Artist 4", "Artist 5", "Artist 6"}; // get all the artists

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artist_list = (ListView) findViewById(R.id.list_artist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, artists);

        artist_list.setAdapter(adapter);

        artist_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent album_page = new Intent(getApplicationContext(), album.class);

                String name= artists[position];

                album_page.putExtra("artist_name", name);

                startActivity(album_page);

            }
        });
    }
}
