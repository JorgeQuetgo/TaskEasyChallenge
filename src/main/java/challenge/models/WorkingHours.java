package challenge.models;

import java.sql.Time;

public class WorkingHours {
    private Time entryTime;
    private Time departureTime;
    private Time lunchEntryTime;
    private Time lunchDepartureTime;

    public WorkingHours(Time et, Time dt, Time let, Time ldt){
        this.entryTime = et;
        this.departureTime = dt;
        this.lunchEntryTime = let;
        this.lunchDepartureTime = ldt;
    }

    public Time getEntryTime(){
        return this.entryTime;
    }

    public Time getDepartureTime(){
        return this.departureTime;
    }

    public Time getLunchEntryTime(){
        return this.lunchEntryTime;
    }

    public Time getLunchDepartureTime(){
        return this.lunchDepartureTime;
    }

}
