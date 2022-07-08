package br.com.guilherme;

import br.com.guilherme.domain.entity.Cliente;
import br.com.guilherme.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Guilherme");
            clientes.salvar(cliente);

            Cliente cliente2 = new Cliente();
            cliente.setNome("Cliente2");
            clientes.salvar(cliente);

            System.out.println("Listando Clientes");
            List<Cliente> todosCliente = clientes.obterTodos();
            todosCliente.forEach(System.out::println);

            System.out.println("\nAtualizando Clientes");
            todosCliente.forEach(c ->{
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });
            todosCliente = clientes.obterTodos();
            todosCliente.forEach(System.out::println);

            System.out.println("\nBuscando Clientes por Nome");
            clientes.buscarPorNome("uilh").forEach(System.out::println);

//            clientes.obterTodos().forEach(clientes::deletar);

            System.out.println("\nListando Clientes");
            todosCliente = clientes.obterTodos();
            if(todosCliente.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosCliente.forEach(System.out::println);
            }




        };

    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
