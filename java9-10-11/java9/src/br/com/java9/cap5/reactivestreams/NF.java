package br.com.java9.cap5.reactivestreams;

public class NF {

  private String client;
  private String book;
  private double amount;

  public NF(String client, String book, double amount) {
    this.client = client;
    this.book = book;
    this.amount = amount;
  }

  public boolean hasValidAmount() {
    return amount > 0;
  }
}