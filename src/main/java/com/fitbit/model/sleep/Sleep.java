
package com.fitbit.model.sleep;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Sleep {

    @SerializedName("dateOfSleep")
    private String mDateOfSleep;
    @SerializedName("duration")
    private Long mDuration;
    @SerializedName("efficiency")
    private Long mEfficiency;
    @SerializedName("endTime")
    private String mEndTime;
    @SerializedName("infoCode")
    private Long mInfoCode;
    @SerializedName("levels")
    private Levels mLevels;
    @SerializedName("logId")
    private Long mLogId;
    @SerializedName("minutesAfterWakeup")
    private Long mMinutesAfterWakeup;
    @SerializedName("minutesAsleep")
    private Long mMinutesAsleep;
    @SerializedName("minutesAwake")
    private Long mMinutesAwake;
    @SerializedName("minutesToFallAsleep")
    private Long mMinutesToFallAsleep;
    @SerializedName("startTime")
    private String mStartTime;
    @SerializedName("timeInBed")
    private Long mTimeInBed;
    @SerializedName("type")
    private String mType;

    public String getDateOfSleep() {
        return mDateOfSleep;
    }

    public void setDateOfSleep(String dateOfSleep) {
        mDateOfSleep = dateOfSleep;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Long getEfficiency() {
        return mEfficiency;
    }

    public void setEfficiency(Long efficiency) {
        mEfficiency = efficiency;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    public Long getInfoCode() {
        return mInfoCode;
    }

    public void setInfoCode(Long infoCode) {
        mInfoCode = infoCode;
    }

    public Levels getLevels() {
        return mLevels;
    }

    public void setLevels(Levels levels) {
        mLevels = levels;
    }

    public Long getLogId() {
        return mLogId;
    }

    public void setLogId(Long logId) {
        mLogId = logId;
    }

    public Long getMinutesAfterWakeup() {
        return mMinutesAfterWakeup;
    }

    public void setMinutesAfterWakeup(Long minutesAfterWakeup) {
        mMinutesAfterWakeup = minutesAfterWakeup;
    }

    public Long getMinutesAsleep() {
        return mMinutesAsleep;
    }

    public void setMinutesAsleep(Long minutesAsleep) {
        mMinutesAsleep = minutesAsleep;
    }

    public Long getMinutesAwake() {
        return mMinutesAwake;
    }

    public void setMinutesAwake(Long minutesAwake) {
        mMinutesAwake = minutesAwake;
    }

    public Long getMinutesToFallAsleep() {
        return mMinutesToFallAsleep;
    }

    public void setMinutesToFallAsleep(Long minutesToFallAsleep) {
        mMinutesToFallAsleep = minutesToFallAsleep;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public Long getTimeInBed() {
        return mTimeInBed;
    }

    public void setTimeInBed(Long timeInBed) {
        mTimeInBed = timeInBed;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
