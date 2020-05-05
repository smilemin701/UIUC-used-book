package com.example.uiucusedbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BuyBooksAdapter extends RecyclerView.Adapter<BuyBooksAdapter.ViewHolder> {

    private List<BooksOnBuyList> listItems;
    private List<BooksOnBuyList> fullListItems;
    private Context context;

    public BuyBooksAdapter(List<BooksOnBuyList> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        fullListItems = new ArrayList<>(listItems);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_on_buy_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BooksOnBuyList listItem = listItems.get(position);
        holder.description.setText(listItem.getDescription());
        holder.author.setText(listItem.getAuthor());
        holder.title.setText(listItem.getTitle());

        holder.emailSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendMail(listItem.getSellerEmail());
                Toast.makeText(context, "email Sent", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;
        public TextView description;
        public ImageButton emailSender;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.BuyTitle);
            author = itemView.findViewById(R.id.BuyAuthor);
            description = itemView.findViewById(R.id.BuyDescription);
            emailSender = itemView.findViewById(R.id.emailSender);
        }
    }

    public void sendMail(String email) {
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        String message = "Someone wants your book! Contact her/him: " + user;
        JavaMailAPI javaMailAPI = new JavaMailAPI(context, "mc43@illinois.edu", "UIUC Used Book Market", message);
        javaMailAPI.execute();
    }


    public void filterList(ArrayList<BooksOnBuyList> filteredList) {
        listItems = filteredList;
        notifyDataSetChanged();
    }
}
