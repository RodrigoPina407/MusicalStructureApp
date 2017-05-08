package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class songs extends AppCompatActivity {

    private String artist;
    private String album;
    private TextView artist_text_view;
    private TextView album_text_view;

    private ListView song_list;
    private final String[] songs = {"Song 1", "Song 2", "Song 3", "Song 4", "Song 5"}; // get the song names from one artist

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Intent intent = getIntent();

        artist = intent.getStringExtra("artist_name");

        album = intent.getStringExtra("album_name");

        artist_text_view = (TextView) findViewById(R.id.artist_text_id);

        album_text_view = (TextView) findViewById(R.id.album_text_id);

        artist_text_view.setText(artist);

        album_text_view.setText(album);

        song_list = (ListView) findViewById(R.id.song_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, songs);

        song_list.setAdapter(adapter);

        song_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent playing = new Intent(getApplicationContext(), NowPlaying.class);

                String name= songs[position];

                playing.putExtra("artist_name", artist);
                playing.putExtra("album_name", album);
                playing.putExtra("song_name", name);

                startActivity(playing);

            }
        });
}}
