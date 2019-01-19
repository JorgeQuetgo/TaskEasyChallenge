package challenge.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.time.LocalTime;

public class Colaborator {

    private String name;
    private List<LocalTime> meetingSchedule;
    private List<LocalTime> freeSchedule;

    public Colaborator(String name, List<LocalTime> meetingSchedule){
        this.name = name;
        this.meetingSchedule = meetingSchedule;
    }

    public String getName(){
        return this.name;
    }

    public List<LocalTime> getMeetingSchedule(){
        return this.meetingSchedule;
    }

    // insert in the field free Schedule all available schedules of the collaborator
    public void setFreeSchedule(WorkingHours wkh, Integer meetingTime){
        List<LocalTime> list = new ArrayList<>();
        LocalTime freeTime = wkh.getEntryTime();
        while(freeTime.isBefore(wkh.getDepartureTime())){
            if ((freeTime.isBefore(wkh.getLunchEntryTime()) || freeTime.isAfter(wkh.getLunchDepartureTime()) ||
                    freeTime.equals(wkh.getLunchDepartureTime()))){
                if (!this.getMeetingSchedule().contains(freeTime)){
                    list.add(freeTime);
                }
            }
            freeTime = freeTime.plusMinutes(meetingTime);
        }
        this.freeSchedule = list;
    }

    public List<LocalTime> getFreeSchedule(){
        return this.freeSchedule;
    }
}
