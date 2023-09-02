package com.congtam.yugiohcardcreatorrestapi.controller;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;
import com.congtam.yugiohcardcreatorrestapi.service.CardService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/cards")
@Validated
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("")
    @Pattern(regexp = "^[0-9]+$")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCards(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        return ResponseEntity.ok(cardService.findAll(page, size));
    }

    @GetMapping("/searchByCardName")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCardsByName(
            @RequestParam String cardName, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(cardService.findAllByCardName(cardName, page, size));
    }

    @GetMapping("/searchByCreatorName")
    public ResponseEntity<List<UploadedYugiohCard>> getAllCardsByCreatorName(
            @RequestParam String creatorName, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(cardService.findAllByCreatorName(creatorName, page, size));
    }

    @PostMapping("")
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
