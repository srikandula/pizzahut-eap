/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.pizzahut.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SK69016
 */
@XmlRootElement
public class Menu extends PizzaModel implements Serializable{
	
    public MenuItem[] items;

    public MenuItem[] getItems() {
        return items;
    }

    public void setItems(MenuItem[] items) {
        this.items = items;
    }


}
