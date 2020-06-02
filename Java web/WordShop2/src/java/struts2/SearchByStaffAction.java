/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import tbl_mobile.tbl_MobileDAO;
import tbl_mobile.tbl_MobileDTO;

/**
 *
 * @author Ngo Nhat Do
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "searchByStaff.jsp")
})
public class SearchByStaffAction {

    private String searchValue;
    private String searchType;
    private List<tbl_MobileDTO> listMobile;
    private final String SUCCESS = "success";

    public SearchByStaffAction() {
    }

    @Action("search")
    public String execute() throws Exception {
        if (searchType == null) {
            return SUCCESS;
        }
        tbl_MobileDAO dao = new tbl_MobileDAO();
        if (searchType.equals("name")) {
            dao.searchNameByStaff(searchValue);
        } else if (searchType.equals("id")) {
            dao.searchIdByStaff(searchValue);
        }
        listMobile = dao.getListMobile();
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the listMobile
     */
    public List<tbl_MobileDTO> getListMobile() {
        return listMobile;
    }

}
