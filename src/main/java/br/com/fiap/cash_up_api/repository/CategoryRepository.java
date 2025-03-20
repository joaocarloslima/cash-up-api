package br.com.fiap.cash_up_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cash_up_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
