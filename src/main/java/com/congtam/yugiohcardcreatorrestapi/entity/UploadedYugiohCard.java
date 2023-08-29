package com.congtam.yugiohcardcreatorrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="uploaded_yugioh_card")
@Getter
@Setter
public class UploadedYugiohCard {

    @Id
    @Column
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String attribute;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "monster_type")
    private String monsterType;

    @Column
    private String description;

    @Column
    private String atk;

    @Column
    private String def;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "card_type")
    private String cardType;

    @Column
    private int level;

    @Column(name = "effect_type")
    private String effectType;

    @Column(name = "link_arrows")
    private String linkArrows;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "full_card_image_url")
    private String fullCardImageUrl;

    @Column(name = "uploaded_at")
    private long uploadedAt;
}
