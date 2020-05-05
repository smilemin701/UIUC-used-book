package com.example.uiucusedbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    private List<Transaction> listItems;
    private Context context;
    public Button sold;


    public TransactionAdapter(List<Transaction> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView transactionTitle;
        public TextView transactionAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            transactionTitle = itemView.findViewById(R.id.transactionTitle);
            transactionAuthor = itemView.findViewById(R.id.transactionAuthor);
            sold = itemView.findViewById(R.id.ifSold);


        }
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction, parent, false);
        sold = (Button) v.findViewById(R.id.ifSold);
        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(context, "sold", Toast.LENGTH_SHORT).show();
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction listItem = listItems.get(position);
        holder.transactionTitle.setText(listItem.getTitle());
        holder.transactionAuthor.setText(listItem.getAuthor());
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    /*
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.transaction, null);
        TextView transactionText = v.findViewById(R.id.transactionTitle);

        transactionText.setText(transactionList.get(i).getBookTitle());

        v.setTag(transactionList.get(i).getBookTitle());

        Button sold = (Button) v.findViewById(R.id.ifSold);
        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(context, "sold", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

     */
}
