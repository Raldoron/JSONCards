package com.example.raldoron.jsoncards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Raldoron on 22.10.17.
 */

public class ContactsFragment extends Fragment {

    public ContactsFragment(){}

    public static ContactsFragment getInstance() {
        ContactsFragment contactsFragment = new ContactsFragment();
        contactsFragment.setArguments(new Bundle());
        return contactsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View contactsView = inflater.inflate(R.layout.fragment_contacts, container, false);

        return contactsView;
    }
}
