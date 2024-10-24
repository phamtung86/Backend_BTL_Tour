package org.example.Reponsitory;

import org.example.Modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<Users, Integer> {

}
