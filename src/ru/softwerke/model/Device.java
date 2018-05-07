package ru.softwerke.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Device {
    private long Id;
    private LocalDate releaseDate;
    private TypeOfDevice type;
    private Color color;
    private String manufactured;
    private BigDecimal price;
    private static long COUNTER = 1;

    public long getId() {
        return Id;
    }

    public void setId() {
        Id = COUNTER++;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public TypeOfDevice getType() {
        return type;
    }

    public void setType(TypeOfDevice type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
