package Artikel_racun;

import com.google.gson.Gson;

import java.util.List;

public class Invoices implements JsonSupport{
    private List<Racun> artikli;


    public Invoices(List<Racun> artikli) {
        this.artikli = artikli;
    }

    public List<Racun> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Racun> artikli) {
        this.artikli = artikli;
    }

    @Override
    public String toJson() {
        Gson g = new Gson();
        String n = g.toJson(this);

        return n;
    }

    @Override
    public Invoices fromJson(String podatki) {
        Gson g = new Gson();

        Invoices n = g.fromJson(podatki, Invoices.class);

        return n;
    }
}
