package com.example.UdemyCourse.controller;

import com.example.UdemyCourse.model.Cards;
import com.example.UdemyCourse.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestParam int userId) {
        List<Cards> cards = cardsRepository.findByCustomerId(userId);
        return cards;
    }
}