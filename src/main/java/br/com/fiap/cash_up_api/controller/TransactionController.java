package br.com.fiap.cash_up_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cash_up_api.model.Transaction;
import br.com.fiap.cash_up_api.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("transactions")
@Slf4j
public class TransactionController {

    record TransactionFilter(String description, LocalDate startDate, LocalDate endDate) {
    }

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public List<Transaction> index(TransactionFilter filter) {

        return repository.findAll();
    }

}
