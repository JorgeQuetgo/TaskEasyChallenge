package challenge.controllers;


import challenge.models.Colaborator;
import challenge.models.WorkingHours;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.util.Map;


@RestController
public class ColaboratorController {

    private List<Colaborator> collaborators = new ArrayList<Colaborator>();
    private WorkingHours workingHours;
    private List<String> freeCollaborators = new ArrayList<>();
    private static final int MEETING_TIME = 30;

    @GetMapping("/greeting")
    public Colaborator greeting() {
        List<LocalTime> timeList = new ArrayList<>();
        timeList.add(LocalTime.parse("08:00:00"));
        Colaborator newC = new Colaborator("Juan", timeList);
        collaborators.add(newC);
        return (newC);
    }

    @GetMapping("/collaborators")
    public List<Colaborator> getAllColaborator(){
        return collaborators;
    }

    @PostMapping("/initialize_collaborators")
    public void initializeCollaboratros(@RequestBody List<Colaborator> collaborators){
        this.collaborators = collaborators;
    }


    @GetMapping("/working_hours")
    public WorkingHours getWorkingHours(){
        return workingHours;
    }

    @PostMapping("/initialize_working_hours")
    public void initializeWorkingHours(@RequestBody WorkingHours workingHours){
        this.workingHours = workingHours;
    }


    @PostMapping("/retrieve_free_collaborators")
    public List<String> retrieveFreeCollaborators(@RequestBody Map<String, LocalTime> time){
        freeCollaborators.clear();
        LocalTime testingTime = time.get("time");
        System.out.println(testingTime);
        for (int i = 0; i < collaborators.size(); i++) {
            System.out.println(collaborators.get(i).getName());
            collaborators.get(i).setFreeSchedule(workingHours, MEETING_TIME);
            System.out.println(collaborators.get(i).getFreeSchedule());
            if (collaborators.get(i).getFreeSchedule().contains(testingTime)){
                freeCollaborators.add(collaborators.get(i).getName());
            }
        }
        if (freeCollaborators.size() >= 3){
            return freeCollaborators;
        }else{
            List<String> listStrings = new ArrayList<String>();
            listStrings.add("less than three people are available");
            return listStrings;
        }
    }
}

