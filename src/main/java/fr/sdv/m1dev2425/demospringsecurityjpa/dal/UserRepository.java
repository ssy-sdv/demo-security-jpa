package fr.sdv.m1dev2425.demospringsecurityjpa.dal;

import fr.sdv.m1dev2425.demospringsecurityjpa.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
