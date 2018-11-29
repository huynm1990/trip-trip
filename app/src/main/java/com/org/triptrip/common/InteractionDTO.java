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

/**
 * User DTO
 * 
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
public class InteractionDTO extends BaseDTO implements Serializable {

    private String type;
    private Integer order;
    private String key;
    private String name;
    private Integer count;

    @Builder
    public InteractionDTO(String uuid, Integer id, String captchaResponse, Date created, Date updated,
                          String type, Integer order, String key, String name, Integer count) {
        super(uuid, id, captchaResponse, created, updated);
        this.type = type;
        this.order = order;
        this.key = key;
        this.name = name;
        this.count = count;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
        if (count == null) {
            return 0;
        }
        return count;
    }

    @Override
    public String toString() {
        return "InteractionDTO [type=" + type + ", order=" + order + ", key=" + key + ", name=" + name + ", count=" + count + "]";
    }

}
