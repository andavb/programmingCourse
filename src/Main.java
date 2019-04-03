import Artikel_racun.*;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;



public class Main {

    public static void main(String[] args) {

        Podjetje tus = new Podjetje("Engrotuš d. o. o.", "87927497", "5494516000", true);
        Podjetje spar = new Podjetje("SPAR SLOVENIJA d.o.o.", "32156782", "5571693000", true);
        Podjetje mercator = new Podjetje("MERCATOR, d.d.", "45884595", "5300231000", true);

        Artikel kruh = new Artikel("2116789020102", "Kruh", new BigDecimal("2.34"),9.5, "Slovenija");
        Artikel meso = new Artikel("2058232100202", "Meso", new BigDecimal("3.34"),9.5, "Slovenija");
        Artikel banane = new Artikel("2152342031202", "Meso", new BigDecimal("3.34"),9.5, "Slovenija");
        Artikel zobnaPasta = new Artikel("0002002100112", "Zobna pasta", new BigDecimal("3.19"),9.5, "Nemčija");
        Artikel argetaPasteta = new Artikel("0003001000112","Pašteta Argeta", new BigDecimal(".99"),9.5, "Nemčija");
        Artikel sampon = new Artikel("0002302000113","Šampon", new BigDecimal("4.79"),9.5, "Hrvaška");
        Artikel kosmici = new Artikel("0001002000114","Kosmiči", new BigDecimal("3.55"),9.5, "Italija");
        Artikel ciki = new Artikel("0001002000115","Ciki", new BigDecimal("3.60"),22, "Avstrija");

        Artikli zaRacun1 = new Artikli();
        List<Racun> seznamRacunov = new ArrayList<>();

        zaRacun1.dodajArtikel(new Artikel(kruh));
        zaRacun1.dodajArtikel(new Artikel(meso));
        zaRacun1.dodajArtikel(new Artikel(zobnaPasta));
        zaRacun1.dodajArtikel(new Artikel(argetaPasteta));
        zaRacun1.dodajArtikel(new Artikel(sampon));
        zaRacun1.dodajArtikel(new Artikel(kosmici));
        zaRacun1.dodajArtikel(new Artikel(ciki));
        zaRacun1.dodajArtikel(new Artikel(ciki));

        seznamRacunov.add(new Racun(new Date(), zaRacun1, tus, tus.getDavcnaStevilka()));

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

        seznamRacunov.add(new Racun(new Date(), zaRacun2, spar, spar.getDavcnaStevilka()));

        for (Racun racuni: seznamRacunov){
            racuni.printajRacun();
            System.out.println("Search for SPAR SLOVENIJA d.o.o.: " + racuni.search("SPAR"));
        }

        System.out.println("Search for Šampon: " + sampon.search("Šampon"));
        System.out.println("Search for Šadmpon: " + sampon.search("Šadmpon"));

        System.out.println(sampon.getEAN());



        System.out.println(sampon.getEAN());
        System.out.println(Artikel.checkDigit(sampon.getEAN(), 0));

        String proba = zaRacun1.toJson();

        Helper.pisanjeJSONdatotek(Artikli.class, zaRacun1);

        Artikli fromJSON = zaRacun1.fromJson(proba);

        System.out.println(fromJSON.getArtikli().get(2).getIme());


        String s = Helper.branjeJSONdatotek("/Users/andrejavbelj/IdeaProjects/vaja1/JSON_files/file.json");

        System.out.println(s);

        System.out.println(banane.novaTeza("01001"));

        banane.razberiEAN();
    }
}
