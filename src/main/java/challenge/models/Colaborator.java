package challenge.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Colaborator {

    private String name;
    private List<Time> meetingSchedule;

    public Colaborator(String name, List<Time> meetingSchedule){
        this.name = name;
        this.meetingSchedule = meetingSchedule;
    }

    public String getName(){
        return this.name;
    }

    public List<Time> getMeetingSchedule(){
        return this.meetingSchedule;
    }
}
