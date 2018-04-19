
package com.fitbit.model.heart;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ActivitiesHeart {

    @SerializedName("dateTime")
    private String DateTime;
    @SerializedName("value")
    private com.fitbit.model.heart.Value Value;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public com.fitbit.model.heart.Value getValue() {
        return Value;
    }

    public void setValue(com.fitbit.model.heart.Value value) {
        Value = value;
    }

}
