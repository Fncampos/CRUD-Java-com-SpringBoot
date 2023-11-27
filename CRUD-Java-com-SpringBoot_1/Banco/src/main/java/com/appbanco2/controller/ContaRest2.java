/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appbanco2.controller;


import com.appbanco2.domain.Conta2;
import com.appbanco2.domain.ContaRepository2;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author flavia
 */
@RestController
@RequestMapping(value = "/contas")
public class ContaRest2 {


    @Autowired
    private ContaRepository2 contaRepo;

    public ContaRest2() { }
    
    public ContaRest2(ContaRepository2 contaRepo){
        this.contaRepo=contaRepo;
    }
    
    //curl -X PUT "http://localhost:8080/contas"
    @GetMapping
    public List<Conta2> pesquisar() {		
	return contaRepo.findAll();
	}
    //curl -X PUT "http://localhost:8080/contas/1"
    @GetMapping("/{id}")
    public Optional<Conta2> buscaConta(@PathVariable int id){
               
        return contaRepo.findById(id);
    }
    //curl -X PUT "http://localhost:8080/contas/deposita/1?valor=100.0"
    @PutMapping("/deposita/{id}")
    public ResponseEntity<String> deposita(@PathVariable int id, @RequestParam float valor) {
    Optional<Conta2> contaOptional = contaRepo.findById(id);

        if (contaOptional.isPresent()) {
            Conta2 conta = contaOptional.get();
            float novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);
            contaRepo.save(conta);
            System.out.println(conta.getSaldo());
            return ResponseEntity.ok("Depósito de " + valor + " realizado com sucesso. Novo saldo: " + novoSaldo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //curl -X PUT "http://localhost:8080/contas/retirada/1?valor=20000.0"
    @PutMapping("/retirada/{id}")
    public ResponseEntity<String> retirada(@PathVariable int id, @RequestParam float valor) {
        Optional<Conta2> contaOptional = contaRepo.findById(id);

        if (contaOptional.isPresent()) {
            Conta2 conta = contaOptional.get();

            if (conta.getSaldo() >= valor) {
                float novoSaldo = conta.getSaldo() - valor;
                conta.setSaldo(novoSaldo);
                contaRepo.save(conta);
                System.out.println(conta.getSaldo());
                return ResponseEntity.ok("Retirada de " + valor + " realizada com sucesso. Novo saldo: " + novoSaldo);
            } else {
                return ResponseEntity.badRequest().body("Saldo insuficiente para a retirada.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
    
}
