
package com.fitbit.model.activities;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Goals {

    @SerializedName("activeMinutes")
    private Long mActiveMinutes;
    @SerializedName("caloriesOut")
    private Long mCaloriesOut;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName("floors")
    private Long mFloors;
    @SerializedName("steps")
    private Long mSteps;

    public Long getActiveMinutes() {
        return mActiveMinutes;
    }

    public void setActiveMinutes(Long activeMinutes) {
        mActiveMinutes = activeMinutes;
    }

    public Long getCaloriesOut() {
        return mCaloriesOut;
    }

    public void setCaloriesOut(Long caloriesOut) {
        mCaloriesOut = caloriesOut;
    }

    public Double getDistance() {
        return mDistance;
    }

    public void setDistance(Double distance) {
        mDistance = distance;
    }

    public Long getFloors() {
        return mFloors;
    }

    public void setFloors(Long floors) {
        mFloors = floors;
    }

    public Long getSteps() {
        return mSteps;
    }

    public void setSteps(Long steps) {
        mSteps = steps;
    }

}
