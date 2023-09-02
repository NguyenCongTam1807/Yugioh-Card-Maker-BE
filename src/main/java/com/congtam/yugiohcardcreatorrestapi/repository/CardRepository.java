package com.congtam.yugiohcardcreatorrestapi.repository;

import com.congtam.yugiohcardcreatorrestapi.entity.UploadedYugiohCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<UploadedYugiohCard, String> {

    List<UploadedYugiohCard> findAllByOrderByUploadedAtDesc();
    Page<UploadedYugiohCard> findAllByOrderByUploadedAtDesc(Pageable pageable);
    Page<UploadedYugiohCard> findAllByNameContaining(String name, Pageable pageable);
    Page<UploadedYugiohCard> findAllByCreatorName(String name, Pageable pageable);
    UploadedYugiohCard save(UploadedYugiohCard card);
    void deleteById(String id);
}
