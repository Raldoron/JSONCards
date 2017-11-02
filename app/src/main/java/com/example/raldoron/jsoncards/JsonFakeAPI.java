package com.example.raldoron.jsoncards;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.Models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Raldoron on 26.10.17.
 */

public interface JsonFakeAPI {

    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/comments/{id}")
    Call<Comment> getComment(@Path("id") int commentId);

    @GET("/users/{id}")
    Call<User> getUser(@Path("id") int userId);

    @GET("/photos/{id}")
    Call<Photo> getPhoto(@Path("id") int photoId);

    @GET("/todos/{id}")
    Call<Todo> getTodo(@Path("id") int todoId);
}
