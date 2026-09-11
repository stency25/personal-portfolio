package com.stency.personal_portfolio.service;


import com.stency.personal_portfolio.entity.ContactMessageEntity;
import com.stency.personal_portfolio.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private  final ContactMessageRepository contactMessageRepository;

    @Autowired
    public ContactService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }
    public List <ContactMessageEntity>getAllContacts(){
        return contactMessageRepository.findAll();
    }
    public Optional<ContactMessageEntity> getById(Long id){
        return contactMessageRepository.findById(id);
    }
    public ContactMessageEntity createMessage(ContactMessageEntity message){
        message.setSubmittedAt(LocalDateTime.now());
        return contactMessageRepository.save(message);
    }
    public void deleteMessage(long id){
        contactMessageRepository.deleteById(id);
    }
}
