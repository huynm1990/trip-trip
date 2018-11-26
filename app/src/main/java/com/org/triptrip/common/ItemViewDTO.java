/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
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

}
