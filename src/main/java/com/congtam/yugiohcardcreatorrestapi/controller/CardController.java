package com.congtam.yugiohcardcreatorrestapi.controller;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;
import com.congtam.yugiohcardcreatorrestapi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/cards")
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCards() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @GetMapping("/searchByCardName")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCardsByName(@RequestParam String cardName) {
        return ResponseEntity.ok(cardService.findAllByCardName(cardName));
    }

    @GetMapping("/searchByCreatorName")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCardsByCreatorName(@RequestParam String creatorName) {
        return ResponseEntity.ok(cardService.findAllByCreatorName(creatorName));
    }

    @PostMapping("/")
    public ResponseEntity<Void> uploadCard(@RequestBody YugiohCard card) {
        cardService.uploadCard(card);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable String id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
