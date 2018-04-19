
package com.fitbit.model.activities;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HeartRateZone {

    @SerializedName("caloriesOut")
    private Double mCaloriesOut;
    @SerializedName("max")
    private Long mMax;
    @SerializedName("min")
    private Long mMin;
    @SerializedName("minutes")
    private Long mMinutes;
    @SerializedName("name")
    private String mName;

    public Double getCaloriesOut() {
        return mCaloriesOut;
    }

    public void setCaloriesOut(Double caloriesOut) {
        mCaloriesOut = caloriesOut;
    }

    public Long getMax() {
        return mMax;
    }

    public void setMax(Long max) {
        mMax = max;
    }

    public Long getMin() {
        return mMin;
    }

    public void setMin(Long min) {
        mMin = min;
    }

    public Long getMinutes() {
        return mMinutes;
    }

    public void setMinutes(Long minutes) {
        mMinutes = minutes;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
