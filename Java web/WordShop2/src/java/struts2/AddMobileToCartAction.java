/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import cart.Cart;
import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Ngo Nhat Do
 */
@ResultPath("/")
@Results({
    @Result(name = "success", type = "redirectAction",
            params = {
                "actionName", "searchByUser",
                "min", "${min}",
                "max", "${max}"
            })
})
public class AddMobileToCartAction {

    private String min;
    private String max;
    private String mobileName;
    private final String SUCCESS = "success";

    public AddMobileToCartAction() {
    }

    @Action("addMobileToCart")
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        Cart cart =  (Cart) session.get("LISTMOBILES");
        
        if (cart == null) {
            cart = new Cart();
        }
        cart.addMobileToCart(mobileName);
        session.put("LISTMOBILES", cart);
        return SUCCESS;
    }


    /**
     * @return the min
     */
    public String getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public String getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(String max) {
        this.max = max;
    }

    /**
     * @return the mobileName
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * @param mobileName the mobileName to set
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

}
