package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallgatoService {
    HallgatoDAO dao;

    public HallgatoService(@Autowired HallgatoDAO dao) {
        this.dao = dao;
    }

    /*   static List<Hallgato> hallgatok;

    static {
        hallgatok = new ArrayList<>();
        Hallgato h1 = new Hallgato(1,"ABC123","Kiss Béla","kiss.bela@pelda.hu", LocalDate.of(2000, Month.AUGUST,12),Nem.FERFI);
        hallgatok.add(h1);
    }


    public List<Hallgato> getHallgatok(){
        return hallgatok;

    }

    public void addHallgato(Hallgato hallgato){
        hallgatok.add(hallgato);
    }*/

    public List<Hallgato> getHallgatok(){
       return dao.getAllHallgato();
    }

    public void addHallgato(Hallgato hallgato) throws HallgatoMarLetezik {
        dao.createHallgato(hallgato);
    }

    public Hallgato getHallgatoById(int id) throws HallgatoNemTalalhatoException {
        return dao.getHallgatoById(id);
    }

    public List<Hallgato> getHallgatokByNem(Nem nem){
        List<Hallgato> result =  dao.getAllHallgato().stream().filter(h -> h.getNem().equals(nem)).collect(Collectors.toList());
        return result;
    }

    public List<Hallgato> getHallgatokEvekKozott(int fromYear, int toYear) {
        List<Hallgato> hallgatok = getHallgatok();
        List<Hallgato> result = new ArrayList<>();
        for (Hallgato h : hallgatok){
            if (h.getSzuletesiDatum().getYear()>= fromYear && h.getSzuletesiDatum().getYear() <=toYear){
                result.add(h);
            }
        }
        return result;
    }

    public List<Hallgato> getHallgatokByNeptunKod(String neptunKod) {
       return getHallgatok().stream().filter(h -> h.getNeptunKod().equalsIgnoreCase(neptunKod)).collect(Collectors.toList());
    }
}
