package Artikel_racun;

public class Podjetje {
    private String ime;
    private  String davcnaStevilka;
    private String maticnaStevilka;
    private boolean davcniZavezanec;


    public Podjetje(String ime, String davcnaStevilka, String maticnaStevilka, boolean davcniZavezanec) {
        if(davcnaStevilka.length() != 8 || maticnaStevilka.length() != 10){
            System.out.println("Davcna ali maticna stevilka nima predpisane dolzine!");
        }
        else{
            this.ime = ime;
            this.davcnaStevilka = davcnaStevilka;
            this.maticnaStevilka = maticnaStevilka;
            this.davcniZavezanec = davcniZavezanec;
        }

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(String davcnaStevilka) {
        if(davcnaStevilka.length() != 8){
            System.out.println("Davcna stevilka nima predpisane dolzine!");
        }
        else{
            this.davcnaStevilka = davcnaStevilka;
        }
    }

    public String getMaticnaStevilka() {
        return maticnaStevilka;
    }

    public void setMaticnaStevilka(String maticnaStevilka) {
        if(maticnaStevilka.length() != 10){
            System.out.println("Maticna stevilka nima predpisane dolzine!");
        }
        else{
            this.maticnaStevilka = maticnaStevilka;
        }
    }

    public boolean isDavcniZavezanec() {
        return davcniZavezanec;
    }

    public void setDavcniZavezanec(boolean davcniZavezanec) {
        this.davcniZavezanec = davcniZavezanec;
    }
}
