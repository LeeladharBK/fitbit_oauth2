
package com.fitbit.model.heart;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HeartRateZone {

    @SerializedName("caloriesOut")
    private Double CaloriesOut;
    @SerializedName("max")
    private Long Max;
    @SerializedName("min")
    private Long Min;
    @SerializedName("minutes")
    private Long Minutes;
    @SerializedName("name")
    private String Name;

    public Double getCaloriesOut() {
        return CaloriesOut;
    }

    public void setCaloriesOut(Double caloriesOut) {
        CaloriesOut = caloriesOut;
    }

    public Long getMax() {
        return Max;
    }

    public void setMax(Long max) {
        Max = max;
    }

    public Long getMin() {
        return Min;
    }

    public void setMin(Long min) {
        Min = min;
    }

    public Long getMinutes() {
        return Minutes;
    }

    public void setMinutes(Long minutes) {
        Minutes = minutes;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
