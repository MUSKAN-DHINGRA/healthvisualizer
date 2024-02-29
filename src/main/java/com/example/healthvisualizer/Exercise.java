package com.example.healthvisualizer;

import javafx.beans.property.*;

public class Exercise {
    private final StringProperty name;
    private final IntegerProperty duration;

    public Exercise(String name, int duration) {
        this.name = new SimpleStringProperty(name);
        this.duration = new SimpleIntegerProperty(duration);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getDuration() {
        return duration.get();
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public IntegerProperty durationProperty() {
        return duration;
    }
}