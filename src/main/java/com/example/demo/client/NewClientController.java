package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Documentation on hibernate syntax: https://www.decodejava.com/hibernate-query-language-inserting-record.htm#:~:text=To%20do%20this%2C%20Hibernate%20doesn%27t%20provide%20a%20direct,into%20another%20database%20table%20%28representing%20another%20Entity%20class%29.
// Where the front end will be wired to, in this case the React app auto pops on 3000.
@CrossOrigin(origins = "*")
// This is where the actual endpoint for the REST api! It is making calls to the
// DB to preform its (crud) tasks!
@RestController // This is the closest layer to the DB. The SERVICE or "business layer" works
                // THROUGH this layer to access DB
@RequestMapping(path = "api/v1/clients")
public class NewClientController {
    private final NewClientService newClientService;
    private final MailService newEmailService;

    @Autowired
    public NewClientController(NewClientService newClientService, MailService newEmailService) {
        this.newClientService = newClientService;
        this.newEmailService = newEmailService;
    }

    // GET ALL patients (works well)
    @GetMapping
    public List<Client> getClients() {
        return newClientService.getClients();
    }

    // GET CLIENT by PHONE identifier (works well)
    @GetMapping(path = "{phone}")
    public ResponseEntity<Client> findClientByPhone(@PathVariable("phone") String phone) {

        return newClientService.findClientByPhone(phone);

    }

    @GetMapping(path = "{email}")
    public ResponseEntity<Client> findClientByEmail(@PathVariable("email") String email) {
        return newClientService.findClientByEmail(email);
    }

    // CREATE (post) New Client (works well by sending email to client with their
    // quote)
    @PostMapping
    public void registerNewClient(@RequestBody Client client) {
        newClientService.addNewClient(client);
        // newEmailService.sendMessage(client);
    }

}
