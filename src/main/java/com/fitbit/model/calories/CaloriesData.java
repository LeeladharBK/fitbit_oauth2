
package com.fitbit.model.calories;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CaloriesData {

    @SerializedName("activities-calories")
    private List<ActivitiesCalory> mActivitiesCalories;

    public List<ActivitiesCalory> getActivitiesCalories() {
        return mActivitiesCalories;
    }

    public void setActivitiesCalories(List<ActivitiesCalory> activitiesCalories) {
        mActivitiesCalories = activitiesCalories;
    }

}
