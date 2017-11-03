package com.example.raldoron.jsoncards.ViewHolders;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.R;

/**
 * Created by Raldoron on 30.10.17.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView name;
    private TextView email;
    private TextView body;
    private TextInputEditText inputEditText;
    private AppCompatButton confirmButton;

    public CommentViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.comment_id);
        name = (TextView) itemView.findViewById(R.id.comment_name);
        email = (TextView) itemView.findViewById(R.id.comment_email);
        body = (TextView) itemView.findViewById(R.id.comment_body);
        inputEditText = (TextInputEditText) itemView.findViewById(R.id.comment_input);
        confirmButton = (AppCompatButton) itemView.findViewById(R.id.comment_button);
    }

    public void fillCommentViewHolder(Comment comment, final ConfirmButtonListener confirmButtonListener){
        this.id.setText(this.itemView.getResources().getString(
                R.string.comment_header,
                comment.getId(),
                comment.getPostId()
        ));
        this.name.setText(this.itemView.getResources().getString(
                R.string.comment_name,
                comment.getName()
        ));
        this.email.setText(this.itemView.getResources().getString(
                R.string.comment_email,
                comment.getEmail()
        ));
        this.body.setText(this.itemView.getResources().getString(
                R.string.comment_body,
                comment.getBody()
        ));
        this.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmButtonListener.onConfirmButtonClick();
            }
        });
    }

    public int getInputValue(){
        if (inputEditText.getText().length() > 0) {
            return Integer.parseInt(String.valueOf(inputEditText.getText()));
        } else {
            return 0;
        }
    }

    public interface ConfirmButtonListener {
        void onConfirmButtonClick();
    }
}
