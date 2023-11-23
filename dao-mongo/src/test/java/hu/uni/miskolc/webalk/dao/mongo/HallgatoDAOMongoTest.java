package hu.uni.miskolc.webalk.dao.mongo;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.Nem;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class HallgatoDAOMongoTest {
    @Ignore
 @Test(expected = HallgatoMarLetezik.class)
    public void test() throws HallgatoMarLetezik {
     HallgatoDAOMongo dao = new HallgatoDAOMongo("mongodb+srv://test:test@szoftverteszteles2021.bqwgi.mongodb.net/test?retryWrites=true&w=majority","webalk_2023", "hallgatok");
     System.out.println(dao.getAllHallgato());
     dao.createHallgato(new Hallgato(1,"ABC123","Kiss Béla","kiss.bela@pelda.hu", LocalDate.of(2000, Month.AUGUST,12), Nem.FERFI)   );
     System.out.println(dao.getAllHallgato());
 }

}