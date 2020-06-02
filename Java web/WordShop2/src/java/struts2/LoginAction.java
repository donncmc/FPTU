/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import tbl_user.tbl_UserDAO;

/**
 *
 * @author Ngo Nhat Do
 */
@ResultPath("/")
@Results({
    @Result(name = "staff", location = "searchByStaff.jsp")
    ,
    @Result(name = "user", location = "searchByUser.jsp")
    ,
    @Result(name = "fail", location = "invalid.html")
})
public class LoginAction {

    private String username;
    private String password;
    private final String STAFF = "staff";
    private final String USER = "user";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        try {
            tbl_UserDAO dao = new tbl_UserDAO();
            int passwords = Integer.parseInt(this.password);
            int result = dao.checkLogin(username, passwords);
            if (result == 0) {
                url = USER;
                Map session = ActionContext.getContext().getSession();
                session.put("USERNAME", dao.getFullname(username, passwords));
            } else if (result == 2) {
                url = STAFF;
                Map session = ActionContext.getContext().getSession();
                session.put("USERNAME", dao.getFullname(username, passwords));
            }

        } catch (NumberFormatException e) {
        }
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
