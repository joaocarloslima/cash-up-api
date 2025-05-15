package br.com.fiap.cash_up_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.cash_up_api.model.Transaction;
import br.com.fiap.cash_up_api.model.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    List<Transaction> findByType(TransactionType expense);

    // List<Transaction> findByDescriptionContainingIgnoringCase(String
    // description); // Query Methods

    // List<Transaction> findByDescriptionContainingIgnoringCaseAndDate(String
    // description, LocalDate date);

    // List<Transaction> findByDate(LocalDate date);

}
