package com.congtam.yugiohcardcreatorrestapi.repository;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<UploadedYugiohCard, String> {

    List<UploadedYugiohCard> findAll();
    List<UploadedYugiohCard> findAllByNameContaining(String name);
    List<UploadedYugiohCard> findAllByCreatorName(String name);
    UploadedYugiohCard save(UploadedYugiohCard card);
    void deleteById(String id);
}
