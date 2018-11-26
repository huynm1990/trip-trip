/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.org.triptrip.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User DTO
 * 
 * @author hoan.tran
 */
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
public class InteractionDTO extends BaseDTO implements Serializable {

    private String type;
    private Integer order;
    private String key;
    private String name;
    private Integer count;

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
