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
}
