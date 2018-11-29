/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
@ToString
public class ItemViewDTO extends BaseDTO implements Serializable {

    private String itemType;
    private String itemKind;
    private String level;
    private String ownerId;
    private String ownerName;
    private String ownerImage;
    private String title;
    private String detail;
    private String description;
    private String destination;
    private String status;
    private BigDecimal newPrice;
    private BigDecimal oldPrice;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String currency;
    private String priceType;
    private BigDecimal comparablePrice;
    private String imageId;
    private String originalImage;
    private String largeImage;
    private String mediumImage;
    private String smallImage;
    private String imageDescription;
    private String imageDimension;
    private List<String> categoryList;
    private List<String> keywordList;
    private List<InteractionDTO> interactionList;
    private Integer followers;
    private Long comments;
    private Integer accounts;
    private Integer views;
    private ServiceDetailDTO serviceDetail;

    @Builder
    public ItemViewDTO(String uuid, Integer id, String captchaResponse, Date created, Date updated,
                       String itemType, String itemKind, String level, String ownerId, String ownerName,
                       String ownerImage, String title, String detail, String description, String destination,
                       String status, BigDecimal newPrice, BigDecimal oldPrice, BigDecimal fromPrice,
                       BigDecimal toPrice, String currency, String priceType, BigDecimal comparablePrice,
                       String imageId, String originalImage, String largeImage, String mediumImage,
                       String smallImage, String imageDescription, String imageDimension, List<String> categoryList,
                       List<String> keywordList, List<InteractionDTO> interactionList, Integer followers,
                       Long comments, Integer accounts, Integer views, ServiceDetailDTO serviceDetail) {
        super(uuid, id, captchaResponse, created, updated);
        this.itemType = itemType;
        this.itemKind = itemKind;
        this.level = level;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerImage = ownerImage;
        this.title = title;
        this.detail = detail;
        this.description = description;
        this.destination = destination;
        this.status = status;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.currency = currency;
        this.priceType = priceType;
        this.comparablePrice = comparablePrice;
        this.imageId = imageId;
        this.originalImage = originalImage;
        this.largeImage = largeImage;
        this.mediumImage = mediumImage;
        this.smallImage = smallImage;
        this.imageDescription = imageDescription;
        this.imageDimension = imageDimension;
        this.categoryList = categoryList;
        this.keywordList = keywordList;
        this.interactionList = interactionList;
        this.followers = followers;
        this.comments = comments;
        this.accounts = accounts;
        this.views = views;
        this.serviceDetail = serviceDetail;
    }

}
