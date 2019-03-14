package Artikel_racun;

import java.math.BigDecimal;
import java.util.UUID;

public class Artikel {

    private UUID ID;
    private String ime;
    private BigDecimal cena;
    private double davcnaStopnja;
    private int kolicina;

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikel(String ime, BigDecimal cena, double davcnaStopnja) {

        this.ime = ime;
        this.cena = cena;
        this.davcnaStopnja = davcnaStopnja;
        this.kolicina = 1;
    }

    public Artikel(Artikel q) {
        this.ID = q.ID;
        this.ime = q.getIme();
        this.cena = q.getCena();
        this.davcnaStopnja = q.getDavcnaStopnja();
        this.kolicina = q.getKolicina();
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
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
}
