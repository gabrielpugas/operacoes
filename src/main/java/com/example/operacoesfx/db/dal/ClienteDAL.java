package com.example.operacoesfx.db.dal;

import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.entidades.Cliente;
import com.example.operacoesfx.db.util.DBSingleton;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAL implements IDAL<Cliente> {
    @Override
    public boolean gravar(Cliente entidade) {
        return false;
    }

    @Override
    public boolean alterar(Cliente entidade) {
        return false;
    }

    @Override
    public boolean apagar(Cliente entidade) {
        return false;
    }

    @Override
    public Cliente get(int id) {
        return null;
    }

    @Override
    public List<Cliente> get(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        String sql="select * from cliente";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by cli_nome";
        ResultSet rs= DBSingleton.getCon().consultar(sql);
        try {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("cli_id"),rs.getString("cli_nome"),
                                         rs.getLong("cli_documento"),rs.getInt("cli_cep"),
                                         rs.getString("cli_endereco"),rs.getString("cli_numero"),
                                         rs.getString("cli_cidade"),rs.getString("cli_uf"),
                                         rs.getString("cli_bairro"),rs.getString("cli_fone"),
                                         rs.getString("cli_email"),rs.getDouble("cli_juros")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return clientes;
    }
}
