package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.R;

/**
 * Created by Raldoron on 26.10.17.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView title;
        private TextView body;

        public PostViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.post_id);
            title = (TextView) itemView.findViewById(R.id.post_title);
            body = (TextView) itemView.findViewById(R.id.post_body);
        }

        public void fillPostViewHolder(Post post){
            this.id.setText(this.itemView.getResources().getString(
                    R.string.post_header,
                    post.getId(),
                    post.getUserId()
            ));
            this.title.setText(this.itemView.getResources().getString(
                    R.string.post_title,
                    post.getTitle()
            ));
            this.body.setText(this.itemView.getResources().getString(
                    R.string.post_body,
                    post.getBody()
            ));
        }
}
