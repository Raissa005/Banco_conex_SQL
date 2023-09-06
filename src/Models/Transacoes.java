package Models;

import Models.Transacoes.tipo;
import java.util.Date;
import java.util.UUID;

public class Transacoes {

    private final UUID id;
    private final Date data;
    private final tipo tipoTrans;
    private final double valor;
    private final UUID conta_id;
    
    public Transacoes (UUID id, Date data, tipo  tipoTrans, double valor, UUID conta_id) {     
            this.id = UUID.randomUUID();
            this.data = new Date();
            this.tipoTrans = tipoTrans;
            this.valor = valor;
            this.conta_id = UUID.randomUUID();
    }  
    
    public enum tipo{
         deposito,
         saque,
         envio,
         recebimento
    }
    
    public enum tipoEnum { 
          deposito(1), saque(2), envio(3), recebimento(4);
		
          public int tipoEnum;
          tipoEnum(int valorOpcao){
                    tipoEnum = valorOpcao;
          }
     }
    
    public tipo getTipoTrans() {
        return tipoTrans;
    }

    public UUID getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public UUID getConta_id() {
        return conta_id;
    }
    
    
}
