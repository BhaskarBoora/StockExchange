package model;


public class Time {

    private final int hour;
    private final int minutes;

    public int getTimeId(){
        return hour*60 + minutes;
    }
    public Time(int hour, int  minutes)
    {
        this.hour = hour;
        this.minutes = minutes;
    }
}
