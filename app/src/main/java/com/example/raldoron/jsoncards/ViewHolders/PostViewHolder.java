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

        private TextView userId;
        private TextView id;
        private TextView title;
        private TextView body;

        public PostViewHolder(View itemView) {
            super(itemView);
            userId = (TextView) itemView.findViewById(R.id.post_userId);
            id = (TextView) itemView.findViewById(R.id.post_id);
            title = (TextView) itemView.findViewById(R.id.post_title);
            body = (TextView) itemView.findViewById(R.id.post_body);
        }

        public void fillPostViewHolder(Post post){
            this.userId.setText(this.itemView.getResources().getString(R.string.user_id_title, post.getUserId()));
            this.id.setText(this.itemView.getResources().getString(R.string.id_title, post.getId()));
            this.title.setText(post.getTitle());
            this.body.setText(post.getBody());
        }
}
