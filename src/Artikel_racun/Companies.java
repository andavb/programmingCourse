package Artikel_racun;

import com.google.gson.Gson;

import java.util.List;

public class Companies implements JsonSupport{

    private List<Podjetje> podjetja;

    public Companies(List<Podjetje> podjetja) {
        this.podjetja = podjetja;
    }

    public List<Podjetje> getPodjetja() {
        return podjetja;
    }

    public void setPodjetja(List<Podjetje> podjetja) {
        this.podjetja = podjetja;
    }

    @Override
    public String toJson() {
        Gson g = new Gson();
        String n = g.toJson(this);

        return n;
    }

    @Override
    public Companies fromJson(String podatki) {
        Gson g = new Gson();

        Companies n = g.fromJson(podatki, Companies.class);

        return n;
    }
}
