
package com.fitbit.model.goals;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MyGoal {

    @SerializedName("goals")
    private Goals mGoals;

    public Goals getGoals() {
        return mGoals;
    }

    public void setGoals(Goals goals) {
        mGoals = goals;
    }

}
