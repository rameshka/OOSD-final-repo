/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class HallBooking extends Booking{
    private Hall hall;
    private int noOfPeople;
    private Date date;

    /**
     * @return the noOfPeople
     */
    public int getNoOfPeople() {
        return noOfPeople;
    }

    /**
     * @param noOfPeople the noOfPeople to set
     */
    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
