package com.example.raldoron.jsoncards.ViewHolders;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
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
    private TextInputEditText inputEditText;
    private AppCompatButton confirmButton;

    public PostViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.post_id);
        title = (TextView) itemView.findViewById(R.id.post_title);
        body = (TextView) itemView.findViewById(R.id.post_body);
        inputEditText = (TextInputEditText) itemView.findViewById(R.id.post_input);
        confirmButton = (AppCompatButton) itemView.findViewById(R.id.post_button);
    }

    public void fillPostViewHolder(Post post, final ConfirmButtonListener confirmButtonListener){
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
