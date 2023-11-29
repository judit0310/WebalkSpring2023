package hu.uni.miskolc.webalk.dao.exceptions;

public class HallgatoMarLetezik extends Exception {
    public HallgatoMarLetezik(int id) {
        super(Integer.toString(id));
    }
}
