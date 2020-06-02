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
        @Result(name = "fail" , location = "deleteErr.html")
})
public class DeleteRecordAction {

    private String pk;
    private String lastSearchValue;
    private String lastSearchType;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public DeleteRecordAction() {
    }
@Action("delete")
    public String execute() throws Exception {
        tbl_MobileDAO dao = new tbl_MobileDAO();
        boolean result = dao.deleteMobile(pk);
        String url = FAIL;
        if (result) {
            url = SUCCESS;
        }
        return url;
    }

    /**
     * @return the pk
     */
    public String getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(String pk) {
        this.pk = pk;
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
