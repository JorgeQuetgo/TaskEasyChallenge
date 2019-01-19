package challenge.controllers;


import challenge.models.Colaborator;
import challenge.models.FreeTime;
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
    private List<FreeTime> freeTime = new ArrayList<>();
    private static final int MEETING_TIME = 30;


    @GetMapping("/collaborators")
    public List<Colaborator> getAllColaborator(){
        return collaborators;
    }

    @PostMapping("/initialize_collaborators")
    public String initializeCollaboratros(@RequestBody List<Colaborator> collaborators){
        this.collaborators = collaborators;
        return "Collaborators added correctly";
    }


    @GetMapping("/working_hours")
    public WorkingHours getWorkingHours(){
        return workingHours;
    }

    @PostMapping("/initialize_working_hours")
    public String initializeWorkingHours(@RequestBody WorkingHours workingHours){
        this.workingHours = workingHours;
        return "working hours added correctly";
    }


    @PostMapping("/retrieve_free_collaborators")
    public List<String> retrieveFreeCollaborators(@RequestBody Map<String, LocalTime> time){
        freeCollaborators.clear();
        LocalTime testingTime = time.get("time");
        for (int i = 0; i < collaborators.size(); i++) {
            collaborators.get(i).setFreeSchedule(workingHours, MEETING_TIME);
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

    @GetMapping("/get_all_free_time")
    public List<FreeTime> AllFreeTime(){
        List<FreeTime> listTime = new ArrayList<>();
        LocalTime testingTime = workingHours.getEntryTime();
        Integer cont = 0;
        String names2 = "";
        while (testingTime.isBefore(workingHours.getDepartureTime())){
            freeCollaborators.clear();
            names2 = "";
            for (int i = 0; i < collaborators.size(); i++) {
                collaborators.get(i).setFreeSchedule(workingHours, MEETING_TIME);
                if (collaborators.get(i).getFreeSchedule().contains(testingTime)){
                    freeCollaborators.add(collaborators.get(i).getName());
                    names2 += collaborators.get(i).getName() + ", ";
                }
            }
            if (freeCollaborators.size() >= 3){
                listTime.add(new FreeTime(testingTime, names2));
                //listTime.add(new FreeTime(testingTime, freeCollaborators, names2));
                // listTime.get(cont).setNames(freeCollaborators);
                // System.out.println(listTime.get(cont).getNames());
                cont++;
            }
            testingTime = testingTime.plusMinutes(MEETING_TIME);
        }
        return listTime;
    }
}

