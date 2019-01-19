package challenge.models;

import java.time.LocalTime;
import java.util.List;

public class FreeTime {
    private LocalTime time;
    // private List<String> names;
    private String names2;


    public FreeTime(LocalTime time, String names2){
        this.time = time;
        this.names2 = names2;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getNames2() {
        return names2;
    }
}
