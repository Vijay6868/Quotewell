package com.example.quotewell;

import java.util.ArrayList;

public class QuotesModelList {
    private ArrayList<QuoteModel> quoteList;

    public QuotesModelList() {
        this.quoteList = new ArrayList<>();
    }
    public void addQuoteModel(QuoteModel quoteModel){
        quoteList.add(quoteModel);
    }

    public ArrayList<QuoteModel> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(ArrayList<QuoteModel> quoteList) {
        this.quoteList = quoteList;
    }
}
