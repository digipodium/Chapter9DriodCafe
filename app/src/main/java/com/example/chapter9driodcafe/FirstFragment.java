package com.example.chapter9driodcafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.chapter9driodcafe.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding bind;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentFirstBinding.bind(view);
        bind.imgDonut.setOnClickListener(v -> {
            sendOrder("Donut");
        });
        bind.imgFroyo.setOnClickListener(v -> {
            sendOrder("Froyo");
        });
        bind.imgIce.setOnClickListener(v -> {
            sendOrder("Ice cream sandwich");
        });
    }

    private void sendOrder(String order) {
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment dirs = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        dirs.setOrderName(order);
        NavHostFragment.findNavController(this).navigate(dirs);
    }
}