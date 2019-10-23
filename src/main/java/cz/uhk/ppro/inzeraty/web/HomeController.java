package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UlozisteInzeratu uloziste;

    public HomeController(UlozisteInzeratu uloziste) {
        this.uloziste = uloziste;
    }


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("inzeraty", uloziste.getInzeraty());
        return "home";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam(required = false) Integer id, Model model){
        if(id!=null){
            //edit
            model.addAttribute("inzerat", uloziste.getById(id));

        }else {
            //new
            model.addAttribute("inzerat", new Inzerat());
        }
        return "editForm";
    }
     @PostMapping("/edit")
    public String editPost(
            @RequestParam(required = false) Integer id,
            @Valid Inzerat inzerat,
            BindingResult bindingResult
            ){
        if(bindingResult.hasErrors()){
            return "editForm";
        }

         if(id!=null){
             //edit
           uloziste.uprav(inzerat);
         }else {
             //new
             uloziste.pridej(inzerat);
         }

        return "redirect:/";

     }



}
