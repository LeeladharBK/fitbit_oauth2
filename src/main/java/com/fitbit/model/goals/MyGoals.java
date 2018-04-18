package com.fitbit.model.goals;

public class MyGoals {
    private Goals goals;

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "ClassPojo [goals = " + goals + "]";
    }
}
