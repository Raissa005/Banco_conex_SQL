package DAO.postGres;

import DAO.contaDao;
import Models.ContaCorrente;
import Models.ContaSalario;
import java.sql.Connection;
import Models.Conta;
import Models.Pessoa;
import Models.PessoaFisica;
import Models.PessoaJuridica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class contaDaoPostgres implements contaDao {
    
        private final Connection conexao;

        public contaDaoPostgres(Connection conexao){
            this.conexao = conexao;
        }
        
        public void insereConta(Conta conta){
            String sql = "INSERT INTO conta(id, numero, saldo, tipo, pessoa_id, senha) VALUES (?, ?, ?, CAST(? as tipo_conta), ?, ?)";
          
            String tipoConta = (conta instanceof ContaCorrente) ?  "corrente" : (conta instanceof ContaSalario) ? "salario" : "poupanca";
            
            try{
                PreparedStatement stm = this.conexao.prepareStatement(sql);
                stm.setObject(1, conta.getId());
                stm.setInt(2, conta.getNumero());
                stm.setDouble(3, conta.getSaldo());
                stm.setString(4, tipoConta);
                stm.setObject(5, conta.getTitular().getId());
                stm.setString(6, conta.getSenha());
                stm.executeUpdate();
            }catch(SQLException error) {
                System.out.println(error);
            }
        }
        
     //   public void buscarContaPorTitular(String documento)
       // }

    @Override
    public Conta buscarContaPorTitular(String documento) {
        String sql = "SELECT c.id, c.numero, c.saldo, c.tipo, c.pessoa_id, c.senha, p.nome, p.tipo AS pessoa_tipo FROM conta AS c JOIN pessoa AS p ON c.pessoa_id = p.id WHERE p.documento = ?";
        
        try{
            PreparedStatement stm = this.conexao.prepareStatement(sql);
            stm.setString(1, documento);
            
            ResultSet resultado =  stm.executeQuery();
            
            if(resultado.next()){
                UUID id = resultado.getObject("pessoa_id", UUID.class);
                String nome = resultado.getString("nome");
                String tipo = resultado.getString("pessoa_tipo");
                Pessoa pessoa = (tipo.equals("PF")) ? new PessoaFisica(id, nome, documento) : new PessoaJuridica(id, nome, documento);
                
                UUID idConta = resultado.getObject("id", UUID.class);
                int numero = resultado.getInt("numero");
                double saldo = resultado.getDouble("saldo");
                String tipoC = resultado.getString("tipo");
                String senha = resultado.getString("senha");
                
                switch(tipoC){
                    case "corrente":
                        return new ContaCorrente(idConta, numero, saldo, pessoa, senha);
                    case "poupanca":
                        return new ContaSalario(idConta, numero, saldo , pessoa, senha);
                    case "salario":
                        return new ContaSalario(idConta, numero, saldo, pessoa, senha);
                    default:
                        return null;
                }
            }
        } catch (SQLException error) {
                System.out.println(error);
            }
        return null;
    }

    @Override
    public void atualizaSaldo(Conta conta) {
        String sql = "UPDATE conta set saldo = ? WHERE id = ? ";
            
            try{
                PreparedStatement stm = this.conexao.prepareStatement(sql);
                stm.setDouble(1, conta.getSaldo());
                stm.setObject(2, conta.getId());
                stm.executeUpdate();
            }catch(SQLException error) {
                System.out.println(error);
            }
    }
    
    public void insereExtrato(UUID id, Date data, enum tipo, String valor, UUID id_conta){
            String sql = "INSERT INTO transacao(id, data, tipo, valor, id_conta) VALUES (?, ?, ?, CAST(? as tipo_conta), ?, ?)";

            try{
                PreparedStatement stm = this.conexao.prepareStatement(sql);
                stm.setObject(1, transacoes.getId());
                stm.setInt(2, transacoes.getdata());
                stm.setDouble(3, transacoes.getTipoTrans);
                stm.setString(4, transacoes.getValor);
                stm.setObject(5, transacoes.getConta_id);
                stm.executeUpdate();
            }catch(SQLException error) {
                System.out.println(error);
            }
        }
    
    public void buscarExtrato() {
       String sql = "SELECT e.id, e.data, e.tipoTrans, e.conta_id FROM extrato AS e";

       try {
           PreparedStatement stm = this.conexao.prepareStatement(sql);
           ResultSet resultado = stm.executeQuery();

                while (resultado.next()) {
                    UUID id = (UUID) resultado.getObject("id");
                    Date data = resultado.getDate("data");
                    String tipoTrans = resultado.getString("tipoTrans");
                    UUID conta_id = (UUID) resultado.getObject("conta_id");

                    ArrayList<Transacao> listaTransacoes = new ArrayList();
                    listaTransacoes.add(id);
                    listaTransacoes.add(data);
                    listaTransacoes.add(tipoTrans);
                    listaTransacoes.add(conta_id);
                }
           
           resultado.close();
           stm.close();
       } catch (SQLException error) {
           System.out.println(error);
       }
 }


}