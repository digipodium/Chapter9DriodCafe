package com.example.chapter9driodcafe;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.chapter9driodcafe.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding bind;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = FragmentSecondBinding.bind(view);

        SecondFragmentArgs data = SecondFragmentArgs.fromBundle(getArguments());
        String orderName = data.getOrderName();
        bind.textOrderItem.setText(orderName);

        bind.radioDlvMethod.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.next_day:
                    Snackbar.make(bind.getRoot(),"next day delivery not available, kal ana", Snackbar.LENGTH_LONG).show();
                    break;
                case R.id.same_day:
                    Snackbar.make(bind.getRoot(),"same day delivery not available, kal ana", Snackbar.LENGTH_LONG).show();
                    break;
                case R.id.pick_up:
                    Snackbar.make(bind.getRoot(),"khud aa k to lena hi tha", Snackbar.LENGTH_LONG).show();
                    break;
            }
        });

        bind.btnPay.setOnClickListener(v -> {
            AlertDialog dialog = new AlertDialog.Builder(getActivity())
                    .setTitle("Confirm Payment")
                    .setMessage("Are you ready to pay money to an unreliable source. Press Ok to continue")
                    .setIcon(R.drawable.ic_baseline_shopping_cart_24)
                    .setPositiveButton("OK",(dialog1, which) -> {
                        Toast.makeText(getActivity(), "Under Construction", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel",(dialog1, which) -> {
                        Toast.makeText(getActivity(), "Bach gye", Toast.LENGTH_SHORT).show();
                    })
                    .create();
            dialog.show();
        });
    }
}