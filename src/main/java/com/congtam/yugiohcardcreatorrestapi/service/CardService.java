package com.congtam.yugiohcardcreatorrestapi.service;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;

import java.util.List;

public interface CardService {
    List<UploadedYugiohCard> findAll(Integer page, Integer size);
    List<UploadedYugiohCard> findAllByCardName(String cardName, Integer page, Integer size);
    List<UploadedYugiohCard> findAllByCreatorName(String creatorName, Integer page, Integer size);
    void uploadCard(YugiohCard card);
    void deleteCard(String id);
}
