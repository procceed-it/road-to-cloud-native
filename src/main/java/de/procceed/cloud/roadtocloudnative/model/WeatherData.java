package de.procceed.cloud.roadtocloudnative.model;

public class WeatherData {
    private double degree;
    private String state;

    public WeatherData(double degree, String state) {
        this.degree = degree;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}
