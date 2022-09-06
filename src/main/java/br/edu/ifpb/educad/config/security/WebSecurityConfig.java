package br.edu.ifpb.educad.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private final Environment environment;
    private final TokenService tokenService;

    @Autowired
    public WebSecurityConfig(Environment environment, TokenService tokenService) {
        this.environment = environment;
        this.tokenService = tokenService;
    }

    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**"
    };

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        if (Arrays.asList(environment.getActiveProfiles()).contains("test")){
            security.headers().frameOptions().disable();
        }
        security
                .csrf().disable().authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTValidationFilter(authenticationManager(new AuthenticationConfiguration()), tokenService))
                .addFilter(new JWTAuthenticationFilter(authenticationManager(new AuthenticationConfiguration()), tokenService))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return security.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}
