
package com.fitbit.model.lifetime;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LifetimeActivities {

    @SerializedName("best")
    private Best mBest;
    @SerializedName("lifetime")
    private Lifetime mLifetime;

    public Best getBest() {
        return mBest;
    }

    public void setBest(Best best) {
        mBest = best;
    }

    public Lifetime getLifetime() {
        return mLifetime;
    }

    public void setLifetime(Lifetime lifetime) {
        mLifetime = lifetime;
    }

}
