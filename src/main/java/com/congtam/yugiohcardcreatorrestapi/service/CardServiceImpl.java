package com.congtam.yugiohcardcreatorrestapi.service;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;
import com.congtam.yugiohcardcreatorrestapi.repository.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService{
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<UploadedYugiohCard> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public List<UploadedYugiohCard> findAllByCardName(String cardName) {
        return cardRepository.findAllByNameContaining(cardName);
    }

    @Override
    public List<UploadedYugiohCard> findAllByCreatorName(String creatorName) {
        return cardRepository.findAllByCreatorName(creatorName);
    }

    @Override
    public void uploadCard(YugiohCard card) {
        UploadedYugiohCard uploadedCard = new UploadedYugiohCard();
        uploadedCard.setId(UUID.randomUUID().toString());
        uploadedCard.setUploadedAt(System.currentTimeMillis());
        BeanUtils.copyProperties(card, uploadedCard);
        cardRepository.save(uploadedCard);
    }

    @Override
    public void deleteCard(String id) {
        cardRepository.deleteById(id);
    }
}
