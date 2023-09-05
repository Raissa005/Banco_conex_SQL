package DAO;

import Models.Conta;

public interface contaDao {
    public void insereConta(Conta conta);
    public Conta buscarContaPorTitular(String documento);
        
   public void atualizaSaldo(Conta conta);
}
