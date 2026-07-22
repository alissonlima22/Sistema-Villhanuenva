/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AblCliente;

/**
 *
 * @author Alisson
 */
public class DaoClientes extends DaoAbstract {

    Connection cnt;

    public DaoClientes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url, user, password;
            url = "jdbc:mysql://localhost:3306/root";
            user = "root";
            password = "";

            cnt = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {

        AblCliente cliente = (AblCliente) object;

        try {
            String sql = "INSERT INTO cliente(nome, cpf, email, telefone) VALUES (?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefone());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }

    @Override
public void update(Object object) {
    try {
        AblCliente cliente = (AblCliente) object;

        String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=? WHERE id_cliente=?";

        PreparedStatement pst = cnt.prepareStatement(sql);

        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getEmail());
        pst.setString(4, cliente.getTelefone());
        pst.setInt(5, cliente.getId_cliente());

        pst.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(DaoClientes.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void delete(Object object) {
        AblCliente cliente = (AblCliente) object;
        String sql = "DELETE FROM cliente WHERE id_cliente=?";

        try {
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, cliente.getId_cliente());
            smt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
        
    }

    @Override
    public Object list(int id) {
        AblCliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id_cliente=?";

        try {
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, id);
            ResultSet resp = smt.executeQuery();

            if (resp.next()) {
                cliente = new AblCliente();

                cliente.setId_cliente(resp.getInt("id_cliente"));
                cliente.setNome(resp.getString("nome"));
                cliente.setCpf(resp.getString("cpf"));
                cliente.setEmail(resp.getString("email"));
                cliente.setTelefone(resp.getString("telefone"));
               
            }

        } catch (SQLException ex) {
            return null;
        }

        return cliente;
    }

    @Override
    public Object listAll() {
        List lista = new ArrayList();
        String sql = "SELECT * FROM cliente";
        
        try {
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet resp = smt.executeQuery();

            while (resp.next()) {
                AblCliente cliente = new AblCliente();
                cliente.setId_cliente(resp.getInt("id_cliente"));
                cliente.setNome(resp.getString("nome"));
                cliente.setCpf(resp.getString("cpf"));
                cliente.setEmail(resp.getString("email"));
                cliente.setTelefone(resp.getString("telefone"));
                lista.add(cliente);
               
            }

        } catch (SQLException ex) {
            return null;
        }

        return lista;
    }
}
