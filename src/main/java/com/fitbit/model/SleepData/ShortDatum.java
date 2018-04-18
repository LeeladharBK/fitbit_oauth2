
package com.fitbit.model.SleepData;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ShortDatum {

    private String mDateTime;
    private String mLevel;
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
