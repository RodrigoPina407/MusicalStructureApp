package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class album extends AppCompatActivity {

    private String[] album_names = {"Album 1", "Album 2", "Album 3", "Album 4", "Album 5"};

    private ListView album_list;

    private String artist;
    private TextView artist_text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent intent = getIntent();

        artist = intent.getStringExtra("artist_name");

        artist_text_view = (TextView) findViewById(R.id.artist_text_id);

        artist_text_view.setText(artist);

        album_list = (ListView) findViewById(R.id.album_id);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, album_names);

        album_list.setAdapter(adapter);

        album_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent song_page = new Intent(getApplicationContext(), songs.class);

                String album = album_names[position];

                song_page.putExtra("artist_name", artist);
                song_page.putExtra("album_name", album);

                startActivity(song_page);


            }
        });

    }
}
