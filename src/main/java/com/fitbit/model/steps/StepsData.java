
package com.fitbit.model.steps;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class StepsData {

    @SerializedName("activities-steps")
    private List<ActivitiesStep> mActivitiesSteps;

    public List<ActivitiesStep> getActivitiesSteps() {
        return mActivitiesSteps;
    }

    public void setActivitiesSteps(List<ActivitiesStep> activitiesSteps) {
        mActivitiesSteps = activitiesSteps;
    }

}
