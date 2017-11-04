package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.User;
import com.example.raldoron.jsoncards.Models.Users;
import com.example.raldoron.jsoncards.R;


/**
 * Created by Raldoron on 31.10.17.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout layout;


    public UserViewHolder(View itemView) {
        super(itemView);
        layout = (LinearLayout) itemView.findViewById(R.id.linear);
    }

    public void fillUserViewHolder(Users users){
        layout.removeAllViews();
        for (User user: users.getUsers()) {
            TextView userView = (TextView) LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_user, null, false);
            userView.setText(itemView.getResources().getString(
                    R.string.user_string,
                    user.getId(),
                    user.getUsername(),
                    user.getName(),
                    user.getEmail())
            );
            layout.addView(userView);
        }
    }
}
