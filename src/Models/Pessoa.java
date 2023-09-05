package Models;

import java.util.UUID;

public class Pessoa {

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
        this.id = UUID.randomUUID();
    }

    public Pessoa (UUID id, String nome, String documento){
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }
    
    private final UUID id;
    private String nome;
    private final String documento;

    public UUID getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public boolean validaDocumento(String documento){
        return true;
    }
    
}
