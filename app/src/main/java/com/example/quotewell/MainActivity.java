package com.example.quotewell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiCall();
    }

    private void apiCall() {
        QuoteModelControllerAPI quoteModelControllerAPI =
                new QuoteModelControllerAPI(this,"inspiration",MainActivity.this);
        quoteModelControllerAPI.getData();
    }

    @Override
    public void onDataLoaded(QuotesModelList quoteList) {

    }
}