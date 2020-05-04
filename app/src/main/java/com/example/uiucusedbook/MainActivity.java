package com.example.uiucusedbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView transactionListView;
    private TransactionAdapter adapter1;
    private List<Transaction> transactionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List of Current Transaction

        transactionListView = findViewById(R.id.TransactionListView);

        transactionList = new ArrayList<Transaction>();

        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 101"));
        transactionList.add(new Transaction("Chemistry 101"));

        adapter1 = new TransactionAdapter(getApplicationContext(), transactionList);
        //transactionListView.setAdapter(adapter);







        final Button profileButton = findViewById(R.id.profileButton);
        final Button BuyButton = findViewById(R.id.BuyButton);
        final Button SellButton = findViewById(R.id.SellButton);
        final LinearLayout initialPage = findViewById(R.id.firstPage);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                initialPage.setVisibility(View.GONE);
                profileButton.setBackgroundColor(getResources().getColor(R.color.light));
                BuyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                SellButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ProfileFragment());
                fragmentTransaction.commit();

            }
        });



        BuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                initialPage.setVisibility(View.GONE);
                BuyButton.setBackgroundColor(getResources().getColor(R.color.light));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                SellButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new BuyFragment());
                fragmentTransaction.commit();

            }
        });

        SellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                initialPage.setVisibility(View.GONE);
                SellButton.setBackgroundColor(getResources().getColor(R.color.light));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                BuyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new SaleFragment());
                fragmentTransaction.commit();

            }
        });

    }
}
