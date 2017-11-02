package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.R;

/**
 * Created by Raldoron on 30.10.17.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private TextView postId;
    private TextView id;
    private TextView name;
    private TextView email;
    private TextView body;

    public CommentViewHolder(View itemView) {
        super(itemView);
        postId = (TextView) itemView.findViewById(R.id.comment_postId);
        id = (TextView) itemView.findViewById(R.id.comment_id);
        name = (TextView) itemView.findViewById(R.id.comment_name);
        email = (TextView) itemView.findViewById(R.id.comment_email);
        body = (TextView) itemView.findViewById(R.id.comment_body);
    }

    public void fillCommentViewHolder(Comment comment){
        this.postId.setText(this.itemView.getResources().getString(R.string.post_id_title, comment.getPostId()));
        this.id.setText(this.itemView.getResources().getString(R.string.id_title, comment.getId()));
        this.name.setText(comment.getName());
        this.email.setText(comment.getEmail());
        this.body.setText(comment.getBody());
    }
}
