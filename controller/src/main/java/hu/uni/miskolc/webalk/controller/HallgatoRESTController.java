package hu.uni.miskolc.webalk.controller;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.HallgatoService;
import hu.uni.miskolc.webalk.Nem;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HallgatoRESTController {

    private final HallgatoService hallgatoService;


    public HallgatoRESTController(@Autowired HallgatoService hallgatoService) {
        this.hallgatoService = hallgatoService;
    }

    @GetMapping("hallgatok")
    public List<Hallgato> hallgatoes() {
        return hallgatoService.getHallgatok();
    }

    @GetMapping("hallgato/{id}")
    public Hallgato getHallgatoById(@PathVariable int id) throws HallgatoNemTalalhatoException {
        return hallgatoService.getHallgatoById(id);
    }

    @GetMapping("hallgatoNem/{nem}")
    public List<Hallgato> getHallgatoNemSzerint(@PathVariable Nem nem) {
        return hallgatoService.getHallgatokByNem(nem);
    }

   /* @GetMapping("hallgatok/evek")
    public List<Hallgato> getHallgatokSzuletesiEvKozott(@RequestParam(required = true) int fromYear, @RequestParam Optional<Integer> toYear){
        if (toYear.isPresent()) {
            if (fromYear > toYear.get()){
                throw new InvalidParameterException("A kezdő év nem lehet a végév után");
            }
            return hallgatoService.getHallgatokEvekKozott(fromYear,toYear.get());
        }
        return hallgatoService.getHallgatokEvekKozott(fromYear, LocalDate.now().getYear());
    }*/

    @GetMapping("hallgatok/evek")
    public List<Hallgato> getHallgatokSzuletesiEvKozott(@RequestParam(required = true) int fromYear, @RequestParam(defaultValue = "3000" ) Integer toYear) {
        if (fromYear > toYear) {
            throw new InvalidParameterException("A kezdő év nem lehet a végév után");
        }
        return hallgatoService.getHallgatokEvekKozott(fromYear, toYear);

    }
    @GetMapping("hallgatok/{fromYear}-{toYear}")
    public List<Hallgato> getHallgatokSzuletesiEvKozottPath(@PathVariable int fromYear, @PathVariable int toYear){
        if (fromYear > toYear) {
            throw new InvalidParameterException("A kezdő év nem lehet a végév után");
        }
        return hallgatoService.getHallgatokEvekKozott(fromYear,toYear);
    }

    @GetMapping("hallgatoNeptunKod/{nk:[A-Z0-9]{6}}")
    public List<Hallgato> getHallgatokByNeptunKod(@PathVariable("nk") String neptunKod){
        return hallgatoService.getHallgatokByNeptunKod(neptunKod);

    }

    @PostMapping(value = {"addHallgato",""}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addHallgato(@Valid @RequestBody HallgatoDTO hallgato, BindingResult bindingResult) throws HallgatoMarLetezik {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().stream().map(e -> e.getField() +": "+e.getDefaultMessage()).collect(Collectors.toList()).toString();
        }
        hallgatoService.addHallgato(HallgatoDTO.convertHallgatoDTOToHallgato(hallgato));
        return "Uj hallgato hozzáadva";
    }
@ExceptionHandler(HallgatoMarLetezik.class)
@ResponseStatus(value = HttpStatus.CONFLICT)
    public String hallgatoMarLetezik(HallgatoMarLetezik e){
        return "Ezzel az azonosítóval már létezik hallgató: "+e.getMessage();
    }



}
