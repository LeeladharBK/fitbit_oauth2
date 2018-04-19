
package com.fitbit.model.sleep;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Awake {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("minutes")
    private Long mMinutes;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Long getMinutes() {
        return mMinutes;
    }

    public void setMinutes(Long minutes) {
        mMinutes = minutes;
    }

}
