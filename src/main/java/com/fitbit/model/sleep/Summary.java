
package com.fitbit.model.sleep;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Summary {

    @SerializedName("deep")
    private Deep mDeep;
    @SerializedName("light")
    private Light mLight;
    @SerializedName("rem")
    private Rem mRem;
    @SerializedName("wake")
    private Wake mWake;

    public Deep getDeep() {
        return mDeep;
    }

    public void setDeep(Deep deep) {
        mDeep = deep;
    }

    public Light getLight() {
        return mLight;
    }

    public void setLight(Light light) {
        mLight = light;
    }

    public Rem getRem() {
        return mRem;
    }

    public void setRem(Rem rem) {
        mRem = rem;
    }

    public Wake getWake() {
        return mWake;
    }

    public void setWake(Wake wake) {
        mWake = wake;
    }

}
