package com.example.quotewell;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv_author, tv_quote;
    public RVHolder(@NonNull View itemView) {
        super(itemView);
        tv_author = itemView.findViewById(R.id.tv_author);
        tv_quote = itemView.findViewById(R.id.tv_quote);
    }
}
