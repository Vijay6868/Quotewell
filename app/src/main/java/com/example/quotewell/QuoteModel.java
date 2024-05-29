package com.example.quotewell;


//    {
//            "q": "Change is never easy, but always possible.",
//            "a": "Barack Obama",
//            "c": "42",
//            "h": "<blockquote>&ldquo;Change is never easy, but always possible.&rdquo; &mdash; <footer>Barack Obama</footer></blockquote>"
//            },
public class QuoteModel {
    String q; // quote
    String a; // author

    public QuoteModel(String q, String a) {
        this.q = q;
        this.a = a;
    }
}
