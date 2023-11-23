package hu.uni.miskolc.webalk.dao;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;

import java.util.ArrayList;
import java.util.List;

public interface HallgatoDAO {

    default List<Hallgato> getAllHallgato() {
        return new ArrayList<>();
    }

    void createHallgato(Hallgato hallgato) throws HallgatoMarLetezik;

    Hallgato getHallgatoById(int id) throws HallgatoNemTalalhatoException;

    void updateHallgato(Hallgato hallgato);

    void deleteHallgato(Hallgato hallgato) throws HallgatoNemTalalhatoException;
}
