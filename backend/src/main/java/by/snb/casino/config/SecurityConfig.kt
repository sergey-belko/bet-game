package by.snb.casino.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableWebMvc
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .cors().disable()
//            .and()
            .authorizeRequests()
            .antMatchers("/**")
            .permitAll()
    }

//    open fun addCorsMappings(registry: CorsRegistry) {
//        registry
//            .addMapping("/**")
//            .allowedOriginPatterns("*")
//            .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
//    }
}
