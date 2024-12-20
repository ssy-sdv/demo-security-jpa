package fr.sdv.m1dev2425.demospringsecurityjpa.dal;

import fr.sdv.m1dev2425.demospringsecurityjpa.bo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
