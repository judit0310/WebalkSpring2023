package hu.uni.miskolc.webalk.controller;

import hu.uni.miskolc.webalk.Hallgato;
import hu.uni.miskolc.webalk.HallgatoService;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoMarLetezik;
import hu.uni.miskolc.webalk.dao.exceptions.HallgatoNemTalalhatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class HallgatoController {

    private final HallgatoService hallgatoService;

    @ModelAttribute("hallgato")
    public HallgatoDTO hallgato(){
        return new HallgatoDTO();
        //h.setSzuletesiDatum(LocalDate.now().minusDays(1));
        //h.setEmail("cica");
    }

    public HallgatoController(@Autowired HallgatoService hallgatoService) {
        this.hallgatoService = hallgatoService;
    }

    @GetMapping("hello")
    public String hello(){
        System.out.println(hallgatoService.getHallgatok());
        return "hello";
    }

    @GetMapping("/hallgatok")
    public ModelAndView hallgatok(){
        ModelAndView mav = new ModelAndView("hallgatok");
        //mav.addObject("hallgatok", new ArrayList<>());
        mav.addObject("hallgatok", hallgatoService.getHallgatok());
        return mav;
    }

    @GetMapping("/hallgato/{id}")
    public ModelAndView hallgatoIdAlapjan(@PathVariable int id) throws HallgatoNemTalalhatoException {
        ModelAndView mav = new ModelAndView("hallgatoreszletek");
        mav.addObject("hallgato", hallgatoService.getHallgatoById(id));
        return mav;
    }

    @GetMapping("/ujhallgato")
    public ModelAndView addHallgato(){
            return new ModelAndView("hallgatoForm");
    }

    @PostMapping("/ujhallgato")
    public ModelAndView addHallgato(@Valid @ModelAttribute("hallgato") HallgatoDTO hallgato, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("hallgatoForm");
        }
        try {
            hallgatoService.addHallgato(HallgatoDTO.convertHallgatoDTOToHallgato(hallgato));
            return new ModelAndView("redirect:hallgatok");
        } catch (HallgatoMarLetezik e) {
            ModelAndView mav = new ModelAndView("hallgatoForm");
            mav.addObject("message","A(z)"+hallgato.getId()+" azonosító már foglalt");
            return mav;
        }
    }

}
