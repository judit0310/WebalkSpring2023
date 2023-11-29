package hu.uni.miskolc.webalk.controller;

import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HallgatoNemTalalhatoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String hallgatoNemTalalhato(HallgatoNemTalalhatoException e){
        return "Az alábbi azonosítójú hallgató nem létezik a rendszerben: "+e.getMessage();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String methodNotAllowed(HttpRequestMethodNotSupportedException e){
        return "This method is not allowed "+e.getMethod()+", use one of these "+e.getSupportedHttpMethods();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String unsupported(HttpMediaTypeNotSupportedException e){
        return "Use one of the following media types: "+e.getSupportedMediaTypes();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView nemTalalhato(NoHandlerFoundException e, HttpServletRequest request){
        return new ModelAndView("hello");
    }

}
