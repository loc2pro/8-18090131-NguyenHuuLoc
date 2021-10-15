package com.example.musicapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.Viewholder> {
    List<Song> mSongs;
    OnClickListener listener;

    public CustomRecyclerView(List<Song> songs, OnClickListener listener) {
        this.mSongs = songs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Song song = mSongs.get(position);
        holder.asong = song;
        holder.imageView.setImageResource(song.getImgSong());
        holder.songTitle.setText(song.getTitle());
        holder.songSinger.setText(song.getSinger());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView,imgHeart,imgMenu;
        TextView songTitle, songSinger;
        Song asong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgSong);
            songTitle = itemView.findViewById(R.id.txtTitle);
            songSinger = itemView.findViewById(R.id.txtSinger);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.clickItem(asong);
                }
            });
        }
    }
}
