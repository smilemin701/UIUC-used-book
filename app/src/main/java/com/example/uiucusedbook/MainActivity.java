package com.example.uiucusedbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        // Non-Essential: Easter Egg Text Shake.
        final TextView text1 = findViewById(R.id.text1atMain);
        final TextView text2 = findViewById(R.id.text2atMain);
        final TextView text3 = findViewById(R.id.text3atMain);
        final TextView text4 = findViewById(R.id.text4atMain);
        final TextView text5 = findViewById(R.id.text5atMain);
        final ImageView cslogo = findViewById(R.id.cs125logo);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_animation);
                text1.startAnimation(shake);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_animation);
                text2.startAnimation(shake);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_animation);
                text3.startAnimation(shake);
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_animation);
                text4.startAnimation(shake);
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_animation);
                text5.startAnimation(shake);
            }
        });
        cslogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation spin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
                cslogo.startAnimation(spin);
            }
        });

    }

}
