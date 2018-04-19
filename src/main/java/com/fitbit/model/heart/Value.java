
package com.fitbit.model.heart;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Value {

    @SerializedName("customHeartRateZones")
    private List<Object> CustomHeartRateZones;
    @SerializedName("heartRateZones")
    private List<HeartRateZone> HeartRateZones;
    @SerializedName("restingHeartRate")
    private Long RestingHeartRate;

    public List<Object> getCustomHeartRateZones() {
        return CustomHeartRateZones;
    }

    public void setCustomHeartRateZones(List<Object> customHeartRateZones) {
        CustomHeartRateZones = customHeartRateZones;
    }

    public List<HeartRateZone> getHeartRateZones() {
        return HeartRateZones;
    }

    public void setHeartRateZones(List<HeartRateZone> heartRateZones) {
        HeartRateZones = heartRateZones;
    }

    public Long getRestingHeartRate() {
        return RestingHeartRate;
    }

    public void setRestingHeartRate(Long restingHeartRate) {
        RestingHeartRate = restingHeartRate;
    }

}
