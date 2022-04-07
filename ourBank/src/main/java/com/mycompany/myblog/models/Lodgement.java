/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.models;


/**
 *
 * @author Luke Kavanagh (x17520686)
 * 
 */

public class Lodgement {

    public enum LodgementType {
        TYPE
    }

    // Data Members
    private LodgementType lodgementType;
    private String description;
    private double total;
    private String lodgementDate;

    public Lodgement() {
    }

    // constuctor
    public Lodgement(LodgementType lodgementType, String Description, double total, String lodgementDate) {
        this.lodgementType = lodgementType;
        this.total = total;
        this.description = Description;
        this.lodgementDate = lodgementDate;
    }

    // getters and Setters
    public LodgementType getLodgementType() {
        return lodgementType;
    }

    public void setLodgementtype(String LodgementType) {
        this.lodgementType = lodgementType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    double getTotal() {
        return total;
    }

    public void setTotal(double Total) {
        this.total = total;
    }

    public String setLodgementDate() {
        return lodgementDate;
    }

    public void setLodgementDate(String LodgementDate) {
        this.lodgementDate = lodgementDate;
    }
}