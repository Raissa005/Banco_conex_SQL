package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    private static Connection conexao;
    
    public static Connection getConexao() {
        if(conexao == null){
            try {
                String URL = semana05.Semana05.dotenv.get("DB_URL");
                String user = semana05.Semana05.dotenv.get("DB_USER");
                String password = semana05.Semana05.dotenv.get("DB_PASSWORD");
                conexao = DriverManager.getConnection(URL, user, password);
                System.out.println("SUCESSO!");
            }catch(SQLException e){
                System.out.println("DEU RUIM");
                e.printStackTrace();
            }
        }
        return conexao;
    }
}
