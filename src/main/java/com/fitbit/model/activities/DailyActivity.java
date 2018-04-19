
package com.fitbit.model.activities;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DailyActivity {

    @SerializedName("activities")
    private List<Object> mActivities;
    @SerializedName("goals")
    private Goals mGoals;
    @SerializedName("summary")
    private Summary mSummary;

    public List<Object> getActivities() {
        return mActivities;
    }

    public void setActivities(List<Object> activities) {
        mActivities = activities;
    }

    public Goals getGoals() {
        return mGoals;
    }

    public void setGoals(Goals goals) {
        mGoals = goals;
    }

    public Summary getSummary() {
        return mSummary;
    }

    public void setSummary(Summary summary) {
        mSummary = summary;
    }

}
