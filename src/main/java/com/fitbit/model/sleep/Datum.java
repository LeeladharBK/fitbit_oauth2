
package com.fitbit.model.sleep;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Datum {

    @SerializedName("dateTime")
    private String mDateTime;
    @SerializedName("level")
    private String mLevel;
    @SerializedName("seconds")
    private Long mSeconds;

    public String getDateTime() {
        return mDateTime;
    }

    public void setDateTime(String dateTime) {
        mDateTime = dateTime;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String level) {
        mLevel = level;
    }

    public Long getSeconds() {
        return mSeconds;
    }

    public void setSeconds(Long seconds) {
        mSeconds = seconds;
    }

}
