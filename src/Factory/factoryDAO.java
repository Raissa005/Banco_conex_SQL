/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DAO.PessoaDAO;
import DAO.contaDao;
import DAO.postGres.PessoaDaoPostgres;
import DAO.postGres.contaDaoPostgres;
import Util.GerenciadorConexao;
import java.sql.Connection;

public class factoryDAO {
   public static contaDao makeContaDao(){
        Connection conexao = GerenciadorConexao.getConexao();
        contaDaoPostgres contaDao = new contaDaoPostgres(conexao);
        return contaDao;
    }
    public static PessoaDAO makePessoaDao(){
        Connection conexao = GerenciadorConexao.getConexao();
        PessoaDaoPostgres pessoaDao = new PessoaDaoPostgres(conexao);
        return pessoaDao;
    }
    
}
