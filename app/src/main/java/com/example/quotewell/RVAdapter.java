package com.example.quotewell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVHolder> {
    private QuotesModelList quoteModelArrayList;

    public RVAdapter(QuotesModelList quoteModelArrayList) {
        this.quoteModelArrayList = quoteModelArrayList;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent,false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        QuoteModel quoteModel = quoteModelArrayList.getQuoteList().get(position);

        holder.tv_quote.setText(quoteModel.getQ());
        holder.tv_author.setText(quoteModel.getA());
    }

    @Override
    public int getItemCount() {
        return quoteModelArrayList.getQuoteList().size();
    }
}
