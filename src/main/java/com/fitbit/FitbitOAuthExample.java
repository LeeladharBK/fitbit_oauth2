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
import com.fitbit.model.goals.Goal;
import com.fitbit.model.goals.Goals;
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

	@RequestMapping("/lifetime-activity")
	public LifetimeActivity lifetimeActivity() {
		LifetimeActivity lifetimeActivity;

		try {
			Activity a = fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri, Activity.class);
			lifetimeActivity = a.getLifetime().getTotal();
		}
		catch(Exception e) {
			lifetimeActivity = new LifetimeActivity();
		}

		return lifetimeActivity;
	}

	@RequestMapping("/lifetime-activity1")
	public Goal lifetimeActivity1() {

		System.out.println("In here: " + fitbitOAuthRestTemplate.getAccessToken());

//		fitbitOAuthRestTemplate.

	return  fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri, Goals.class).getGoal();

	}

	@RequestMapping("/lifetime-activity2")
	public Object lifetimeActivity2() {

		System.out.println("In here: " + fitbitOAuthRestTemplate.getAccessToken());

//		fitbitOAuthRestTemplate.

		return  fitbitOAuthRestTemplate.getForObject(fitbitActivitiesUri, Object.class);

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
