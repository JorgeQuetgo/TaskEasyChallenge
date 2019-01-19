package challenge.models;

import java.sql.Time;
import java.time.LocalTime;


public class WorkingHours {
    private LocalTime entryTime;
    private LocalTime departureTime;
    private LocalTime lunchEntryTime;
    private LocalTime lunchDepartureTime;

    public WorkingHours(LocalTime et, LocalTime dt, LocalTime let, LocalTime ldt){
        this.entryTime = et;
        this.departureTime = dt;
        this.lunchEntryTime = let;
        this.lunchDepartureTime = ldt;
    }

    public LocalTime getEntryTime(){
        return this.entryTime;
    }

    public LocalTime getDepartureTime(){
        return this.departureTime;
    }

    public LocalTime getLunchEntryTime(){
        return this.lunchEntryTime;
    }

    public LocalTime getLunchDepartureTime(){
        return this.lunchDepartureTime;
    }

}
