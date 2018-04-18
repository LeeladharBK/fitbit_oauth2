
package com.fitbit.model.SleepData;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Light {

    private Long mCount;
    private Long mMinutes;
    private Long mThirtyDayAvgMinutes;

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

    public Long getThirtyDayAvgMinutes() {
        return mThirtyDayAvgMinutes;
    }

    public void setThirtyDayAvgMinutes(Long thirtyDayAvgMinutes) {
        mThirtyDayAvgMinutes = thirtyDayAvgMinutes;
    }

}
