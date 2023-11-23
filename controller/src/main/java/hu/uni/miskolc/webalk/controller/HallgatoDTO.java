package hu.uni.miskolc.webalk.controller;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.Nem;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class HallgatoDTO {

    private int id;

    private String neptunKod;

    private String teljesNev;

    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate szuletesiDatum;

    private Nem nem;


    public static Hallgato convertHallgatoDTOToHallgato(HallgatoDTO dto){
        Hallgato h = new Hallgato(dto.id, dto.neptunKod, dto.teljesNev, dto.email, dto.szuletesiDatum, dto.nem);
        return h;
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

    public HallgatoDTO() {
    }

    public HallgatoDTO(int id, String neptunKod, String teljesNev, String email, LocalDate szuletesiDatum, Nem nem) {
        this.id = id;
        this.neptunKod = neptunKod;
        this.teljesNev = teljesNev;
        this.email = email;
        this.szuletesiDatum = szuletesiDatum;
        this.nem = nem;
    }
}
