package org.example.Reponsitory;


import org.example.Modal.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportReponsitory extends JpaRepository<Transport, Integer> {

}
