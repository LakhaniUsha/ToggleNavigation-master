package com.test.myfirst.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {


    Pokemonadapter adapter;
    ArrayList<pokemon> pokemonArray;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Call<pokemonPojo> call = services.getPokeobj();
        call.enqueue(new Callback<pokemonPojo>() {
            @Override
            public void onResponse(Call<pokemonPojo> call, Response<pokemonPojo> response) {

                pokemonPojo pojo = response.body();
                try {

                } catch (NullPointerException e) {

                    System.out.println(e.getMessage());
                }
                pokemonArray = new ArrayList<>(pojo.getPokemon());
                generateData(pokemonArray);

            }

            @Override
            public void onFailure(Call<pokemonPojo> call, Throwable t) {


                Toast.makeText(getActivity().getApplicationContext(), "tryagain", Toast.LENGTH_LONG).show();
            }
        });

        return inflater.inflate(R.layout.fragment_first, container, false);

    }


    //  @Override
    // public void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);


    getDataservices services = RetrofitClientInstnce.getRetrofitInstance().create(getDataservices.class);



    public void generateData(ArrayList<pokemon> pokelist)/*(ArrayList<pokemon> pokelist)*/
    {
        /*ArrayList<pokemon> pokes= (ArrayList<pokemon>) pokemonList;*/
        adapter = new Pokemonadapter(pokelist,getActivity().getApplicationContext());
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView =getView().findViewById(R.id.recycle_poke);
        recyclerView .setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }




}
