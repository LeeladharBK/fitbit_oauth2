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
import com.fitbit.model.SleepData.SleepData;
import com.fitbit.model.goals.Goals;
import com.fitbit.model.goals.MyGoals;
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

import java.security.Principal;

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
        try {
            Activity a = fitbitOAuthRestTemplate.getForObject(fitbitLifetimeStatsUri, Activity.class);
            lifetimeActivity = a.getLifetime().getTotal();
        } catch (Exception e) {
            lifetimeActivity = new LifetimeActivity();
        }
        return lifetimeActivity;
    }

    @RequestMapping("/goals")
    public @ResponseBody Goals goalsActivity(@RequestParam(value = "goal_type") String goalType) {
        System.out.println("In here goals: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(fitbitGoalsUri + goalType, MyGoals.class).getGoals();

    }

    @RequestMapping("/daily-activity")
    public @ResponseBody Object dailyActivity(@RequestParam(value = "date") String date) {
        System.out.println("In here object: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri + date, Object.class);
    }

    @RequestMapping("/sleep-data")
    public @ResponseBody Object sleepDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here sleep data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(sleepDateRangeUri + dateRange, SleepData.class).getSleep().get(1).getLevels().getSummary();
    }

    @RequestMapping("/heart-rate")
    public @ResponseBody Object heartRateDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(heartRateDateRangeUri + dateRange, Object.class);
    }

    @RequestMapping("/steps-data")
    public @ResponseBody Object stepsDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(stepsDateRangeUri + dateRange, Object.class);
    }

    @RequestMapping("/calories-data")
    public @ResponseBody Object caloriesDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(caloriesDateRangeUri + dateRange, Object.class);
    }

    @RequestMapping("/distance-data")
    public @ResponseBody Object distanceDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(distanceDateRangeUri + dateRange, Object.class);
    }

    @RequestMapping("/floors-data")
    public @ResponseBody Object floorsDateRange(@RequestParam(value = "date_range") String dateRange) {
        System.out.println("In here Heart Rate data: " + fitbitOAuthRestTemplate.getAccessToken());
        return fitbitOAuthRestTemplate.getForObject(floorsDateRangeUri + dateRange, Object.class);
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
