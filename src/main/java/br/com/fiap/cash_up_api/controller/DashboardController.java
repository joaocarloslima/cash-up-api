package br.com.fiap.cash_up_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cash_up_api.service.AiAnaliseService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private AiAnaliseService aiAnaliseService;

    @GetMapping("analise")
    public String analise( @RequestParam String language){
        return aiAnaliseService.getExpenseAnalise( language);
    }
    
}
