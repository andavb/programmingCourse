package Artikel_racun;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Artikli implements JsonSupport{

    private List<Artikel> artikli;

    public Artikli(){
        this.artikli = new ArrayList<>();
    }
    public void dodajArtikel(Artikel a) {
        int i=0;

        for(Artikel pomozni: this.artikli){
            if(pomozni.getIme().equals(a.getIme())){
                pomozni.povecajKolicino(1);
                i = 1;
                break;
            }
        }

        if(i == 0){
            this.artikli.add(a);
        }
    }

    public void odstraniArtikel(Artikel a) {
        int i=0;

        for(Artikel pomozni: this.artikli){
            if(pomozni.getIme().equals(a.getIme())){
                if (pomozni.getKolicina()>1){
                    pomozni.povecajKolicino(-1);
                    i = 1;
                    break;
                }
                else{
                    this.artikli.remove(pomozni);
                    break;
                }
            }
        }

        if(i == 0){
            this.artikli.remove(a);
        }
    }

    public List<Artikel> getArtikli() {
        return artikli;
    }

    private void setArtikli(List<Artikel> artikli) {
        this.artikli = artikli;
    }

    @Override
    public String toJson() {
        Gson g = new Gson();
        String n = g.toJson(this);

        return n;
    }

    @Override
    public Artikli fromJson(String podatki) {
        Gson g = new Gson();


        Artikli n = g.fromJson(podatki, Artikli.class);

        return n;
    }
}
