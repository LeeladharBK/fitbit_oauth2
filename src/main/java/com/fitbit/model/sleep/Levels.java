
package com.fitbit.model.sleep;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Levels {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("summary")
    private Summary mSummary;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Summary getSummary() {
        return mSummary;
    }

    public void setSummary(Summary summary) {
        mSummary = summary;
    }

}
