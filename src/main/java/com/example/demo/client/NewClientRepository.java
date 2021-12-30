package com.example.demo.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/*This class is specifically for interacting with the DB (layer of protection for DB)  */
@Repository
public interface NewClientRepository extends JpaRepository<Client, Long> {
    // SELECT * FROM patient WHERE id = ?  (these "functions?" call the before mentioned commands inside the postgresQL D.B.)

    Optional<Client> findClientByPhone(String phone);
    // TO DO:
    //Optional<Patient> updatePatient(Long phone, String notes);

}
