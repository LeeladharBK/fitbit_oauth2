
package com.fitbit.model.heart;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HeartData {

    @SerializedName("activities-heart")
    private List<com.fitbit.model.heart.ActivitiesHeart> ActivitiesHeart;

    public List<com.fitbit.model.heart.ActivitiesHeart> getActivitiesHeart() {
        return ActivitiesHeart;
    }

    public void setActivitiesHeart(List<com.fitbit.model.heart.ActivitiesHeart> activitiesHeart) {
        ActivitiesHeart = activitiesHeart;
    }

}
