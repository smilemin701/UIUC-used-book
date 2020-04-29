package com.example.uiucusedbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView transactionListView;
    private TransactionAdapter adapter;
    private List<Transaction> transactionList;
    private Button sold;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        transactionListView = getView().findViewById(R.id.TransactionListView);

        transactionList = new ArrayList<Transaction>();

        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 102"));
        transactionList.add(new Transaction("Chemistry 103"));
        transactionList.add(new Transaction("Chemistry 104"));
        transactionList.add(new Transaction("Chemistry 105"));
        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 102"));
        transactionList.add(new Transaction("Chemistry 103"));
        transactionList.add(new Transaction("Chemistry 104"));
        transactionList.add(new Transaction("Chemistry 105"));




        adapter = new TransactionAdapter(getContext().getApplicationContext(), transactionList);
        transactionListView.setAdapter(adapter);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
