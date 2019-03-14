import Artikel_racun.Artikel;
import Artikel_racun.Artikli;
import Artikel_racun.Racun;
import Barcode.Barcode_PDF;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



public class Main {

    public static void main(String[] args) {

        Artikel kruh = new Artikel("Kruh", new BigDecimal("2.34"),9.5);
        Artikel zobnaPasta = new Artikel("Zobna pasta", new BigDecimal("3.19"),9.5);
        Artikel argetaPasteta = new Artikel("Pašteta Argeta", new BigDecimal(".99"),9.5);
        Artikel sampon = new Artikel("Šampon", new BigDecimal("4.79"),9.5);
        Artikel kosmici = new Artikel("Kosmiči", new BigDecimal("3.55"),9.5);
        Artikel ciki = new Artikel("Ciki", new BigDecimal("3.60"),22);

        Artikli zaRacun1 = new Artikli();
        List<Racun> seznamRacunov = new ArrayList<>();

        zaRacun1.dodajArtikel(new Artikel(kruh));
        zaRacun1.dodajArtikel(new Artikel(zobnaPasta));
        zaRacun1.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun1.dodajArtikel(new Artikel(sampon));
        zaRacun1.dodajArtikel(new Artikel(kosmici));
        zaRacun1.dodajArtikel(new Artikel(ciki));
        zaRacun1.dodajArtikel(new Artikel(ciki));

        seznamRacunov.add(new Racun(new Date(), zaRacun1));

        Artikli zaRacun2 = new Artikli();

        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(sampon));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kruh));
        zaRacun2.dodajArtikel(new Artikel(kosmici));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.dodajArtikel(new Artikel(ciki));
        zaRacun2.odstraniArtikel(new Artikel(ciki));

        seznamRacunov.add(new Racun(new Date(), zaRacun2));




        for (Racun racuni: seznamRacunov){
            System.out.println("___________________________________________________");
            System.out.println("Izdelek             Kolicina    Cena za kos     DDV");

            for (Artikel pomozni: racuni.getSeznam().getArtikli()){

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
            System.out.println("Skupaj cena brez DDV:  "+racuni.GenerirajCenoRacuna()+" €");
            System.out.println("Skupaj cena z DDV:  "+racuni.GenerirajCenoRacunaZDDV()+" €\n");


            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            System.out.println("Datum: "+dt.format(racuni.getDatum()));

            System.out.println("ID racuna: "+racuni.getID().toString());
            System.out.println("___________________________________________________");

        }

    }
}
