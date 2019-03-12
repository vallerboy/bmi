package pl.asd.bmi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/bmi")
    public String bmi(){
        return "bmi";
    }

    @PostMapping("/bmi")
    public String bmi(@RequestParam("weight") double weight,
                      @RequestParam("height") double height,
                      Model model){
        if(weight == 0 || height < 0.30){
            model.addAttribute("info", "Błędne dane");
            return "bmi";
        }

        double bmi = weight / Math.pow(height, 2);
        model.addAttribute("info", bmi < 18.5 ? 0 : (bmi > 18.5 && bmi <= 25 ? 1 : 2));
        model.addAttribute("bmi", bmi);
        return "bmiBox";
    }
}
