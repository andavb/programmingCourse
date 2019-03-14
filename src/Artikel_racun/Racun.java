package Artikel_racun;

import Barcode.Barcode_PDF;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Racun {

    private UUID ID;
    private Date datum;
    private Artikli seznam;

    public Racun(Date datum, Artikli seznam) {
        SimpleDateFormat dateF = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat timeF = new SimpleDateFormat("hhmm");
        SimpleDateFormat secondF = new SimpleDateFormat("ssss");
        SimpleDateFormat millisecondF = new SimpleDateFormat("S");

        this.ID = UUID.fromString(dateF.format(datum)+"-"+timeF.format(datum)+"-"+secondF.format(datum)+"-b000-000000"+millisecondF.format(datum));
        this.datum = datum;
        this.seznam = seznam;
        Barcode_PDF.createPDF(this.ID+".png", ID.toString());
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
}
