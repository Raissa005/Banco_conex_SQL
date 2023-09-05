package Controllers;

//import DAO.postGres.PessoaDaoPostgres;
import static Factory.factoryDAO.makePessoaDao;
import Models.Pessoa;
import Models.PessoaFisica;
import Models.PessoaJuridica;
//import Util.GerenciadorConexao;

public class PessoaController {
    
    public Pessoa criarPessoa(String nome, String documento, String tipo){       
        Pessoa pessoa = null;
        
        if(tipo.equals("Pessoa Física")){
            pessoa =  new PessoaFisica(nome, documento);
        } else{
            pessoa =  new PessoaJuridica(nome, documento);
        }
        makePessoaDao().inserirPessoa(pessoa);
          return pessoa;

    }
}
