package com.example.uiucusedbook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TransactionAdapter extends BaseAdapter {
    private Context context;
    private List<Transaction> transactionList;

    public TransactionAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @Override
    public int getCount() {
        return transactionList.size();
    }

    @Override
    public Object getItem(int i) {
        return transactionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.transaction, null);
        TextView transactionText = v.findViewById(R.id.transactionText);

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
}
