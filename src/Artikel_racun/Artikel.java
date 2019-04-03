package Artikel_racun;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class Artikel implements Searchable{

    private String EAN;
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

    public Artikel(String id, String ime, BigDecimal cena, double davcnaStopnja, String drzava) {

        /*UUID code = UUID.randomUUID();
        long id = Math.abs(code.hashCode());

        if(drzava.equals("Slovenija")){
            id += 11000000000L;
        }
        else if(drzava.equals("Nemčija")){
            id += 21000000000L;
        }
        else if(drzava.equals("Avstrija")){
            id += 31000000000L;
        }
        else if(drzava.equals("Hrvaška")){
            id += 41000000000L;
        }
        else if(drzava.equals("Italija")){
            id += 51000000000L;
        }
        else
        {
            id += 91000000000L;
        }*/

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

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
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
        if(t.contains(this.getEAN())){
            return true;
        }
        else if(t.contains(this.ime)){
            return true;
        }
        else if(t.contains(this.cena.toString())){
            return true;
        }
        else{
            return false;
        }
    }

    static public boolean checkDigit(String koda, int v){
        int sestevek = 0;
        int stevilo = 0;
        int pomozno = 0;
        int rezultat = 0;
        int stevec = 1;
        int i = koda.length();


        while (i >0) {
            stevilo = Integer.parseInt(""+koda.charAt(i-1));
            if(stevec % 2 == 0){
                sestevek += stevilo*1;
            }
            else{
                sestevek += stevilo*3;
            }

            stevec++;
            i--;
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

    public String novaTeza(String teza){
        String koda = this.getEAN();
        char[] nova = koda.toCharArray();
        int i=7;
        int j=0;
        System.out.println(koda);
        if(koda.charAt(12) == '2' && teza.length() == 5){
            while (i < 12) {
                nova[i] = teza.charAt(j);
                j++;
                i++;
            }

            this.setEAN(String.valueOf(nova));

            return this.getEAN();
        }

        return null;
    }

    public void razberiEAN(){
        String koda = this.getEAN();
        char[] nova = koda.toCharArray();
        String oddelek = "";
        String id = "";
        String teza = "";
        String chechDigit = String.valueOf(koda.charAt(12));

        int i=0;

        while (i < 13) {
            if(i <= 2 && i >= 0){
                oddelek += String.valueOf(nova[i]);
            }
            else if(i <= 6 && i >= 3){
                id += String.valueOf(nova[i]);
            }
            else if(i <= 11 && i >= 7){
                teza += String.valueOf(nova[i]);
            }
            i++;
        }

        System.out.println("Oddelek: " + oddelek + " Id: " + id + " Teza: " + teza + "g CheckDigit: " + chechDigit);

    }

}
