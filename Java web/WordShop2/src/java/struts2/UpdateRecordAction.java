/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import tbl_mobile.tbl_MobileDAO;

/**
 *
 * @author Ngo Nhat Do
 */
@ResultPath("/")
@Results({
    @Result(name = "success", type = "redirectAction",
            params = {"actionName", "search",
                "searchValue", "${lastSearchValue}",
                "searchType", "${lastSearchType}"
            })
    ,
        @Result(name = "fail" , location = "updateErr.html")
})
public class UpdateRecordAction {

    private String mobileId;
    private String description;
    private String price;
    private String quantity;
    private boolean isAdmin;
    private String lastSearchValue;
    private String lastSearchType;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public UpdateRecordAction() {
    }
    @Action("update")
    public String execute() throws Exception {
        String url = FAIL;
        try {
            tbl_MobileDAO dao = new tbl_MobileDAO();
            float prices = Float.parseFloat(price);
            int quantitys = Integer.parseInt(quantity);
            boolean result = dao.updateMobile(mobileId, description, prices, quantitys, isAdmin);
            if (result) {
                url = SUCCESS;
            }
        } catch (NumberFormatException e) {
        }
        return url;
    }

    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the lastSearchValue
     */
    public String getLastSearchValue() {
        return lastSearchValue;
    }

    /**
     * @param lastSearchValue the lastSearchValue to set
     */
    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    /**
     * @return the lastSearchType
     */
    public String getLastSearchType() {
        return lastSearchType;
    }

    /**
     * @param lastSearchType the lastSearchType to set
     */
    public void setLastSearchType(String lastSearchType) {
        this.lastSearchType = lastSearchType;
    }

}
