package com.example.demo.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// This is the middle layer containing the BUSINESS LOGIC as it applies to client c.r.u.d
// It just does so through the interface that is "NewClientRepository"
@Service
public class NewClientService {
    @Autowired  // Critical Keyword! pulls everything together
    private final NewClientRepository newClientRepository;
    //Constructor
    public NewClientService(NewClientRepository newClientRepository) {
        this.newClientRepository = newClientRepository;
    }
    // Get ALL clients in the current DB
    public List<Client> getClients() {
        return newClientRepository.findAll();
    }
    // GET client by PHONE number (works but formatting has to match string which could cause bugs if people disregarded
    public ResponseEntity<Client> findClientByPhone(String phone) {
        Client client = newClientRepository.findClientByPhone(phone)
                .orElseThrow(() -> new IllegalStateException("Client did not sign up!?"));
        return ResponseEntity.ok(client);
    }
    // CREATE client (denies duplicates based on phone number)
    public void addNewClient(Client client) {
        Optional<Client> clientOptional = newClientRepository.findClientByPhone(client.getPhone());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("Client already signed up and in the process of being quoted!");
        }
        // Quote Roof Clean (account for the height of structure)
        else if(client.getToClean().contains("roof")){
            if(client.getStories()<=0||client.getStories()==null) {
                double temp = client.getSqFeet();
                temp = temp * .22;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
            if(client.getStories()<=3&&client.getStories()>=1) {
                double temp = client.getSqFeet();
                temp = temp * .27;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
            if(client.getStories()>=4) {
                double temp = client.getSqFeet();
                temp = temp * .35;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
        }
        // Quote House / Siding / Concrete&&Siding Clean
        else if(client.getToClean().contains("sidi")||client.getToClean().contains("con")||client.getToClean().contains("hous")){
            if(client.getStories()<=0||client.getStories()==null) {
                double temp = client.getSqFeet();
                temp = temp * .14;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
            if(client.getStories()<=3&&client.getStories()>=1) {
                double temp = client.getSqFeet();
                temp = temp * .17;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
            if(client.getStories()>=4) {
                double temp = client.getSqFeet();
                temp = temp * .19;
                client.setFreeQuote(temp);
                newClientRepository.save(client);
            }
        }
        // Quote Fencing / Driveways / Sidewalks Clean
        else if(client.getToClean().contains("fen")||client.getToClean().contains("driv")||client.getToClean().contains("sidew")){
            double temp = client.getSqFeet();
            temp = temp * .122;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote patios / decks Clean
        else if(client.getToClean().contains("pat")||client.getToClean().contains("deck")) {
            double temp = client.getSqFeet();
            temp = temp * .135;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote gutters clean / lights install
        else if(client.getToClean().contains("light")||client.getToClean().contains("gut")) {
            double temp = client.getSqFeet();
            temp = temp * .07;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote trucks, vehicles, cars, tractors, trailers, trains, wagons
        else if(client.getToClean().contains("truck")||client.getToClean().contains("vehic")||client.getToClean().contains("tractor")
        || client.getToClean().contains("trailer")||client.getToClean().contains("train")||client.getToClean().contains("wagon")) {
            double temp = client.getObjects();
            if(temp>=1) {
                temp = temp * 50.0;
            }
            else {
                temp = client.getSqFeet();
                temp = temp * .07;
            }
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote cold storage / freezer / cooler
        else if(client.getToClean().contains("cold")||client.getToClean().contains("storag")||client.getToClean().contains("freez")
                ||client.getToClean().contains("cool")){
            double temp = client.getSqFeet();
            temp = temp * .11;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote Stone Work /  Graffiti removal / Chimneys
        else if(client.getToClean().contains("chim")||client.getToClean().contains("graff")||client.getToClean().contains("stone") ) {
            double temp = client.getSqFeet();
            temp = temp * .27;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Everything not thought of (Something so they at least get SOME estimate back if they type in some random job or are too stupid to spell?)
        else {
            double temp = client.getSqFeet();
            temp = temp * .1;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
    }
}


