
package com.fitbit.model.lifetime;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Total {

    @SerializedName("activeScore")
    private Long mActiveScore;
    @SerializedName("caloriesOut")
    private Long mCaloriesOut;
    @SerializedName("distance")
    private Distance mDistance;
    @SerializedName("floors")
    private Floors mFloors;
    @SerializedName("steps")
    private Steps mSteps;

    public Long getActiveScore() {
        return mActiveScore;
    }

    public void setActiveScore(Long activeScore) {
        mActiveScore = activeScore;
    }

    public Long getCaloriesOut() {
        return mCaloriesOut;
    }

    public void setCaloriesOut(Long caloriesOut) {
        mCaloriesOut = caloriesOut;
    }

    public Distance getDistance() {
        return mDistance;
    }

    public void setDistance(Distance distance) {
        mDistance = distance;
    }

    public Floors getFloors() {
        return mFloors;
    }

    public void setFloors(Floors floors) {
        mFloors = floors;
    }

    public Steps getSteps() {
        return mSteps;
    }

    public void setSteps(Steps steps) {
        mSteps = steps;
    }

}
