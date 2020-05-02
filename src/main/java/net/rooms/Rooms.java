/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rooms;

public class Rooms {
    
    private int id;
    private String room_type;
    private String reg_no;
    private String room_location;
    private String monthly_charge;
    private String room_status;
    private String payment_status;

    public Rooms(int id, String room_type, String reg_no, String room_location, String monthly_charge, String room_status, String payment_status) {
        this.id = id;
        this.room_type = room_type;
        this.reg_no = reg_no;
        this.room_location = room_location;
        this.monthly_charge = monthly_charge;
        this.room_status = room_status;
        this.payment_status = payment_status;
    }

    public Rooms(String room_type, String reg_no, String room_location, String monthly_charge, String room_status, String payment_status) {
        this.room_type = room_type;
        this.reg_no = reg_no;
        this.room_location = room_location;
        this.monthly_charge = monthly_charge;
        this.room_status = room_status;
        this.payment_status = payment_status;
    }

    public Rooms(int id, String room_type, String room_location, String monthly_charge, String room_status, String payment_status) {
        this.id = id;
        this.room_type = room_type;
        this.room_location = room_location;
        this.monthly_charge = monthly_charge;
        this.room_status = room_status;
        this.payment_status = payment_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getRoom_location() {
        return room_location;
    }

    public void setRoom_location(String room_location) {
        this.room_location = room_location;
    }

    public String getMonthly_charge() {
        return monthly_charge;
    }

    public void setMonthly_charge(String monthly_charge) {
        this.monthly_charge = monthly_charge;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
    
    
    
}
