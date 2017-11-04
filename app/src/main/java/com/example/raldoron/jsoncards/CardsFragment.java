package com.example.raldoron.jsoncards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.Models.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import retrofit2.Response;

/**
 * Created by Raldoron on 23.10.17.
 */

public class CardsFragment extends Fragment {

    private static final String CARDSFRAGMENT_TAG = "CardsFragment";

    private static final int POST_POSITION = 0;
    private static final int COMMENT_POSITION = 1;
    private static final int USERS_POSITION = 2;
    private static final int PHOTO_POSITION = 3;
    private static final int TODO_POSITION = 4;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private JsonResoursesAdapter adapter;

    private Post post;
    private Comment comment;
    private Users users;
    private Photo photo;
    private Todo todo;

    private int randomTodoID;
    private static final int photoID = 3;

    private ArrayList cards;
    private static final int CARDS_CAPACITY = 5;
    private static final int MAX_POST_ID = 100;
    private static final int MAX_COMMENT_ID = 500;

    private JsonClient jsonClient;

    public CardsFragment () {}

    public static CardsFragment getInstance() {
        CardsFragment cardsFragment = new CardsFragment();
        cardsFragment.setArguments(new Bundle());
        return cardsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View cardsView = inflater.inflate(R.layout.fragment_cards, container, false);
        recyclerView = (RecyclerView) cardsView.findViewById(R.id.cards_list);

        return cardsView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        cards = new ArrayList(CARDS_CAPACITY);
        users = new Users();
        post = new Post();
        comment = new Comment();
        photo = new Photo();
        todo = new Todo();
        cards.addAll(Arrays.asList(post, comment, users, photo, todo));

        randomTodoID = new Random().nextInt(200) + 1;

        jsonClient = new JsonClient(new JsonClient.PostListener() {
            @Override
            public void onSuccess(Response<Post> response) {
                if (response.isSuccessful()) {
                    post = new Post(response.body());
                    updateData(post);
                } else {
                    Log.d(CARDSFRAGMENT_TAG, "Post response");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(CARDSFRAGMENT_TAG, "Get post", throwable);
            }
        }, new JsonClient.CommentListener() {
            @Override
            public void onSuccess(Response<Comment> response) {
                if (response.isSuccessful()) {
                    comment = new Comment(response.body());
                    updateData(comment);
                } else {
                    Log.d(CARDSFRAGMENT_TAG, "Comment response");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(CARDSFRAGMENT_TAG, "Get comment", throwable);
            }
        }, new JsonClient.UserListener() {
            @Override
            public void onSuccess(Users users) {
                if (users != null) {
                    users.sort();
                    updateData(users);
                } else {
                    Log.d(CARDSFRAGMENT_TAG, "User response");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(CARDSFRAGMENT_TAG, "Get user", throwable);
            }
        }, new JsonClient.PhotoListener() {
            @Override
            public void onSuccess(Response<Photo> response) {
                if (response.isSuccessful()) {
                    photo = new Photo(response.body());
                    updateData(photo);
                } else {
                    Log.d(CARDSFRAGMENT_TAG, "Photo response");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(CARDSFRAGMENT_TAG, "Get photo", throwable);
            }
        }, new JsonClient.TodoListener() {
            @Override
            public void onSuccess(Response<Todo> response) {
                if (response.isSuccessful()){
                    todo = new Todo(response.body());
                    updateData(todo);
                } else {
                    Log.d(CARDSFRAGMENT_TAG, "Todo response");
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(CARDSFRAGMENT_TAG, "Get todo", throwable);
            }
        });

        jsonClient.getPost(1);
        jsonClient.getComment(1);
        jsonClient.getUsers(1, 2, 3, 4, 5);
        jsonClient.getPhoto(photoID);
        jsonClient.getTodo(randomTodoID);

        adapter = new JsonResoursesAdapter(
                cards,
                new JsonResoursesAdapter.PostButtonListener() {
                    @Override
                    public void onClick(int postId) {
                        if (postId != 0) {
                            if (postId < MAX_POST_ID) {
                                jsonClient.getPost(postId);
                            } else {
                                Toast.makeText(getContext(), "Post ID shouldn't be greater than 100", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                },
                new JsonResoursesAdapter.CommentButtonListener() {
                    @Override
                    public void onClick(int commentId) {
                        if (commentId != 0) {
                            if (commentId < MAX_COMMENT_ID) {
                                jsonClient.getComment(commentId);
                            } else {
                                Toast.makeText(getContext(), "Comment ID shouldn't be greater than 500", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );
        recyclerView.setAdapter(adapter);
    }

    private void updateData(Object object){
        int index;
        if (object instanceof Post){
            index = POST_POSITION;
        } else if (object instanceof Comment){
            index = COMMENT_POSITION;
        } else if (object instanceof Users){
            index = USERS_POSITION;
        } else if (object instanceof Photo){
            index = PHOTO_POSITION;
        } else {
            index = TODO_POSITION;
        }
        cards.set(index, object);
        adapter.update(cards);
        recyclerView.setAdapter(adapter);
    }

}
