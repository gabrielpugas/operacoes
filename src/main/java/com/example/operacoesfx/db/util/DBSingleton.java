package com.example.operacoesfx.db.util;

public class DBSingleton {
    private static Conexao con;
    public static boolean conectar()
    {
        con=new Conexao();
        return con.conectar("jdbc:postgresql://localhost:5432/",
                "operacoes","postgres","postgre123");
    }

    public static Conexao getCon() {
        return con;
    }
}
