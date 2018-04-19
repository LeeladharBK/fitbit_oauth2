
package com.fitbit.model.activities;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Summary {

    @SerializedName("activeScore")
    private Long mActiveScore;
    @SerializedName("activityCalories")
    private Long mActivityCalories;
    @SerializedName("caloriesBMR")
    private Long mCaloriesBMR;
    @SerializedName("caloriesOut")
    private Long mCaloriesOut;
    @SerializedName("distances")
    private List<Distance> mDistances;
    @SerializedName("elevation")
    private Double mElevation;
    @SerializedName("fairlyActiveMinutes")
    private Long mFairlyActiveMinutes;
    @SerializedName("floors")
    private Long mFloors;
    @SerializedName("heartRateZones")
    private List<HeartRateZone> mHeartRateZones;
    @SerializedName("lightlyActiveMinutes")
    private Long mLightlyActiveMinutes;
    @SerializedName("marginalCalories")
    private Long mMarginalCalories;
    @SerializedName("restingHeartRate")
    private Long mRestingHeartRate;
    @SerializedName("sedentaryMinutes")
    private Long mSedentaryMinutes;
    @SerializedName("steps")
    private Long mSteps;
    @SerializedName("veryActiveMinutes")
    private Long mVeryActiveMinutes;

    public Long getActiveScore() {
        return mActiveScore;
    }

    public void setActiveScore(Long activeScore) {
        mActiveScore = activeScore;
    }

    public Long getActivityCalories() {
        return mActivityCalories;
    }

    public void setActivityCalories(Long activityCalories) {
        mActivityCalories = activityCalories;
    }

    public Long getCaloriesBMR() {
        return mCaloriesBMR;
    }

    public void setCaloriesBMR(Long caloriesBMR) {
        mCaloriesBMR = caloriesBMR;
    }

    public Long getCaloriesOut() {
        return mCaloriesOut;
    }

    public void setCaloriesOut(Long caloriesOut) {
        mCaloriesOut = caloriesOut;
    }

    public List<Distance> getDistances() {
        return mDistances;
    }

    public void setDistances(List<Distance> distances) {
        mDistances = distances;
    }

    public Double getElevation() {
        return mElevation;
    }

    public void setElevation(Double elevation) {
        mElevation = elevation;
    }

    public Long getFairlyActiveMinutes() {
        return mFairlyActiveMinutes;
    }

    public void setFairlyActiveMinutes(Long fairlyActiveMinutes) {
        mFairlyActiveMinutes = fairlyActiveMinutes;
    }

    public Long getFloors() {
        return mFloors;
    }

    public void setFloors(Long floors) {
        mFloors = floors;
    }

    public List<HeartRateZone> getHeartRateZones() {
        return mHeartRateZones;
    }

    public void setHeartRateZones(List<HeartRateZone> heartRateZones) {
        mHeartRateZones = heartRateZones;
    }

    public Long getLightlyActiveMinutes() {
        return mLightlyActiveMinutes;
    }

    public void setLightlyActiveMinutes(Long lightlyActiveMinutes) {
        mLightlyActiveMinutes = lightlyActiveMinutes;
    }

    public Long getMarginalCalories() {
        return mMarginalCalories;
    }

    public void setMarginalCalories(Long marginalCalories) {
        mMarginalCalories = marginalCalories;
    }

    public Long getRestingHeartRate() {
        return mRestingHeartRate;
    }

    public void setRestingHeartRate(Long restingHeartRate) {
        mRestingHeartRate = restingHeartRate;
    }

    public Long getSedentaryMinutes() {
        return mSedentaryMinutes;
    }

    public void setSedentaryMinutes(Long sedentaryMinutes) {
        mSedentaryMinutes = sedentaryMinutes;
    }

    public Long getSteps() {
        return mSteps;
    }

    public void setSteps(Long steps) {
        mSteps = steps;
    }

    public Long getVeryActiveMinutes() {
        return mVeryActiveMinutes;
    }

    public void setVeryActiveMinutes(Long veryActiveMinutes) {
        mVeryActiveMinutes = veryActiveMinutes;
    }

}
