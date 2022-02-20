package com.example.muzeum;

public class Statue {
    private int id;
    private String person;
    private int height;
    private int price;

    //region Getter / Setter
    public int getId() { return id; }

    public String getPerson() {
        return person;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //endregion

    public Statue(int id, String person, int height, int price) {
        this.id = id;
        this.person = person;
        this.height = height;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", height=" + height +
                ", price=" + price +
                '}';
    }
}
