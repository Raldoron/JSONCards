package com.example.raldoron.jsoncards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.Models.User;
import com.example.raldoron.jsoncards.ViewHolders.CommentViewHolder;
import com.example.raldoron.jsoncards.ViewHolders.PhotoViewHolder;
import com.example.raldoron.jsoncards.ViewHolders.PostViewHolder;
import com.example.raldoron.jsoncards.ViewHolders.TodoViewHolder;
import com.example.raldoron.jsoncards.ViewHolders.UserViewHolder;

import java.util.ArrayList;

/**
 * Created by Raldoron on 26.10.17.
 */

public class JsonResoursesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList cards;
    private static final int POST_TYPE = 0;
    private static final int COMMENT_TYPE = 1;
    private static final int USER_TYPE = 2;
    private static final int PHOTO_TYPE = 3;
    private static final int TODO_TYPE = 4;

    public JsonResoursesAdapter(ArrayList posts){
        this.cards = posts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case POST_TYPE:
                View viewPost = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
                return new PostViewHolder(viewPost);
            case COMMENT_TYPE:
                View viewComment = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comment, parent, false);
                return new CommentViewHolder(viewComment);
            case USER_TYPE:
                View viewUser = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user, parent, false);
                return new UserViewHolder(viewUser);
            case PHOTO_TYPE:
                View viewPhoto = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_photo, parent, false);
                return new PhotoViewHolder(viewPhoto);
            case TODO_TYPE:
                View viewTodo = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_todo, parent, false);
                return new TodoViewHolder(viewTodo);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case POST_TYPE:
                PostViewHolder postViewHolder = (PostViewHolder) holder;
                postViewHolder.fillPostViewHolder((Post) cards.get(position));
                break;
            case COMMENT_TYPE:
                CommentViewHolder commentViewHolder = (CommentViewHolder) holder;
                commentViewHolder.fillCommentViewHolder((Comment) cards.get(position));
                break;
            case USER_TYPE:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.fillUserViewHolder((User) cards.get(position));
                break;
            case PHOTO_TYPE:
                PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
                photoViewHolder.fillPhotoViewHolder((Photo) cards.get(position));
                break;
            case TODO_TYPE:
                TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
                todoViewHolder.fillTodoViewHolder((Todo) cards.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (this.cards.get(position) instanceof Post){
            return POST_TYPE;
        } else if (this.cards.get(position) instanceof Comment) {
            return COMMENT_TYPE;
        } else if (this.cards.get(position) instanceof User) {
            return USER_TYPE;
        } else if (this.cards.get(position) instanceof Photo) {
            return PHOTO_TYPE;
        } else {
            return TODO_TYPE;
        }
    }

    public void add(Post post){
        this.cards.add(post);
    }
    public void add(Comment comment){
        this.cards.add(comment);
    }
    public void add(User user){
        this.cards.add(user);
    }
    public void add(Photo photo){
        this.cards.add(photo);
    }
    public void add(Todo todo){
        this.cards.add(todo);
    }
}
