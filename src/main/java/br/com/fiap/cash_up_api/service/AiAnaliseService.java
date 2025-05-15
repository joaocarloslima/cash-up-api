package br.com.fiap.cash_up_api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.cash_up_api.model.TransactionType;
import br.com.fiap.cash_up_api.repository.TransactionRepository;

@Service
public class AiAnaliseService {

    private ChatClient chatClient;
    private TransactionRepository transactionRepository;

    public AiAnaliseService(ChatClient.Builder chatClientBuilder, Resource systemMessage, TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.chatClient = chatClientBuilder
                            .defaultSystem(systemMessage)
                            .defaultOptions(ChatOptions.builder().temperature(0.9).topP(0.8).build())
                            .build();
    }

    public String getExpenseAnalise( String language){
        var expenses = transactionRepository.findByType(TransactionType.EXPENSE);

        var objectMapper = new ObjectMapper();
        String json = "";

        try {
            json = objectMapper.writeValueAsString(expenses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return chatClient
            .prompt()
            .user("faça uma análise das seguintes despesas: " + json)
            .system(sp -> sp.param("language", language))
            .call()
            .content();
    }

    
    
}
