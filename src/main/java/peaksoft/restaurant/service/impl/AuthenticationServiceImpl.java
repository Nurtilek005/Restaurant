package peaksoft.restaurant.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.restaurant.entities.User;
import peaksoft.restaurant.enums.Role;
import peaksoft.restaurant.repository.UserRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImpl {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;




    @PostConstruct
    public void initSaveAdmin(){
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setPassword(passwordEncoder.encode("admin123"));
        user.setEmail("admin@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPhoneNumber("+996999999999");
        user.setDateOfBirth(LocalDate.of(2005,8,28));
        user.setExperience(5);
        if(!userRepository.existsByEmail(user.getEmail())){
            userRepository.save(user);
        }
    }
}
