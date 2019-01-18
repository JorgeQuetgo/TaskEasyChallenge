package challenge.controllers;


import challenge.models.Colaborator;
import challenge.models.WorkingHours;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.util.Map;


@RestController
public class ColaboratorController {

    private List<Colaborator> colaborators = new ArrayList<Colaborator>();

    @GetMapping("/greeting")
    public Colaborator greeting() {
        List<Time> timeList = new ArrayList<Time>();
        timeList.add(java.sql.Time.valueOf("08:00:00"));
        Colaborator newC = new Colaborator("Juan", timeList);
        colaborators.add(newC);
        return (newC);
    }

    @GetMapping("/colaborators")
    public List<Colaborator> getAllColaborator(){
        //List<Time> timeList = new ArrayList<Time>();
        //timeList.add(java.sql.Time.valueOf("8:00:00"));
        //colaborators.add(new Colaborator("Pedro", timeList));
        //colaborators.add(new Colaborator("Miguel", timeList));
        return colaborators;
    }

    @PostMapping("/initialize")
    public void initialize(@RequestBody List<Colaborator> colaborators){
        this.colaborators = colaborators;
        System.out.println(this.colaborators);
    }
}

