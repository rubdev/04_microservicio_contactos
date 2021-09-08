package dev.ruben._microservicio_contactos;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Definimos roles y usuarios
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("usuario")
                    .password("{noop}usuario") // noop para indicar que no obligar a usar encriptación
                    .roles("USER")
                .and()
                .withUser("admin")
                    .password("{noop}admin")
                    .roles("USER", "ADMIN");



    }

    // Definimos políticas de seguridad


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // desactivamos filtros internos para no obligar a auntenticarnos mas de una vez en la utilización del servicio
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/contactos").hasRole("ADMIN")
                .antMatchers("/contactos").authenticated() // "/**" para indicar que cualquier dirección requiere usuarios autenticados
                .and()
                .httpBasic();
    }
}
