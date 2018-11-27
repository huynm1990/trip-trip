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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
@ToString
public class ServiceDetailDTO extends BaseDTO implements Serializable {

    private String itemId;
    private String manageType;
    private String affiliateLink;

    private String priceType;
    private String currency;
    private BigDecimal oldPrice;
    private BigDecimal newPrice;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;

    private String phone;
    private String email;
    private String website;

    private String holidayAvailability;
    private String note;

    private AddressDTO address;
    private List<OpeningHoursDTO> openingHoursList;

    @Builder
    public ServiceDetailDTO(String uuid, Integer id, String captchaResponse, Date created, Date updated,
                            String itemId, String manageType, String affiliateLink, String priceType,
                            String currency, BigDecimal oldPrice, BigDecimal newPrice, BigDecimal fromPrice,
                            BigDecimal toPrice, String phone, String email, String website, String holidayAvailability,
                            String note, AddressDTO address, List<OpeningHoursDTO> openingHoursList) {
        super(uuid, id, captchaResponse, created, updated);
        this.itemId = itemId;
        this.manageType = manageType;
        this.affiliateLink = affiliateLink;
        this.priceType = priceType;
        this.currency = currency;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.holidayAvailability = holidayAvailability;
        this.note = note;
        this.address = address;
        this.openingHoursList = openingHoursList;
    }
}
