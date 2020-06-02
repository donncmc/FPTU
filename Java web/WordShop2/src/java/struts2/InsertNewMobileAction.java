/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
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
    @Result(name = "success", location = "login.html")
    ,
    @Result(name = "fail", location = "insertErr.html")
    ,
    @Result(name = "input", location = "insertNewMobile.jsp")})
public class InsertNewMobileAction extends ActionSupport {

    private String mobileId;
    private String description;
    private int price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public InsertNewMobileAction() {
    }
    
    @Action(value = "insertNewMobile", exceptionMappings = {
        @ExceptionMapping(exception = "java.sql.SQLException", result = "input")
    })
    public String execute() throws Exception {
        tbl_MobileDAO dao = new tbl_MobileDAO();
        boolean result = dao.insertMobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
        String url = FAIL;
        if (result) {
            url = SUCCESS;
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
    @RequiredStringValidator(message = "Mobile Id is required!!!")
    @StringLengthFieldValidator(minLength = "2", maxLength = "10",
            message = "Mobile Id is required 2-10 chars!!")
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
    @RequiredStringValidator(message = "Description is required!!!")
    @StringLengthFieldValidator(minLength = "3", maxLength = "250",
            message = "Mobile Id is required 3-250 chars!!")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @IntRangeFieldValidator(message = "Price is number!!", min = "0")
    public void setPrice(int price) {
        this.price = price;
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
    @RequiredStringValidator(message = "Mobile Name is required!!!")
    @StringLengthFieldValidator(minLength = "3", maxLength = "250",
            message = "Mobile Name is required 3-250 chars!!")
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * @return the yearOfProduction
     */
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    /**
     * @param yearOfProduction the yearOfProduction to set
     */
    @IntRangeFieldValidator(message = "Year Of Production is number!!", min = "0")
    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    @IntRangeFieldValidator(message = "Quantity is number!!", min = "0")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the notSale
     */
    public boolean isNotSale() {
        return notSale;
    }

    /**
     * @param notSale the notSale to set
     */
    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

}
