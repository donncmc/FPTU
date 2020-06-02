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
    @Result(name = "success", location = "searchByUser.jsp")
})
public class SearchByUserAction {

    private String min;
    private String max;
    private List<tbl_MobileDTO> listMobiles;
    private final String SUCCESS = "success";

    public SearchByUserAction() {
    }

    @Action("searchByUser")
    public String execute() throws Exception {
        try {
            int mins = Integer.parseInt(min);
            int maxs = Integer.parseInt(max);
            tbl_MobileDAO dao = new tbl_MobileDAO();
            dao.searchByUser(mins, maxs);
            this.listMobiles = dao.getListMobile();
        } catch (NumberFormatException e) {
        }
        return SUCCESS;
    }

    public List<tbl_MobileDTO> getListMobiles() {
        return listMobiles;
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

}
