package com.congtam.yugiohcardcreatorrestapi.service;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;
import com.congtam.yugiohcardcreatorrestapi.repository.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<UploadedYugiohCard> findAll(Integer page, Integer size) {
        if (page != null && size != null) {
            Pageable paging = PageRequest.of(page, size);
            return cardRepository.findAllByOrderByUploadedAtDesc(paging).toList();
        } else {
            return cardRepository.findAllByOrderByUploadedAtDesc();
        }
    }

    @Override
    public List<UploadedYugiohCard> findAllByCardName(String cardName, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return cardRepository.findAllByNameContaining(cardName, paging).toList();
    }

    @Override
    public List<UploadedYugiohCard> findAllByCreatorName(String creatorName, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        return cardRepository.findAllByCreatorName(creatorName, paging).toList();
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
