
package com.fitbit.model.sleep;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Summary {

    @SerializedName("asleep")
    private Asleep mAsleep;
    @SerializedName("awake")
    private Awake mAwake;
    @SerializedName("restless")
    private Restless mRestless;

    public Asleep getAsleep() {
        return mAsleep;
    }

    public void setAsleep(Asleep asleep) {
        mAsleep = asleep;
    }

    public Awake getAwake() {
        return mAwake;
    }

    public void setAwake(Awake awake) {
        mAwake = awake;
    }

    public Restless getRestless() {
        return mRestless;
    }

    public void setRestless(Restless restless) {
        mRestless = restless;
    }

}
