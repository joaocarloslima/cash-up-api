package br.com.fiap.cash_up_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cash_up_api.model.Category;

@RestController // component
public class CategoryController {

    // listar todas as categorias
    // GET :8080/categories -> json
    @GetMapping("/categories")
    public List<Category> index(){ //mocky
        return List.of(
            new Category(1L, "Educação", "book"),
            new Category(2L, "Lazer", "casino"),
            new Category(3L, "Salário", "payments")
        );
    }

    // cadastrar categoria

    // apagar categoria

    // editar uma categorias
    
}
