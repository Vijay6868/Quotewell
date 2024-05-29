package com.example.quotewell;


//    {
//            "q": "Change is never easy, but always possible.",
//            "a": "Barack Obama",
//            "c": "42",
//            "h": "<blockquote>&ldquo;Change is never easy, but always possible.&rdquo; &mdash; <footer>Barack Obama</footer></blockquote>"
//            },
public class QuoteModel {
    private String q; // quote
    private String a; // author

    public QuoteModel(String q, String a) {
        this.q = q;
        this.a = a;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
