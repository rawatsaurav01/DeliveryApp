package com.example.deliveryapp.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deliveryapp.R;
import com.example.deliveryapp.databasePart.CustomAdapter;
import com.example.deliveryapp.databasePart.Users;
import com.example.deliveryapp.databasePart.UsersRepository;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private  static RecyclerView recyclerView;
    ArrayList<Users> usersArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView =v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        new Home.LoadDataTask().execute();
        return v;
    }

    class LoadDataTask extends AsyncTask<Void,Void,Void> {
        UsersRepository usersRepository;
        List<Users> usersList;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            usersRepository=new UsersRepository(getActivity());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            usersList=usersRepository.getUsers();
            usersArrayList=new ArrayList<>();
            for(int i=0;i<usersList.size();i++){
                usersArrayList.add(usersList.get(i));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            CustomAdapter customAdapter=new CustomAdapter(usersArrayList,Home.class);
            recyclerView.setAdapter(customAdapter);
        }
    }


}

