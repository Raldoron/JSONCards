package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Raldoron on 01.11.17.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView title;
    private ImageView thumbnail;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.photo_id);
        title = (TextView) itemView.findViewById(R.id.photo_title);
        thumbnail = (ImageView) itemView.findViewById(R.id.photo_thumbnail);
    }

    public void fillPhotoViewHolder(Photo photo){
        this.id.setText(this.itemView.getResources().getString(
                R.string.photo_header,
                photo.getId(),
                photo.getAlbumId()
        ));
        this.title.setText(this.itemView.getResources().getString(
                R.string.photo_title,
                photo.getTitle()
        ));
        if (photo.getThumbnailUrl() != null) {
            Picasso.with(this.itemView.getContext())
                    .load(photo.getUrl())
                    .into(this.thumbnail);
        }
    }
}
