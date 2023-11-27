/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.appbanco1.domain;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author flavia
 */
public interface ContaRepository extends JpaRepository<Conta, Integer>  {
   
}
