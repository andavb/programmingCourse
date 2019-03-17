package Artikel_racun;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class Artikel implements Searchable{

    private long EAN;
    private String ime;
    private BigDecimal cena;
    private double davcnaStopnja;
    private int kolicina;
    private String drzava;

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikel(String ime, BigDecimal cena, double davcnaStopnja, String drzava) {

        UUID code = UUID.randomUUID();
        long id = Math.abs(code.hashCode());
        id += 11000000000L;

        this.EAN = id;
        this.ime = ime;
        this.cena = cena;
        this.davcnaStopnja = davcnaStopnja;
        this.kolicina = 1;
        this.drzava = drzava;
    }

    public Artikel(Artikel q) {
        this.EAN = q.getEAN();
        this.ime = q.getIme();
        this.cena = q.getCena();
        this.davcnaStopnja = q.getDavcnaStopnja();
        this.kolicina = q.getKolicina();
        this.drzava = q.getDrzava();
    }

    public long getEAN() {
        return EAN;
    }

    public void setEAN(long EAN) {
        this.EAN = EAN;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public double getDavcnaStopnja() {
        return davcnaStopnja;
    }

    public void setDavcnaStopnja(double davcnaStopnja) {
        this.davcnaStopnja = davcnaStopnja;
    }

    public void povecajKolicino(int kol){
        this.kolicina += kol;
    }
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "EAN=" + EAN +
                ", ime='" + ime + '\'' +
                ", cena=" + cena +
                ", davcnaStopnja=" + davcnaStopnja +
                ", kolicina=" + kolicina +
                '}';
    }

    @Override
    public boolean search(String t) {
        if(t.equals(this.EAN)){
            return true;
        }
        else if(t.equals(this.ime)){
            return true;
        }
        else if(t.equals(this.cena)){
            return true;
        }
        else{
            return false;
        }
    }

    static public boolean checkDigit(long koda, int v){
        int sestevek = 0;
        long stevilo = 0;
        int pomozno = 0;
        int rezultat = 0;
        int stevec = 1;

        while (koda > 0) {
            stevilo = koda % 10;

            if(stevec % 2 == 0){
                sestevek += stevilo*1;
            }
            else{
                sestevek += stevilo*3;
            }
            koda = koda / 10;

            stevec++;
        }

        pomozno = (int)Math.ceil(sestevek / 10.0)*10;

        rezultat = pomozno - sestevek;


        if(rezultat == v){
            return true;
        }
        else{
            return false;
        }
    }

}
