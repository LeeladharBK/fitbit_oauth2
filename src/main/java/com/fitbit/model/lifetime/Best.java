
package com.fitbit.model.lifetime;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Best {

    @SerializedName("total")
    private Total mTotal;
    @SerializedName("tracker")
    private Tracker mTracker;

    public Total getTotal() {
        return mTotal;
    }

    public void setTotal(Total total) {
        mTotal = total;
    }

    public Tracker getTracker() {
        return mTracker;
    }

    public void setTracker(Tracker tracker) {
        mTracker = tracker;
    }

}
