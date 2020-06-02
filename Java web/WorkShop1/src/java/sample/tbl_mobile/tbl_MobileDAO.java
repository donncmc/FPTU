/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author Ngo Nhat Do
 */
public class tbl_MobileDAO implements Serializable {

    List<tbl_MobileDTO> listMobile;

    public List<tbl_MobileDTO> getListMobile() {
        return listMobile;
    }

    public void searchIdByStaff(String id) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from tbl_Mobile where mobileId like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + id + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    tbl_MobileDTO dto = new tbl_MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobile == null) {
                        this.listMobile = new ArrayList<>();
                    }
                    this.listMobile.add(dto);
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
    }

    public void searchNameByStaff(String name) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from tbl_Mobile where mobileName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    tbl_MobileDTO dto = new tbl_MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobile == null) {
                        this.listMobile = new ArrayList<>();
                    }
                    this.listMobile.add(dto);
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
    }

    public boolean deleteMobile(String mobileId) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "delete from tbl_Mobile where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobileId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateMobile(String mobileId, String description, float price,
            int quantity, boolean notSale) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update tbl_Mobile set description = ?, price = ?, "
                        + "quantity = ?, notSale = ? where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, description);
                stm.setFloat(2, price);
                stm.setInt(3, quantity);
                stm.setBoolean(4, notSale);
                stm.setString(5, mobileId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertMobile(String mobileId, String description, float price,
            String mobileName, int yearOfProduction, int quantity, boolean notSale)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into tbl_Mobile(mobileId, description, price, mobileName, yearOfProduction,"
                        + " quantity, notSale) Values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobileId);
                stm.setString(2, description);
                stm.setFloat(3, price);
                stm.setString(4, mobileName);
                stm.setInt(5, yearOfProduction);
                stm.setInt(6, quantity);
                stm.setBoolean(7, notSale);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public void searchByUser(float min, float max) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select * from tbl_Mobile where price > ? and price < ? order by price";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, min);
                stm.setFloat(2, max);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    tbl_MobileDTO dto = new tbl_MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                    if (this.listMobile == null) {
                        this.listMobile = new ArrayList<>();
                    }
                    this.listMobile.add(dto);
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
    }
}
