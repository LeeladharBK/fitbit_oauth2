
package com.fitbit.model.sleep;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SleepData {

    @SerializedName("sleep")
    private List<Sleep> mSleep;

    public List<Sleep> getSleep() {
        return mSleep;
    }

    public void setSleep(List<Sleep> sleep) {
        mSleep = sleep;
    }

}
