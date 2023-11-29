package hu.uni.miskolc.webalk.dao.exceptions;

public class HallgatoNemTalalhatoException extends Throwable {
    public HallgatoNemTalalhatoException(int id) {
        super(Integer.toString(id));
    }
}
