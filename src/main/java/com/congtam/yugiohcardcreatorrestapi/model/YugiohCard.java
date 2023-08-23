package com.congtam.yugiohcardcreatorrestapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class YugiohCard {
    private String name;
    private String attribute;
    private String imagePath;
    private String monsterType;
    private String description;
    private String atk;
    private String def;
    private String creatorName;
    private String cardType;
    private int level;
    private String effectType;
    private String linkArrows;
    private String storageKey;
}
