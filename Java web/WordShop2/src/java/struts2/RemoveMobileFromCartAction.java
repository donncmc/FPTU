/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import cart.Cart;
import com.opensymphony.xwork2.ActionContext;
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
    @Result(name = "success", location = "viewCart.jsp")
})
public class RemoveMobileFromCartAction {

    private String[] pk;
    private final String SUCCESS = "success";

    public RemoveMobileFromCartAction() {
    }

    @Action("removeMobileFromCart")
    public String execute() throws Exception {
        if (pk == null) {
            return SUCCESS;
        }
        Map session = ActionContext.getContext().getSession();
        if (session != null) {
            Cart cart = (Cart) session.get("LISTMOBILES");
            if (cart != null) {
                for (String string : pk) {
                    cart.removeMobile(string);
                }
                session.put("LISTMOBILES", cart);
            }
        }
        return SUCCESS;
    }

    /**
     * @return the pk
     */
    public String[] getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(String[] pk) {
        this.pk = pk;
    }

}
