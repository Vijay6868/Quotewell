package com.example.quotewell;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuoteModelControllerAPI
{
    private String baseURL = "https://zenquotes.io/api/quotes/keyword=%s";
    private String url;
    private QuotesModelList list;
    private QuoteModel singleQuote;
    private Context context;
    private DataCallback callback;

    public QuoteModelControllerAPI(DataCallback callback, String keyword, Context context) {

        list = new QuotesModelList();
        this.url = String.format(baseURL, keyword);
        this.context = context;
        this.callback = callback;
    }
    public void getData() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("api", "onResponse: " + response);
                        try {
                            JSONArray resultsArray = new JSONArray(response);
                            for (int i = 0; i < resultsArray.length(); i++) {
                                JSONObject singleObject = resultsArray.getJSONObject(i);
                                singleQuote = new QuoteModel(
                                        singleObject.getString("q"),
                                        singleObject.getString("a")
                                );
                                list.addQuoteModel(singleQuote); // Add the model to the list
                            }
                            callback.onDataLoaded(list); // Notify the callback
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("api", "VolleyError: " + error.toString());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
