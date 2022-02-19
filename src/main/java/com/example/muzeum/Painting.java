package com.example.muzeum;

public class Painting {

    private String name;
    private int year;
    private boolean onDisplay;

    //region Getter / Setter
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isOnDisplay() {
        return onDisplay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOnDisplay(boolean onDisplay) {
        this.onDisplay = onDisplay;
    }
    //endregion

    public Painting(String name, int year, boolean onDisplay) {
        this.name = name;
        this.year = year;
        this.onDisplay = onDisplay;
    }
}
