/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.pizzahut.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SK69016
 */

@XmlRootElement
public class CustomerOrder {
    
    MenuItem[] orderItems;

    public MenuItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(MenuItem[] orderItems) {
        this.orderItems = orderItems;
    }    
    
}
