/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ngo Nhat Do
 */
public class Cart implements Serializable {

    private String custumerId;
    private Map<String, Integer> mobiles;

    /**
     * @return the custumerId
     */
    public String getCustumerId() {
        return custumerId;
    }

    /**
     * @param custumerId the custumerId to set
     */
    public void setCustumerId(String custumerId) {
        this.custumerId = custumerId;
    }

    /**
     * @return the items
     */
    public Map<String, Integer> getMobiles() {
        return mobiles;
    }

    public void addMobileToCart(String mobileName) {
        if (this.mobiles == null) {
            this.mobiles = new HashMap<>();
        }
        int quantity = 1;
        if (this.mobiles.containsKey(mobileName)) {
            quantity = this.mobiles.get(mobileName) + 1;
        }
        this.mobiles.put(mobileName, quantity);
    }

    public void removeMobileFromCart(String mobileName) {
        if (this.mobiles == null) {
            return;
        }
        if (this.mobiles.containsKey(mobileName)) {
            this.mobiles.remove(mobileName);
            if (this.mobiles.isEmpty()) {
                this.mobiles = null;
            }
        }
    }

    public void empty() {
        this.mobiles = null;
    }
}
