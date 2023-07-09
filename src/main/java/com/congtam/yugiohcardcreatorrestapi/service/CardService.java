package com.congtam.yugiohcardcreatorrestapi.service;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import com.congtam.yugiohcardcreatorrestapi.model.YugiohCard;

import java.util.List;

public interface CardService {
    List<UploadedYugiohCard> findAll();
    List<UploadedYugiohCard> findAllByCardName(String cardName);
    List<UploadedYugiohCard> findAllByCreatorName(String creatorName);
    UploadedYugiohCard uploadCard(YugiohCard card);
    void deleteCard(String id);
}
