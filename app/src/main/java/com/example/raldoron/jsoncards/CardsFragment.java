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

import com.example.raldoron.jsoncards.Models.Comment;
import com.example.raldoron.jsoncards.Models.Photo;
import com.example.raldoron.jsoncards.Models.Post;
import com.example.raldoron.jsoncards.Models.Todo;
import com.example.raldoron.jsoncards.Models.User;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Response;

/**
 * Created by Raldoron on 23.10.17.
 */

public class CardsFragment extends Fragment {

    private static final String CARDSFRAGMENT_TAG = "CardsFragment";

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private JsonResoursesAdapter adapter;

    private Post post;
    private Comment comment;
    private User user;
    private Photo photo;
    private Todo todo;

    private int randomTodoID;

    private ArrayList cards;
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

        cards = new ArrayList();
        randomTodoID = new Random().nextInt(200) + 1;

        jsonClient = new JsonClient(new JsonClient.PostListener() {
            @Override
            public void onSuccess(Response<Post> response) {
                if (response.isSuccessful()) {
                    post = new Post(response.body());
                    adapter.add(post);
                    recyclerView.setAdapter(adapter);
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
                    adapter.add(comment);
                    recyclerView.setAdapter(adapter);
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
            public void onSuccess(Response<User> response) {
                if (response.isSuccessful()) {
                    user = new User(response.body());
                    adapter.add(user);
                    recyclerView.setAdapter(adapter);
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
                    adapter.add(photo);
                    recyclerView.setAdapter(adapter);
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
                    adapter.add(todo);
                    recyclerView.setAdapter(adapter);
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
        jsonClient.getUser(1);
        jsonClient.getPhoto(1);
        jsonClient.getTodo(randomTodoID);

        adapter = new JsonResoursesAdapter(cards);
        recyclerView.setAdapter(adapter);
    }
}
