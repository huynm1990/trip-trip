/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;
import java.util.Date;

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
public class OpeningHoursDTO extends BaseDTO implements Serializable {

    private String itemId;
    private String timeZone;
    private String openDay;
    private Date openTime;
    private String closeDay;
    private Date closeTime;

    @Override
    public String toString() {
        return "OpeningHoursDTO [itemId=" + itemId + ", timeZone=" + timeZone + ", openDay=" + openDay + ", openTime=" + openTime + ", closeDay=" + closeDay + ", closeTime=" + closeTime + "]";
    }

}
