/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_mobile;

import java.io.Serializable;

/**
 *
 * @author Ngo Nhat Do
 */
public class tbl_MobileInsertErr implements Serializable{
    private String mobileIdLengthErr;
    private String descriptionEmptyErr;
    private String priceFormatErr;
    private String mobileNameLengthErr;
    private String yearOfProductionFormatErr;
    private String quantityFormatErr;
    private String mobileIdIsExited;

    public tbl_MobileInsertErr() {
    }

    public tbl_MobileInsertErr(String mobileIdLengthErr, String descriptionEmptyErr, String priceFormatErr, String mobileNameLengthErr, String yearOfProductionFormatErr, String quantityFormatErr, String mobileIdIsExited) {
        this.mobileIdLengthErr = mobileIdLengthErr;
        this.descriptionEmptyErr = descriptionEmptyErr;
        this.priceFormatErr = priceFormatErr;
        this.mobileNameLengthErr = mobileNameLengthErr;
        this.yearOfProductionFormatErr = yearOfProductionFormatErr;
        this.quantityFormatErr = quantityFormatErr;
        this.mobileIdIsExited = mobileIdIsExited;
    }

    

    /**
     * @return the mobileIdLengthErr
     */
    public String getMobileIdLengthErr() {
        return mobileIdLengthErr;
    }

    /**
     * @param mobileIdLengthErr the mobileIdLengthErr to set
     */
    public void setMobileIdLengthErr(String mobileIdLengthErr) {
        this.mobileIdLengthErr = mobileIdLengthErr;
    }

    /**
     * @return the descriptionEmptyErr
     */
    public String getDescriptionEmptyErr() {
        return descriptionEmptyErr;
    }

    /**
     * @param descriptionEmptyErr the descriptionEmptyErr to set
     */
    public void setDescriptionEmptyErr(String descriptionEmptyErr) {
        this.descriptionEmptyErr = descriptionEmptyErr;
    }

    /**
     * @return the priceFormatErr
     */
    public String getPriceFormatErr() {
        return priceFormatErr;
    }

    /**
     * @param priceFormatErr the priceFormatErr to set
     */
    public void setPriceFormatErr(String priceFormatErr) {
        this.priceFormatErr = priceFormatErr;
    }

    /**
     * @return the mobileNameLengthErr
     */
    public String getMobileNameLengthErr() {
        return mobileNameLengthErr;
    }

    /**
     * @param mobileNameLengthErr the mobileNameLengthErr to set
     */
    public void setMobileNameLengthErr(String mobileNameLengthErr) {
        this.mobileNameLengthErr = mobileNameLengthErr;
    }

    /**
     * @return the yearOfProductionFormatErr
     */
    public String getYearOfProductionFormatErr() {
        return yearOfProductionFormatErr;
    }

    /**
     * @param yearOfProductionFormatErr the yearOfProductionFormatErr to set
     */
    public void setYearOfProductionFormatErr(String yearOfProductionFormatErr) {
        this.yearOfProductionFormatErr = yearOfProductionFormatErr;
    }

    /**
     * @return the quantityFormatErr
     */
    public String getQuantityFormatErr() {
        return quantityFormatErr;
    }

    /**
     * @param quantityFormatErr the quantityFormatErr to set
     */
    public void setQuantityFormatErr(String quantityFormatErr) {
        this.quantityFormatErr = quantityFormatErr;
    }

    /**
     * @return the mobileIdIsExited
     */
    public String getMobileIdIsExited() {
        return mobileIdIsExited;
    }

    /**
     * @param mobileIdIsExited the mobileIdIsExited to set
     */
    public void setMobileIdIsExited(String mobileIdIsExited) {
        this.mobileIdIsExited = mobileIdIsExited;
    }
    
}
