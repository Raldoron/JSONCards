package com.example.raldoron.jsoncards;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.Models.User;
import com.example.raldoron.jsoncards.Models.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Raldoron on 28.10.17.
 */

public class JsonClient {

    private PostListener postListener;
    private CommentListener commentListener;
    private UserListener userListener;
    private PhotoListener photoListener;
    private TodoListener todoListener;

    public JsonClient(PostListener postListener,
                      CommentListener commentListener,
                      UserListener userListener,
                      PhotoListener photoListener,
                      TodoListener todoListener){
        this.postListener = postListener;
        this.commentListener = commentListener;
        this.userListener = userListener;
        this.photoListener = photoListener;
        this.todoListener = todoListener;
    }

    public void getPost(int postId){
        JsonPlaceholder.getAPI().getPost(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                postListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postListener.onFailure(t);
            }
        });
    }

    public interface PostListener{
        void onSuccess(Response<Post> response);
        void onFailure(Throwable throwable);
    }

    public void getComment(int commentId){
        JsonPlaceholder.getAPI().getComment(commentId).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                commentListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                commentListener.onFailure(t);
            }
        });
    }

    public interface CommentListener{
        void onSuccess(Response<Comment> response);
        void onFailure(Throwable throwable);
    }

    public void getUsers(final int ... userId){
        final Users users = new Users();
        for(int i = 0, count = userId.length; i<count; ++i) {
            JsonPlaceholder.getAPI().getUser(userId[i]).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    users.add(response.body());
                    if(users.size() == userId.length) {
                        userListener.onSuccess(users);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    userListener.onFailure(t);
                }
            });
        }
    }

    public interface UserListener{
        void onSuccess(Users users);
        void onFailure(Throwable throwable);
    }

    public void getPhoto(int photoId){
        JsonPlaceholder.getAPI().getPhoto(photoId).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photoListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                photoListener.onFailure(t);
            }
        });
    }

    public interface PhotoListener{
        void onSuccess(Response<Photo> response);
        void onFailure(Throwable throwable);
    }

    public void getTodo(int todoId){
        JsonPlaceholder.getAPI().getTodo(todoId).enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                todoListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                todoListener.onFailure(t);
            }
        });
    }

    public interface TodoListener{
        void onSuccess(Response<Todo> response);
        void onFailure(Throwable throwable);
    }

}
