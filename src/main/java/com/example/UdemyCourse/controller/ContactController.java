package com.example.UdemyCourse.controller;

import com.example.UdemyCourse.model.Contact;
import com.example.UdemyCourse.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        int randomNum = ThreadLocalRandom.current().nextInt(1000000);
        return String.format("SR%06d", randomNum);
    }
}