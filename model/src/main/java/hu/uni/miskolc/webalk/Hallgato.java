package hu.uni.miskolc.webalk;

import java.time.LocalDate;

public class Hallgato {

    private int id;

    private String neptunKod;

    private String teljesNev;

    private String email;

    private LocalDate szuletesiDatum;

    private Nem nem;

    public Hallgato() {
    }

    public Hallgato(int id, String neptunKod, String teljesNev, String email, LocalDate szuletesiDatum, Nem nem) {
        this.id = id;
        this.neptunKod = neptunKod;
        this.teljesNev = teljesNev;
        this.email = email;
        this.szuletesiDatum = szuletesiDatum;
        this.nem = nem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getTeljesNev() {
        return teljesNev;
    }

    public void setTeljesNev(String teljesNev) {
        this.teljesNev = teljesNev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(LocalDate szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    public Nem getNem() {
        return nem;
    }

    public void setNem(Nem nem) {
        this.nem = nem;
    }

    @Override
    public String toString() {
        return "Hallgato{" +
                "id=" + id +
                ", neptunKod='" + neptunKod + '\'' +
                ", teljesNev='" + teljesNev + '\'' +
                ", email='" + email + '\'' +
                ", szuletesiDatum=" + szuletesiDatum +
                ", nem=" + nem +
                '}';
    }
}
