package challenge.controllers;


import challenge.models.Colaborator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

@RestController
public class ColaboratorController {

    private List<Colaborator> colaborator = new ArrayList<Colaborator>();

    @GetMapping("/greeting")
    public Colaborator greeting() {
        List<Time> timeList = new ArrayList<Time>();
        timeList.add(java.sql.Time.valueOf("08:00:00"));
        Colaborator newC = new Colaborator("Juan", timeList);
        colaborator.add(newC);
        return (newC);
    }

    @GetMapping("/colaborators")
    public List<Colaborator> getAllColaborator(){
        List<Time> timeList = new ArrayList<Time>();
        timeList.add(java.sql.Time.valueOf("8:00:00"));
        colaborator.add(new Colaborator("Pedro", timeList));
        colaborator.add(new Colaborator("Miguel", timeList));
        return colaborator;
    }
}
