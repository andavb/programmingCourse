package Artikel_racun;

public interface JsonSupport {
    public String toJson();
    public <T> T fromJson(String podatki);
}
