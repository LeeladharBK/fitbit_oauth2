
package com.fitbit.model.SleepData;

import java.util.List;
import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Levels {

    private List<Datum> mData;
    private List<ShortDatum> mShortData;
    private Summary mSummary;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public List<ShortDatum> getShortData() {
        return mShortData;
    }

    public void setShortData(List<ShortDatum> shortData) {
        mShortData = shortData;
    }

    public Summary getSummary() {
        return mSummary;
    }

    public void setSummary(Summary summary) {
        mSummary = summary;
    }

}
