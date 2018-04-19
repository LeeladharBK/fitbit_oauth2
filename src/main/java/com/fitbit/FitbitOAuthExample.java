/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fitbit;

import com.fitbit.model.Activity;
import com.fitbit.model.LifetimeActivity;
import com.fitbit.model.activities.DailyActivity;
import com.fitbit.model.calories.CaloriesData;
import com.fitbit.model.distance.DistanceData;
import com.fitbit.model.floors.FloorsData;
import com.fitbit.model.goals.MyGoal;
import com.fitbit.model.heart.HeartData;
import com.fitbit.model.sleep.SleepData;
import com.fitbit.model.steps.ActivitiesStep;
import com.fitbit.model.steps.StepsData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
@EnableWebSecurity
public class FitbitOAuthExample extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2RestTemplate fitbitOAuthRestTemplate;

    @Value("${fitbit.api.resource.activitiesUri}")
    String fitbitActivitiesUri;

    @Value("${fitbit.api.resource.goalsUri}")
    String fitbitGoalsUri;

    @Value("${fitbit.api.resource.lifetimeStatsUri}")
    String fitbitLifetimeStatsUri;

    @Value("${fitbit.api.resource.sleepDateRangeUri}")
    String sleepDateRangeUri;

    @Value("${fitbit.api.resource.heartRateDateRangeUri}")
    String heartRateDateRangeUri;

    @Value("${fitbit.api.resource.stepsDateRangeUri}")
    String stepsDateRangeUri;

    @Value("${fitbit.api.resource.caloriesDateRangeUri}")
    String caloriesDateRangeUri;

    @Value("${fitbit.api.resource.distanceDateRangeUri}")
    String distanceDateRangeUri;

    @Value("${fitbit.api.resource.floorsDateRangeUri}")
    String floorsDateRangeUri;

    @RequestMapping("/lifetime-activity")
    public LifetimeActivity lifetimeActivity() {
        LifetimeActivity lifetimeActivity;
//        Gson gson = new Gson();
//        Total total;

        try {
            Activity a = fitbitOAuthRestTemplate.getForObject(fitbitLifetimeStatsUri, Activity.class);
            lifetimeActivity = a.getLifetime().getTotal();

//            String jsonString = fitbitOAuthRestTemplate.getForObject(fitbitLifetimeStatsUri, String.class);
//            System.out.println(jsonString);
//
//            LifetimeActivities lifetimeActivities = gson.fromJson(jsonString, LifetimeActivities.class);
//            total = lifetimeActivities.getLifetime().getTotal();

        } catch (Exception e) {
            lifetimeActivity = new LifetimeActivity();
//            total = new Total();
        }
        return lifetimeActivity;
    }

    @RequestMapping("/goals")
    public @ResponseBody
    Object goalsActivity(@RequestParam(value = "goal_type") String goalType) {
        System.out.println("In here goals: " + fitbitOAuthRestTemplate.getAccessToken());
        Gson gson = new Gson();

        String jsonString = fitbitOAuthRestTemplate.getForObject(fitbitGoalsUri + goalType, String.class);
        System.out.println(jsonString);

        MyGoal myGoal = gson.fromJson(jsonString, MyGoal.class);
        return myGoal;
    }

    @RequestMapping("/daily-activity")
    public @ResponseBody
    Object dailyActivity(@RequestParam(value = "date") String date) {
        System.out.println("In here Activity object: " + fitbitOAuthRestTemplate.getAccessToken());
        Gson gson = new Gson();

        String jsonString = fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri + date, String.class);
        System.out.println(jsonString);

        DailyActivity dailyActivity = gson.fromJson(jsonString, DailyActivity.class);
        return dailyActivity;
    }


    @RequestMapping("/sleep-data")
    public @ResponseBody
    Object sleepDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here sleep data: " + fitbitOAuthRestTemplate.getAccessToken());
        Gson gson = new Gson();

        String jsonString = fitbitOAuthRestTemplate.getForObject(sleepDateRangeUri + dateRange, String.class);
        System.out.println(jsonString);

        SleepData sleepData = gson.fromJson(jsonString, SleepData.class);
        return sleepData;
    }

    @RequestMapping("/heart-rate")
    public @ResponseBody
    Object heartRateDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());

        Gson gson = new Gson();
        String jsonString = fitbitOAuthRestTemplate.getForObject(heartRateDateRangeUri + dateRange, String.class);
        System.out.println(jsonString);

        // Deserialization
        Type collectionType = new TypeToken<HeartData>() {
        }.getType();
        HeartData heartData = gson.fromJson(jsonString, collectionType);

        return heartData;
    }

    @RequestMapping("/steps-data")
    public @ResponseBody
    Object stepsDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Steps data: " + fitbitOAuthRestTemplate.getAccessToken());

        Gson gson = new Gson();
        String jsonString = fitbitOAuthRestTemplate.getForObject(stepsDateRangeUri + dateRange, String.class);

        // Deserialization
//        System.out.println(jsonString);
//        Type collectionType = new TypeToken<StepsData>() {
//        }.getType();
        StepsData stepsData = gson.fromJson(jsonString, StepsData.class);
        List<ActivitiesStep> steps = stepsData.getActivitiesSteps();
        for (ActivitiesStep step : steps) {
            System.out.println(step.getDateTime() + " : " + step.getValue());
        }
        return stepsData;
    }

    @RequestMapping("/calories-data")
    public @ResponseBody
    Object caloriesDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Calories data: " + fitbitOAuthRestTemplate.getAccessToken());

        Gson gson = new Gson();
        String jsonString = fitbitOAuthRestTemplate.getForObject(caloriesDateRangeUri + dateRange, String.class);

        // Deserialization
        System.out.println(jsonString);

//        Type collectionType = new TypeToken<CaloriesData>() {
//        }.getType();
        CaloriesData caloriesData = gson.fromJson(jsonString, CaloriesData.class);

        return caloriesData;
    }

    @RequestMapping("/distance-data")

    public @ResponseBody
    Object distanceDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Distance data: " + fitbitOAuthRestTemplate.getAccessToken());
        Gson gson = new Gson();

        String jsonString = fitbitOAuthRestTemplate.getForObject(distanceDateRangeUri + dateRange, String.class);
        System.out.println(jsonString);

        DistanceData distanceData = gson.fromJson(jsonString, DistanceData.class);
        return distanceData;
    }

    @RequestMapping("/floors-data")
    public @ResponseBody
    Object floorsDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Floors data: " + fitbitOAuthRestTemplate.getAccessToken());
        Gson gson = new Gson();

        String jsonString = fitbitOAuthRestTemplate.getForObject(floorsDateRangeUri + dateRange, String.class);
        System.out.println(jsonString);

        FloorsData floorsData = gson.fromJson(jsonString, FloorsData.class);
        return floorsData;
    }


    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    public static void main(String[] args) {
        SpringApplication.run(FitbitOAuthExample.class, args);
    }

}
