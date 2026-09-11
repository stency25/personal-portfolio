package com.stency.personal_portfolio.controller;


import com.stency.personal_portfolio.entity.ContactMessageEntity;
import com.stency.personal_portfolio.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @Autowired
    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @GetMapping
    public List<ContactMessageEntity> getAllMessages(){
        return contactMessageService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessageEntity> getMessageById(@PathVariable Long id) {
        return contactMessageService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContactMessageEntity createMessage(@RequestBody ContactMessageEntity message) {
        return contactMessageService.createMessage(message);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }


}
