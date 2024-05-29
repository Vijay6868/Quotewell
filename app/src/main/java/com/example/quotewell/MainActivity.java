package com.example.quotewell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements DataCallback{

    RecyclerView recyclerView;
    ImageView bt_search;
    EditText et_searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recView);
        bt_search = findViewById(R.id.bt_search);
        et_searchBar = findViewById(R.id.et_searchBar);
        apiCall("happiness"); //initial keyword
        handleBtSearch();
    }
    // allow user to play with JSON array user can search quotes by keyword
    private void handleBtSearch() {
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = et_searchBar.getText().toString();
                if (keyword != null && !keyword.isEmpty()) {
                    apiCall(keyword);
                }

            }
        });
    }
    //make api call
    private void apiCall(String _keyword) {
        QuoteModelControllerAPI quoteModelControllerAPI =
                new QuoteModelControllerAPI(this,_keyword,MainActivity.this);
        quoteModelControllerAPI.getData();
    }
    //data loads once api call completed
    @Override
    public void onDataLoaded(QuotesModelList quoteList) {
        RVAdapter adapter = new RVAdapter(quoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}