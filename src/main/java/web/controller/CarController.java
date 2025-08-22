package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller

public class CarController {

    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }


    @GetMapping("/cars")
    public String show(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, Model model) {
        if (count >= 5) {
            model.addAttribute("cars", carServiceImpl.index());
            return "cars";
        } else {
            model.addAttribute("cars", carServiceImpl.show(count));
            return "show";
        }
    }

}
