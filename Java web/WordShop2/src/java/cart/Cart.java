/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ngo Nhat Do
 */
public class Cart implements Serializable {

    private Map<String, Integer> mobiles;

    public Map<String, Integer> getMobiles() {
        return mobiles;
    }

    public void addMobileToCart(String mobile) {
        if (this.mobiles == null) {
            this.mobiles = new HashMap<>();
        }
        int quantity = 1;
        if (this.mobiles.containsKey(mobile)) {
            quantity = this.mobiles.get(mobile) + 1;
        }
        this.mobiles.put(mobile, quantity);
    }

    public void removeMobile(String mobile) {
        if (this.mobiles == null) {
            return;
        }
        if (this.mobiles.containsKey(mobile)) {
            this.mobiles.remove(mobile);
            if (this.mobiles.isEmpty()) {
                this.mobiles = null;
            }
        }
    }

    public void empty() {
        this.mobiles = null;
    }
}
