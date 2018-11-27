/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;
import java.util.Date;

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
public class OpeningHoursDTO extends BaseDTO implements Serializable {

    private String itemId;
    private String timeZone;
    private String openDay;
    private Date openTime;
    private String closeDay;
    private Date closeTime;

    @Builder
    public OpeningHoursDTO(String uuid, Integer id, String captchaResponse, Date created, Date updated,
                           String itemId, String timeZone, String openDay, Date openTime, String closeDay,
                           Date closeTime) {
        super(uuid, id, captchaResponse, created, updated);
        this.itemId = itemId;
        this.timeZone = timeZone;
        this.openDay = openDay;
        this.openTime = openTime;
        this.closeDay = closeDay;
        this.closeTime = closeTime;
    }
    @Override
    public String toString() {
        return "OpeningHoursDTO [itemId=" + itemId + ", timeZone=" + timeZone + ", openDay=" + openDay + ", openTime=" + openTime + ", closeDay=" + closeDay + ", closeTime=" + closeTime + "]";
    }

}
