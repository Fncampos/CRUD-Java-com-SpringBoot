/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appbanco1.controller;


import com.appbanco1.domain.Conta;
import com.appbanco1.domain.ContaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author flavia
 */
@RestController
@RequestMapping(value = "/contas")
public class ContaRest {
    @Autowired
    private ContaRepository contaRepo;

    public ContaRest() { }
    
    public ContaRest(ContaRepository contaRepo){
        this.contaRepo=contaRepo;
    }
    
    //curl -X PUT "http://localhost:8080/contas"
    @GetMapping
    public List<Conta> pesquisar() {		
	return contaRepo.findAll();
	}
    //curl -X PUT "http://localhost:8080/contas/1"
    @GetMapping("/{id}")
    public Optional<Conta> buscaConta(@PathVariable int id){
               
        return contaRepo.findById(id);
    }
    //curl -X PUT "http://localhost:8080/contas/deposita/1?valor=100.0"
    @PutMapping("/deposita/{id}")
    public ResponseEntity<String> deposita(@PathVariable int id, @RequestParam float valor) {
    Optional<Conta> contaOptional = contaRepo.findById(id);

        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            float novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);
            contaRepo.save(conta);
            return ResponseEntity.ok("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + novoSaldo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //curl -X PUT "http://localhost:8080/contas/retirada/1?valor=20000.0"
    @PutMapping("/retirada/{id}")
    public ResponseEntity<String> retirada(@PathVariable int id, @RequestParam float valor) {
        Optional<Conta> contaOptional = contaRepo.findById(id);

        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();

            if (conta.getSaldo() >= valor) {
                float novoSaldo = conta.getSaldo() - valor;
                conta.setSaldo(novoSaldo);
                contaRepo.save(conta);
                return ResponseEntity.ok("Retirada de R$" + valor + " realizada com sucesso. Novo saldo: R$" + novoSaldo);
            } else {
                return ResponseEntity.badRequest().body("Saldo insuficiente para a retirada.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
    
}
