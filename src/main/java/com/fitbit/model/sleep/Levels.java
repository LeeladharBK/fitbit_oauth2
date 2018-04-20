
package com.fitbit.model.sleep;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Levels {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("shortData")
    private List<ShortDatum> mShortData;
    @SerializedName("summary")
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
