package ch.unisg.airqueue.analysis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String root() {
        return "<html>Say hello to my little friend</html>";
    }
}
