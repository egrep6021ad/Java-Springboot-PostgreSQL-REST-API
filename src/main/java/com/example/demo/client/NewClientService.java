package com.example.demo.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//  BUSINESS LOGIC
@Service
public class NewClientService {
    @Autowired  // Critical Keyword! 
    private final NewClientRepository newClientRepository;
    //Constructor
    public NewClientService(NewClientRepository newClientRepository) {
        this.newClientRepository = newClientRepository;
    }
    
    // Get ALL clients
    public List<Client> getClients() {
        return newClientRepository.findAll();
    }
    // GET client by PHONE number (works but formatting has to match string which could cause bugs if people disregarded)
    public ResponseEntity<Client> findClientByPhone(String phone) {
        Client client = newClientRepository.findClientByPhone(phone)
                .orElseThrow(() -> new IllegalStateException("Client did not sign up!?"));
        return ResponseEntity.ok(client);
    }
    //  *  Get client by EMAIL *
    public ResponseEntity<Client> findClientByEmail(String email) {
        Client client = newClientRepository.findClientByEmail(email)
            .orElseThrow(() -> new IllegalStateException("Client does not exsist"));
        return ResponseEntity.ok(client); 
    }

    // CREATE client (denies duplicates based on EMAIL and simultaneously processes the quote)  
    public void addNewClient(Client client) {
        Optional<Client> clientOptional = newClientRepository.findClientByEmail(client.getEmail());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("Client already signed up and in the process of being quoted!");
        }
        // Quote Roof Clean (account for the height of structure)
        else if(client.getToClean().contains("roo")||client.getToClean().contains("Roo")){
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
        else if(client.getToClean().contains("sidi")||client.getToClean().contains("con")||client.getToClean().contains("hous")||
        client.getToClean().contains("Sidi")||client.getToClean().contains("Con")||client.getToClean().contains("Hous")){
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
        else if(client.getToClean().contains("fen")||client.getToClean().contains("driv")||client.getToClean().contains("sidew")||
        client.getToClean().contains("Fen")||client.getToClean().contains("Driv")||client.getToClean().contains("Sidew")){
            double temp = client.getSqFeet();
            temp = temp * .122;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote patios / decks Clean
        else if(client.getToClean().contains("pat")||client.getToClean().contains("deck")||
        client.getToClean().contains("Pat")||client.getToClean().contains("Deck")) {
            double temp = client.getSqFeet();
            temp = temp * .135;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote gutters clean / lights install
        else if(client.getToClean().contains("light")||client.getToClean().contains("gut")||
            client.getToClean().contains("Light")||client.getToClean().contains("Gut")) {
            double temp = client.getSqFeet();
            temp = temp * .07;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote trucks, vehicles, cars, tractors, trailers, trains, wagons
        else if(client.getToClean().contains("truck")||client.getToClean().contains("vehic")||client.getToClean().contains("tractor")
        || client.getToClean().contains("trailer")||client.getToClean().contains("train")||client.getToClean().contains("wagon")||
        client.getToClean().contains("Truck")||client.getToClean().contains("Vehic")||client.getToClean().contains("Tractor")
        || client.getToClean().contains("Trailer")||client.getToClean().contains("Train")||client.getToClean().contains("Wagon")) {
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
                ||client.getToClean().contains("cool")||client.getToClean().contains("Cold")||client.getToClean().contains("Storag")||client.getToClean().contains("Freez")
                ||client.getToClean().contains("Cool")){
            double temp = client.getSqFeet();
            temp = temp * .11;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote Stone Work /  Graffiti removal / Chimneys
        else if(client.getToClean().contains("chim")||client.getToClean().contains("graff")||client.getToClean().contains("ston")||
        client.getToClean().contains("Chim")||client.getToClean().contains("Graff")||client.getToClean().contains("Ston")  ) {
            double temp = client.getSqFeet();
            temp = temp * .27;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        //Quote Billboards and Signs
        else if(client.getToClean().contains("sign")||client.getToClean().contains("bil")||client.getToClean().contains("board")||
        client.getToClean().contains("Sign")||client.getToClean().contains("Bil")||client.getToClean().contains("Board")  ) {
            double temp = client.getObjects();
            if(temp>=1&&temp<=2) {
                temp = temp * 100.0;
            }
            else if(temp>=3) {
                temp = temp * 80.0;
            }
            else {
                temp = client.getSqFeet();
                temp = temp * .07;
            }
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        //Quote Drive - throughs
        else if(client.getToClean().contains("drivethrough")||client.getToClean().contains("thru")||client.getToClean().contains("throu")||
        client.getToClean().contains("Drivethrough")||client.getToClean().contains("Thru")||client.getToClean().contains("Throu")  ) {
            double temp = client.getObjects();
            if(temp>=1&&temp<=2) {
                temp = temp * 420.0;
            }
            else if(temp>=3) {
                temp = temp * 350.0;
            }
            else {
                temp = client.getSqFeet();
                temp = temp * .07;
            }
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Quote Disposal & Sanitation 
        else if(client.getToClean().contains("dispos")||
        (client.getToClean().contains("sanit")&&
            (!client.getToClean().contains("cold")||!client.getToClean().contains("freeze")|| !client.getToClean().contains("Cold")|| 
            !client.getToClean().contains("Freez")))
        ||client.getToClean().contains("Dispos")||
        (client.getToClean().contains("Sanit")&&
            (!client.getToClean().contains("cold")||!client.getToClean().contains("freeze")|| !client.getToClean().contains("Cold")|| 
            !client.getToClean().contains("Freez")))) {
            double temp = client.getObjects();
            if(temp>=1&&temp<=2) {
                temp = temp * 420.0;
            }
            else if(temp>=3) {
                temp = temp * 350.0;
            }
            else {
                temp = client.getSqFeet();
                temp = temp * .07;
            }
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
        // Everything not thought of (Something so they at least get SOME estimate back if they type in some random job or are too stupid to spell?)
        else {
            double temp = client.getSqFeet();
            temp = temp * .22;
            client.setFreeQuote(temp);
            newClientRepository.save(client);
        }
    }
}


