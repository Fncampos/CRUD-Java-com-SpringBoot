/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appbanco1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author flavia
 */
@Entity
public class Conta implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nomeCliente;
    private float saldo;

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    

    public float getSaldo() {
        return saldo;
    }
    
    
    
    
}
