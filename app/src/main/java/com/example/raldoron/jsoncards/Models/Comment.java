package com.example.raldoron.jsoncards.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raldoron on 30.10.17.
 */

public class Comment {
    @SerializedName("postId")
    @Expose
    private int postId;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("body")
    @Expose
    private String body;

    public Comment(Comment comment) {
        this.postId = comment.postId;
        this.id = comment.id;
        this.name = comment.name;
        this.email = comment.email;
        this.body = comment.body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}