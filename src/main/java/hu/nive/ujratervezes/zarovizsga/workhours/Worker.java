package hu.nive.ujratervezes.zarovizsga.workhours;

import java.util.Map;

public class Worker {
    private String name;
    private String date;
    private int workHours;

    public Worker(String name, int workHours, String date) {
        this.name = name;
        this.date = date;
        this.workHours = workHours;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getWorkHours() {
        return workHours;
    }

    @Override
    public String toString() {
        return  name + ": " + date;
    }
}
