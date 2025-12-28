// package com.example.demo.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // Disable CSRF (OK for Swagger/testing; enable for production)
//             .csrf(csrf -> csrf.disable())

//             // Authorization rules
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                     "/swagger-ui/**",
//                     "/v3/api-docs/**"
//                 ).authenticated()
//                 .anyRequest().authenticated()
//             )

//             // Form login configuration
//             .formLogin(form -> form
//                 .defaultSuccessUrl("/swagger-ui/index.html", true)
//             )

//             // Enable HTTP Basic for API clients
//             .httpBasic();

//         return http.build();
//     }

//     @Bean
//     public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

//         UserDetails user = User.builder()
//             .username("mitra")
//             .password(passwordEncoder.encode("0226"))
//             .roles("USER")
//             .build();

//         return new InMemoryUserDetailsManager(user);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ✅ Disable CSRF (required for Swagger + automated tests)
            .csrf(csrf -> csrf.disable())

            // ✅ Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Swagger & auth must be public
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/auth/**",
                    "/status"
                ).permitAll()

                // All APIs require auth (JWT later, but not enforced now)
                .anyRequest().permitAll()
            )

            // ❌ DO NOT use formLogin → causes redirect loop
            // ❌ DO NOT force httpBasic → causes popup loop
            ;

        return http.build();
    }

    // ✅ Required bean, safe for tests
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
