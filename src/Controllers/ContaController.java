package Controllers;

//import DAO.postGres.contaDaoPostgres;
import static Factory.factoryDAO.makeContaDao;
import Models.Conta;
import Models.ContaCorrente;
import Models.ContaPoupanca;
import Models.ContaSalario;
import Models.Pessoa;
//mport Util.GerenciadorConexao;
import javax.swing.JOptionPane;
import semana05.Semana05;

public class ContaController {

    public int criarConta(Pessoa titular, boolean corrente, boolean poupanca, boolean salario, String senha) {
        Conta conta = corrente ? new ContaCorrente(titular, senha) : poupanca ? new ContaPoupanca(titular, senha) : new ContaSalario(titular, senha);
         makeContaDao().insereConta(conta);
          return conta.getNumero();
    }

    public Conta buscarContaPoTitular(String documento) {
       
           return makeContaDao().buscarContaPorTitular(documento);
         
    }
    
    public Conta buscarPorNumero(int numero) {
        for (Conta conta : Semana05.banco) {
            if (numero == conta.getNumero()) {
               return conta;
            } 
        }
        return null;
    }

    public Conta depositar(Conta conta, double valor) {
        if (valor > 0) {
            conta.depositar(valor);
        } else {
            JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO PARA DEPOSITO!");
        }
        return conta;
    }

    public Conta sacar(Conta conta, double valor) {
        if (valor <= conta.getSaldo() && valor > 0) {
            conta.sacar(valor);
        } else {
            JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO OU INSUFICIENTE PARA SAQUE!");
        }
        return conta;
    }

    public Conta transferir(Conta conta, Conta destinatario, double valor) {

        if (conta.getSaldo() >= valor && valor > 0) {
            conta.transferir(destinatario, valor);
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido.");
        }

        return conta;
    }
    
    public Conta transacao(UUID id, Date, data, enum tipo, String valor, UUID id_conta){
        
    }
}
