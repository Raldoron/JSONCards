package com.example.raldoron.jsoncards.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.R;

/**
 * Created by Raldoron on 02.11.17.
 */

public class TodoViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView title;
    private TextView completed;

    public TodoViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.todo_id);
        title = (TextView) itemView.findViewById(R.id.todo_title);
        completed = (TextView) itemView.findViewById(R.id.todo_completed);
    }

    public void fillTodoViewHolder(Todo todo){
        this.id.setText(this.itemView.getResources().getString(R.string.todo_title, todo.getId()));
        this.title.setText(this.itemView.getResources().getString(R.string.todo_title_string, todo.getTitle()));
        this.completed.setText(this.itemView.getResources().getString(R.string.todo_completed_string, todo.getCompleted()));
    }
}
