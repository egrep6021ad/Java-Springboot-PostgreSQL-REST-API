package com.example.demo.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface NewClientRepository extends JpaRepository<Client, Long> {
    // Postgres Queries
    Optional<Client> findClientByEmail(String email);
    Optional<Client> findClientByPhone(String phone);

}
