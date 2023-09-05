package DAO.postGres;

import DAO.PessoaDAO;
import Models.Pessoa;
import Models.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PessoaDaoPostgres implements PessoaDAO  {

    private final Connection conexao;
    
    public PessoaDaoPostgres (Connection conexao){
        this.conexao = conexao;
    }

    public PessoaDaoPostgres() {
        this.conexao = null;
    }
    
    @Override
    public void inserirPessoa(Pessoa pessoa) {
        
          try{
             String sql = "INSERT INTO pessoa (id, nome, documento, tipo) VALUES (?, ?, ?, CAST(? as tipo_pessoa))";
                     String tipoPessoa = (pessoa instanceof  PessoaFisica) ?  "PF" : "PJ";
                     
                     PreparedStatement stm = this.conexao.prepareStatement(sql);
                     stm.setObject(1, pessoa.getId());
                     stm.setObject(2, pessoa.getNome());
                     stm.setObject(3, pessoa.getDocumento());
                     stm.setObject(4, tipoPessoa );
                     stm.executeUpdate();
                     
         }catch (SQLException error){
              System.out.println("Erro!");
             System.out.println(error);
         }
    }
    
    @Override
    public Pessoa obterPessoaPeloId(UUID id) {
        return null;
    }
}