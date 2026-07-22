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
import model.AblVenda;

public class DaoVenda extends DaoAbstract {

    private Connection conexao;

    public DaoVenda() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/root";
            String usuario = "root";
            String senha = "";

            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }
    }

    // Converte uma linha do ResultSet em um objeto AblVenda
    private AblVenda montarVenda(ResultSet resultado) throws SQLException {

        AblVenda registro = new AblVenda();

        registro.setIdPedido(resultado.getInt("id_pedido"));
        registro.setData(resultado.getDate("data"));
        registro.setTotal(resultado.getDouble("total"));
        registro.setIdCliente(resultado.getInt("id_cliente"));
        registro.setIdVendedor(resultado.getInt("id_vendedor"));

        return registro;
    }

    @Override
    public boolean insert(Object object) {

        AblVenda registro = (AblVenda) object;

        String comando = "INSERT INTO venda(data,total,id_cliente,id_vendedor) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setDate(1, new java.sql.Date(registro.getData().getTime()));
            ps.setDouble(2, registro.getTotal());
            ps.setInt(3, registro.getIdCliente());
            ps.setInt(4, registro.getIdVendedor());

            ps.executeUpdate();

            return true;

        } catch (SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }

        return false;
    }

    @Override
    public void update(Object object) {

        AblVenda registro = (AblVenda) object;

        String comando = "UPDATE venda SET data=?, total=?, id_cliente=?, id_vendedor=? WHERE id_pedido=?";

        try {

            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setDate(1, new java.sql.Date(registro.getData().getTime()));
            ps.setDouble(2, registro.getTotal());
            ps.setInt(3, registro.getIdCliente());
            ps.setInt(4, registro.getIdVendedor());
            ps.setInt(5, registro.getIdPedido());

            ps.executeUpdate();

        } catch (SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }
    }

    @Override
    public void delete(Object object) {

        AblVenda registro = (AblVenda) object;

        String comando = "DELETE FROM venda WHERE id_pedido=?";

        try {

            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setInt(1, registro.getIdPedido());

            ps.executeUpdate();

        } catch (SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }
    }

    @Override
    public Object list(int id) {

        AblVenda venda = null;

        String comando = "SELECT * FROM venda WHERE id_pedido=?";

        try {

            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                venda = montarVenda(resultado);
            }

        } catch (SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }

        return venda;
    }

    @Override
    public Object listAll() {

        List<AblVenda> vendas = new ArrayList<>();

        String comando = "SELECT * FROM venda";

        try {

            PreparedStatement ps = conexao.prepareStatement(comando);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                vendas.add(montarVenda(resultado));

            }

        } catch (SQLException erro) {

            Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, erro);

        }

        return vendas;
    }

}