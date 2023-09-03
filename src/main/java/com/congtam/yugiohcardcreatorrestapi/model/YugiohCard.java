package com.congtam.yugiohcardcreatorrestapi.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
@Setter
@Getter
public class YugiohCard {

    @NotBlank(message = "Card name must not be blank")
    @Length(max = 63, message = "Card name can only have 63 characters at maximum")
    private String name;
    @NotBlank(message = "Card attribute must be provided")
    @Length(max = 31, message = "Name of card attribute is too long")
    private String attribute;
    @NotBlank(message = "Image path must be provided")
    @Length(max = 255, message = "Image path is too long")
    private String imagePath;
    @NotBlank(message = "Monster type must be provided")
    @Length(max = 63, message = "List of monster types is too long")
    private String monsterType;
    @NotNull(message = "Description must not be null")
    @Length(max = 1023, message = "Description can only have 1023 characters at maximum")
    private String description;
    @NotBlank(message = "Atk must be provided")
    @Pattern(regexp = "^(?:\\d{1,4}|\\?)$", message = "Invalid atk")
    private String atk;
    @NotBlank(message = "Def must be provided")
    @Pattern(regexp = "^(?:\\d{1,4}|\\?)$", message = "invalid def")
    private String def;
    @NotBlank(message = "Creator name must be provided")
    @Length(max = 63, message = "Card name can only have 63 characters at maximum")
    private String creatorName;
    @NotBlank(message = "Card type must be provided")
    @Length(max = 31, message = "Card type name is too long")
    private String cardType;
    @NotNull(message = "Monster level must be provided")
    @Min(value = 1, message = "Invalid level")
    @Max(value = 12, message = "Invalid level")
    private int level;
    @NotBlank(message = "Effect type must be provided")
    @Length(max = 31, message = "Effect type name is too long")
    private String effectType;
    @NotBlank(message = "Link arrows info must be provided")
    @Length(min = 8, max = 8, message = "Invalid link arrows info")
    private String linkArrows;
    @NotBlank(message = "Thumbnail url must be provided")
    @Length(max = 255, message = "Thumbnail url is too long")
    private String thumbnailUrl;
    @NotBlank(message = "Url of full card image must be provided")
    @Length(max = 255 , message = "Url of full card image is too long")
    private String fullCardImageUrl;
}
