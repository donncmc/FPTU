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
import tbl_cart.tbl_CartDAO;
/**
 *
 * @author Ngo Nhat Do
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "searchByUser.jsp"),
    @Result(name = "fail", location = "buyMobilesErr.jsp")
})
public class BuyMoileAction {

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public BuyMoileAction() {
    }
    @Action("buyMoile")
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String url = FAIL;
        if (session != null) {
            Cart cart = (Cart) session.get("LISTMOBILES");
            if (cart != null) {
                Map<String, Integer> mobiles = cart.getMobiles();
                String userId = (String) session.get("USERNAME");
                for (Map.Entry<String, Integer> mobile : mobiles.entrySet()) {
                    tbl_CartDAO dao = new tbl_CartDAO();
                    boolean result = dao.buyMobile(userId, mobile.getKey(), mobile.getValue());
                    if (result) {
                        session.remove("LISTMOBILES");
                        url = SUCCESS;
                    }
                }
            }
        }
        return url;
    }

}
