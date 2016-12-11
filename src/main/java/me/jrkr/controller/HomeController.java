package me.jrkr.controller;

import me.jrkr.model.HomeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;


@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeBean homeBean;

    @GetMapping("/")
    public String createHomeModel(Model model) {
        LOG.info("in hello creating model");
        homeBean.setName("John");
        model.addAttribute("model", homeBean);
        return "layout";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        homeBean.setName("Welcome - " + new Random().nextInt(100) + "   ::    Obj Id = " + homeBean);
        LOG.info("in hello creating welcome model");
        model.addAttribute("model", homeBean);
        return "layout";
    }

    @GetMapping("/bye")
    public String bye(Model model) {
        homeBean.setName("Bye - " + new Random().nextInt(100) + "   ::    Obj Id = " + homeBean);
        model.addAttribute("model", homeBean);
        return "layout";
    }

}
