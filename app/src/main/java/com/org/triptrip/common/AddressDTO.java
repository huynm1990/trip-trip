/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;
import java.math.BigDecimal;

import com.github.hoantran.lib.utility.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
public class AddressDTO extends BaseDTO implements Serializable {

    private String itemId;
    private String placeId;
    private String formattedAddress;
    private String addressComponents;
    private String types;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String street;
    private String district;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "AddressDTO [placeId=" + placeId + ", formattedAddress=" + formattedAddress + ", addressComponents=" + addressComponents + ", types=" + types + ", latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + ", street=" + street + ", district=" + district + ", city=" + city + ", country=" + country + "]";
    }

}
