package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.User;
import com.example.raldoron.jsoncards.R;

/**
 * Created by Raldoron on 31.10.17.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private TextView user;


    public UserViewHolder(View itemView) {
        super(itemView);
        user = (TextView) itemView.findViewById(R.id.user);
    }

    public void fillUserViewHolder(User user){
        this.user.setText(this.itemView.getResources().getString(
                R.string.user_string,
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getEmail())
        );
    }
}
