package br.com.guilherme.domain.repository;

import br.com.guilherme.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    public static String INSERT = "insert into cliente (nome) values (?) ";
    public static String SELECTALL = "select * from cliente ";
    public static String SELECT_POR_NOME = "select * from cliente where nome like ?";
    public static String UPDATE = "update cliente set nome = ? where id = ? ";
    public static String DELETE = "delete from cliente where id = ? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECTALL, obterClienteMapper());
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_POR_NOME, new Object[]{"%" + nome + "%"}, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getInt("id"), resultSet.getString("nome"));
            }
        };
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(),cliente.getId()
        });
        return cliente;
    }

    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }
}
