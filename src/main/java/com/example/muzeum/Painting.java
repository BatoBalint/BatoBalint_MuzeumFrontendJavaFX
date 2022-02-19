package com.example.muzeum;

public class Painting {

    private int id;
    private String name;
    private int year;
    private boolean onDisplay;
    private String onDisplayString;

    //region Getter / Setter
    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isOnDisplay() {
        return onDisplay;
    }

    public String getOnDisplayString() {
        return onDisplayString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOnDisplay(boolean onDisplay) {
        this.onDisplay = onDisplay;
        if (this.onDisplay) this.onDisplayString = "Igen";
        else this.onDisplayString = "Nem";
    }
    //endregion

    public Painting(int id, String name, int year, boolean onDisplay) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.onDisplay = onDisplay;
        if (this.onDisplay) this.onDisplayString = "Igen";
        else this.onDisplayString = "Nem";
    }

    @Override
    public String toString() {
        return "Painting{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", onDisplay=" + onDisplay +
                ", onDisplayString='" + onDisplayString + '\'' +
                '}';
    }
}
