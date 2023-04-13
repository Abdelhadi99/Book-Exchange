package com.example.bookexchange.ui.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookexchange.adapters.PostAdapter;
import com.example.bookexchange.R;
import com.example.bookexchange.models.Post;
import com.example.bookexchange.models.Request;

import java.util.ArrayList;
import java.util.List;


public class PostsFragment extends Fragment {


    RecyclerView recyclerView;
    public static PostAdapter myadapter;
    public static List<Post> myList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_posts, container, false);


        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        Post post4 = new Post();
        Post post5 = new Post();
        Post post6 = new Post();


        myList.add(post1);
        myList.add(post2);
        myList.add(post3);
        myList.add(post4);
        myList.add(post5);


        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        myadapter = new PostAdapter(requireContext(), myList);
        recyclerView.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);


    }


    private void filtertext(String text) {

        List<Post> filteredList = new ArrayList<>();

        for (Post post : myList) {

            if (post.getBookName().toLowerCase().contains(text.toLowerCase())) {

                filteredList.add(post);

            }

            if (filteredList.isEmpty()) {


            } else {

                myadapter.setfilteredlist(filteredList);

            }

        }
    }


}