package uk.gov.ons.oauthclientui.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableOAuth2Sso
public class CASecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(
                new CAFilter(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/",
                        "/login**",
                        "/webjars/**",
                        "/error**",
                        "/images/**",
                        "/css/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/");

    }

}

