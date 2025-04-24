package br.com.fiap.cash_up_api.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.fiap.cash_up_api.model.Category;
import br.com.fiap.cash_up_api.model.Transaction;
import br.com.fiap.cash_up_api.model.TransactionType;
import br.com.fiap.cash_up_api.model.User;
import br.com.fiap.cash_up_api.model.UserRole;
import br.com.fiap.cash_up_api.repository.CategoryRepository;
import br.com.fiap.cash_up_api.repository.TransactionRepository;
import br.com.fiap.cash_up_api.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        var categories = List.of(
                Category.builder().name("Educação").icon("Book").build(),
                Category.builder().name("Lazer").icon("Dices").build(),
                Category.builder().name("Saúde").icon("Heart").build(),
                Category.builder().name("Alimentação").icon("Apple").build(),
                Category.builder().name("Transporte").icon("Bus").build());

        categoryRepository.saveAll(categories);

        var descriptions = List.of(
                "Uber para casa",
                "Conta de Luz",
                "Faculdade",
                "Aluguel",
                "Supermercado",
                "Internet",
                "Cinema com amigos",
                "Compra na farmácia",
                "Assinatura do Spotify",
                "Assinatura da Netflix",
                "Academia",
                "Jantar com a família",
                "Padaria",
                "Manutenção do carro",
                "Livros da faculdade",
                "Café com colegas",
                "Roupas novas",
                "Presente de aniversário",
                "Delivery de comida",
                "Estacionamento no shopping");

        var transactions = new ArrayList<Transaction>();
        for (int i = 0; i < 50; i++) {
            transactions.add(Transaction.builder()
                    .description(descriptions.get(new Random().nextInt(descriptions.size())))
                    .amount(BigDecimal.valueOf(new Random().nextDouble() * 500))
                    .date(LocalDate.now().minusDays(new Random().nextInt(30)))
                    .type(TransactionType.EXPENSE)
                    .category(categories.get(new Random().nextInt(categories.size())))
                    .build());
        }
        transactionRepository.saveAll(transactions);

        userRepository.saveAll(List.of(
                User.builder()
                        .email("joao@fiap.com.br")
                        .password(passwordEncoder.encode("12345"))
                        .role(UserRole.ADMIN)
                        .build(),

                User.builder()
                        .email("maria@fiap.com.br")
                        .password(passwordEncoder.encode("12345"))
                        .role(UserRole.USER)
                        .build()));
    }

}
