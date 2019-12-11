package com.kotlin.securyt.securitybasickotlin.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import lombok.SneakyThrows
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(val customUserDetailService: CustomUserDetailService) : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/*/protected/**").hasAnyRole("USER")
                .antMatchers("/*/admin/**").hasAnyRole("ADMIN")
                .and()
                .httpBasic().and().csrf().disable()
    }

    @SneakyThrows
    @Autowired
    public override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(customUserDetailService).passwordEncoder(BCryptPasswordEncoder())

    }

//    @SneakyThrows
//    @Autowired
//    fun configureGlobal(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//                .withUser("william").password("devdojo").roles("USER")
//                .and()
//                .withUser("admin").password("devdojo").roles("USER", "ADMIN")
//
//    }


}