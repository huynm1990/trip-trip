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

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
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

    @Builder
    public AddressDTO(String uuid, Integer id, String captchaResponse, Date created, Date updated,
                      String itemId, String placeId, String formattedAddress, String addressComponents,
                      String types, BigDecimal latitude, BigDecimal longitude, String address,
                      String street, String district, String city, String country) {
        super(uuid, id, captchaResponse, created, updated);
        this.itemId = itemId;
        this.placeId = placeId;
        this.formattedAddress = formattedAddress;
        this.addressComponents = addressComponents;
        this.types = types;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.street = street;
        this.district = district;
        this.city = city;
        this.country = country;

    }
    @Override
    public String toString() {
        return "AddressDTO [placeId=" + placeId + ", formattedAddress=" + formattedAddress + ", addressComponents=" + addressComponents + ", types=" + types + ", latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + ", street=" + street + ", district=" + district + ", city=" + city + ", country=" + country + "]";
    }

}
