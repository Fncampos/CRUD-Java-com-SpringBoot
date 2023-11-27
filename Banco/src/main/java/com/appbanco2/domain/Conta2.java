/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appbanco2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author flavia
 */
@Entity
public class Conta2 implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nomeCliente;
    private float saldo;
    @Version
    private Date version;

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Date getVersion() {
        return version;
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

    public void setVersion(Date version) {
        this.version = version;
    }
       
    
}
