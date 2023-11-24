package hu.uni.miskolc.webalk.controller;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.HallgatoService;
import hu.uni.miskolc.webalk.Nem;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HallgatoRESTController {

    private final HallgatoService hallgatoService;

    public HallgatoRESTController(@Autowired HallgatoService hallgatoService) {
        this.hallgatoService = hallgatoService;
    }

    @GetMapping("hallgatok")
    public List<Hallgato> hallgatok(){
        return hallgatoService.getHallgatok();
    }

    @GetMapping(value = "/hallgato/{id}")
    public Hallgato getrestEmployeeById(@PathVariable(value = "id")
                                        int id)
            throws HallgatoNemTalalhatoException {
        return hallgatoService.getHallgatoById(id);
    }

    @RequestMapping(value = "/addHallgato",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addHallgato(@Valid @RequestBody HallgatoDTO hallgato, BindingResult errors) throws HallgatoMarLetezik {
        if (errors.hasErrors()){
            return errors.getFieldErrors().stream().map(e -> e.getField() +": " +e.getDefaultMessage()).collect(Collectors.toList()).toString();

        }
        hallgatoService.addHallgato(HallgatoDTO.convertHallgatoDTOToHallgato(hallgato));
        return "Uj hallgato hozzaadva";
    }



    @ExceptionHandler(HallgatoMarLetezik.class)
    public String hallgatoMarLetezik(HallgatoMarLetezik e){
        return "Ezzel az azonosítóval már létezik hallgató: "+e.getMessage();
    }

    @GetMapping(value = "/hallgatok/{nem}")
    public List<Hallgato> getHallgatoNemSzerint(@PathVariable Nem nem){
        return hallgatoService.getHallgatoByNem(nem);
    }


    @ExceptionHandler(TypeMismatchException.class)
    public String getHallgatoNemSzerintHiba(TypeMismatchException e){
        return "Nem található ilyen nem, kérem használja az alábbi lehetőségeket: "+ Arrays.asList(Nem.values());
    }

}
