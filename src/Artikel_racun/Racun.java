package Artikel_racun;

import Barcode.Barcode_PDF;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Racun implements Searchable{

    private UUID ID;
    private Date datum;
    private Artikli seznam;
    private Podjetje izdajatelj;
    private String davcnaStevilka;
    private String davcnaStevilkaKupca;

    public Podjetje getIzdajatelj() {
        return izdajatelj;
    }

    public void setIzdajatelj(Podjetje izdajatelj) {
        this.izdajatelj = izdajatelj;
    }

    public String getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(String davcnaStevilka) {
        this.davcnaStevilka = "SI" + davcnaStevilka;
    }

    public Racun(Date datum, Artikli seznam, Podjetje izd, String davc) {
        SimpleDateFormat dateF = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat timeF = new SimpleDateFormat("hhmm");
        SimpleDateFormat secondF = new SimpleDateFormat("ssss");
        SimpleDateFormat millisecondF = new SimpleDateFormat("S");

        this.ID = UUID.fromString(dateF.format(datum)+"-"+timeF.format(datum)+"-"+secondF.format(datum)+"-b000-000000"+millisecondF.format(datum));
        this.datum = datum;
        this.seznam = seznam;
        this.izdajatelj = izd;
        this.davcnaStevilka = "SI" + davc;
        this.davcnaStevilkaKupca = "";
        //Barcode_PDF.createPDF(this.ID+".png", ID.toString());

        if (!aliJeDavcniZavezanec(this.izdajatelj)){
            System.out.println("Davcni stevili se ne ujemata");
        }
    }

    public UUID getID() {
        return ID;
    }

    private void setID(UUID ID) {
        this.ID = ID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Artikli getSeznam() {
        return seznam;
    }

    public void setSeznam(Artikli seznam) {
        this.seznam = seznam;
    }

    public String getDavcnaStevilkaKupca() {
        return davcnaStevilkaKupca;
    }

    public void setDavcnaStevilkaKupca(String davcnaStevilkaKupca) {
        this.davcnaStevilkaKupca = davcnaStevilkaKupca;
    }

    public BigDecimal GenerirajCenoRacuna(){

        BigDecimal skupajCena = new BigDecimal("0");

        for (Artikel pomozni: this.seznam.getArtikli()){

            for (int i=0; i<pomozni.getKolicina(); i++){
                skupajCena = skupajCena.add(pomozni.getCena());
            }
        }
        return skupajCena;
    }

    public BigDecimal GenerirajCenoRacunaZDDV(){

        BigDecimal skupajCena = new BigDecimal("0");
        BigDecimal sto = new BigDecimal("100");
        BigDecimal nizka = new BigDecimal("9.5");
        BigDecimal visoka = new BigDecimal("22");

        for (Artikel pomozni: this.seznam.getArtikli()){
            for (int i=0; i<pomozni.getKolicina(); i++){
                if(pomozni.getDavcnaStopnja() == 9.5){
                    BigDecimal vmesni = new BigDecimal("0");
                    vmesni = pomozni.getCena();
                    vmesni = vmesni.multiply(nizka);
                    vmesni = vmesni.divide(sto, 2, RoundingMode.HALF_UP);
                    vmesni = vmesni.add(pomozni.getCena());
                    skupajCena = skupajCena.add(vmesni);
                }
                else{
                    BigDecimal vmesni = new BigDecimal("0");
                    vmesni = pomozni.getCena();
                    vmesni = vmesni.multiply(visoka);
                    vmesni = vmesni.divide(sto, 2, RoundingMode.HALF_UP);
                    vmesni = vmesni.add(pomozni.getCena());
                    skupajCena = skupajCena.add(vmesni);

                }
            }
        }
        return skupajCena;
    }

    public void odstraniArtikel(Artikel a){
        this.seznam.odstraniArtikel(a);
    }

    public void printajRacun(){
        System.out.println("___________________________________________________");
        System.out.println("Izdelek             Kolicina    Cena za kos     DDV");

        for (Artikel pomozni: this.getSeznam().getArtikli()){

            System.out.print(pomozni.getIme());
            for(int i=pomozni.getIme().length(); i<27; i++){
                System.out.print(" ");
            }
            System.out.print(pomozni.getKolicina());
            System.out.print("           ");
            System.out.print(pomozni.getCena());
            System.out.print("     ");
            System.out.println(pomozni.getDavcnaStopnja());

        }
        System.out.println();
        System.out.println("Skupaj cena brez DDV:  "+this.GenerirajCenoRacuna()+" €");
        System.out.println("Skupaj cena z DDV:  "+this.GenerirajCenoRacunaZDDV()+" €\n");


        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        System.out.println("Datum: "+dt.format(this.getDatum()));

        System.out.println("ID racuna: "+this.getID().toString());
        System.out.println("Izdajatelj: "+this.getIzdajatelj().getIme().toString());
        System.out.println("Davcna stevilka: "+this.getDavcnaStevilka().toString());
        System.out.println("___________________________________________________");
    }

    @Override
    public boolean search(String t) {
        if(t.contains(this.ID.toString())){
            return true;
        }
        else if(t.contains(this.datum.toString())){
            return true;
        }
        else if(t.contains(this.davcnaStevilka)){
            return true;
        }
        else if(t.contains(this.izdajatelj.getIme())){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean aliJeDavcniZavezanec(Podjetje izd){
        if(this.davcnaStevilka.equals(izd.getDavcnaStevilka())){
            return true;
        }
        else{
            return false;
        }
    }
}
