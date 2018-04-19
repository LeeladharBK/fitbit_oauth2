
package com.fitbit.model.distance;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DistanceData {

    @SerializedName("activities-distance")
    private List<ActivitiesDistance> mActivitiesDistance;

    public List<ActivitiesDistance> getActivitiesDistance() {
        return mActivitiesDistance;
    }

    public void setActivitiesDistance(List<ActivitiesDistance> activitiesDistance) {
        mActivitiesDistance = activitiesDistance;
    }

}
