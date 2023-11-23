package hu.uni.miskolc.webalk;

import hu.uni.miskolc.webalk.dao.HallgatoDAO;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig {

    @Bean
    public HallgatoService hallgatoService(){
        return new HallgatoService(new HallgatoDAO() {
            @Override
            public void createHallgato(Hallgato hallgato) {

            }

            @Override
            public Hallgato getHallgatoById(int id) throws HallgatoNemTalalhatoException {
                return null;
            }

            @Override
            public void updateHallgato(Hallgato hallgato) {

            }

            @Override
            public void deleteHallgato(Hallgato hallgato) throws HallgatoNemTalalhatoException {

            }

            @Override
            public List<Hallgato> getAllHallgato() {
                List<Hallgato> hallgatok = new ArrayList<>();
                Hallgato h1 = new Hallgato(1,"ABC123","Kiss Béla","kiss.bela@pelda.hu", LocalDate.of(2000, Month.AUGUST,12),Nem.FERFI);
                hallgatok.add(h1);
                return hallgatok;
            }
        });
    }
}
