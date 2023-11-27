package com.Teste.spring.jpa.postgresql.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrument_quote")
public class InstrumentQuote {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "simbol")
  private String simbol;

  @Column(name = "price")
  private double price;

  @Column(name = "date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  public InstrumentQuote() {
  }

  public InstrumentQuote(String simbol, double price, Date date) {
    this.simbol = simbol;
    this.price = price;
    this.date = date;

  }

  public String getSimbol() {
    return this.simbol;
  }

  public double getPrice() {
    return this.price;
  }

  public String getData() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dataretorno = sdf.format(date);
    return dataretorno;
  }

  public void setSimbol(String simbol) {
    this.simbol = simbol;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", simbol=" + simbol + ", price=" + price + ", date=" + date + "]";
  }

  public String getDataFormatado() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dataretorno = sdf.format(date);
    return dataretorno;
  }
}
