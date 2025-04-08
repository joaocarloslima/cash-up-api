package br.com.fiap.cash_up_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cash_up_api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    //List<Transaction> findByDescriptionContainingIgnoringCase(String description); // Query Methods

    //List<Transaction> findByDescriptionContainingIgnoringCaseAndDate(String description, LocalDate date);

   // List<Transaction> findByDate(LocalDate date);
    
}
