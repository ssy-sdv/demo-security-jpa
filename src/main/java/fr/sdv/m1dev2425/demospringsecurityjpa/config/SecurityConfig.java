package fr.sdv.m1dev2425.demospringsecurityjpa.config;

import fr.sdv.m1dev2425.demospringsecurityjpa.bo.Role;
import fr.sdv.m1dev2425.demospringsecurityjpa.bo.User;
import fr.sdv.m1dev2425.demospringsecurityjpa.dal.RoleRepository;
import fr.sdv.m1dev2425.demospringsecurityjpa.dal.UserRepository;
import fr.sdv.m1dev2425.demospringsecurityjpa.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class SecurityConfig {

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        return args -> {
            Role userRole = new Role();
            userRole.setLabel("ROLE_USER");
            roleRepository.save(userRole);

            User user = new User();
            user.setName("Séga SYLLA");
            user.setLogin("ssy");
            user.setPassword(encoder.encode("SYLLA"));
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
        };
    }
}
