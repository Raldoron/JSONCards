package com.example.raldoron.jsoncards.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Raldoron on 04.11.17.
 */

public class Users {

    private ArrayList<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void add(User user){
        this.users.add(user);
    }

    public int size(){
        return this.users.size();
    }

    public void sort(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }
}
