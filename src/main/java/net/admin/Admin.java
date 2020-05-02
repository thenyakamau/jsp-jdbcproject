/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.admin;

public class Admin {
    
    private int id;
    private String teac_no;
    private String teac_name;
    private String authority;
    private String password;

    public Admin(int id, String teac_no, String teac_name, String authority, String password) {
        this.id = id;
        this.teac_no = teac_no;
        this.teac_name = teac_name;
        this.authority = authority;
        this.password = password;
    }

    public Admin(String teac_no, String teac_name, String authority, String password) {
        this.teac_no = teac_no;
        this.teac_name = teac_name;
        this.authority = authority;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeac_no() {
        return teac_no;
    }

    public void setTeac_no(String teac_no) {
        this.teac_no = teac_no;
    }

    public String getTeac_name() {
        return teac_name;
    }

    public void setTeac_name(String teac_name) {
        this.teac_name = teac_name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
