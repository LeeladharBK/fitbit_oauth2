
package com.fitbit.model.floors;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FloorsData {

    @SerializedName("activities-floors")
    private List<ActivitiesFloor> mActivitiesFloors;

    public List<ActivitiesFloor> getActivitiesFloors() {
        return mActivitiesFloors;
    }

    public void setActivitiesFloors(List<ActivitiesFloor> activitiesFloors) {
        mActivitiesFloors = activitiesFloors;
    }

}
