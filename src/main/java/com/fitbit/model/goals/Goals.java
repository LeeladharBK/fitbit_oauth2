package com.fitbit.model.goals;

public class Goals {
    private String distance;

    private String floors;

    private String steps;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "ClassPojo [distance = " + distance + ", floors = " + floors + ", steps = " + steps + "]";
    }
}
