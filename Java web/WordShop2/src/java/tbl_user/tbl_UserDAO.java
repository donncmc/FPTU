/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Ngo Nhat Do
 */
public class tbl_UserDAO implements Serializable {

    public int checkLogin(String username, int password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int role = 1;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "select * from tbl_User where userId = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setInt(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getInt("role");
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return role;
    }

    public String getFullname(String username, int password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String fullname = "";
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "select * from tbl_User where userId = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setInt(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    fullname = rs.getString("fullName");
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return fullname;
    }
}
