package br.com.guilherme;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MinhaConfiguration {

//    @Bean(name = "applicationName")
//    public String applicationName(){
//        return "Sistemas de Vendas";
//    }

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("rodando config de dev");
        };
    }

}
