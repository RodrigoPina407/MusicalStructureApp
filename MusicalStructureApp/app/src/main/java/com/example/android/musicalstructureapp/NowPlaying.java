package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    private String artist, album, song;

    private TextView artist_textview, album_textview, song_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();

        artist = intent.getStringExtra("artist_name");

        album= intent.getStringExtra("album_name");

        song= intent.getStringExtra("song_name");

        artist_textview = (TextView) findViewById(R.id.artist_text_id);
        album_textview = (TextView) findViewById(R.id.album_text_id);
        song_textview = (TextView) findViewById(R.id.song_text_id);

        artist_textview.setText(artist);
        album_textview.setText(album);
        song_textview.setText(song);
    }
}
