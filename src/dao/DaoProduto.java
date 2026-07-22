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
import javax.swing.JOptionPane;
import model.AblProduto;

public class DaoProduto extends DaoAbstract {

    private Connection conexao;

    public DaoProduto() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/root";
            String usuario = "root";
            String senha = "";

            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null,
                    "Erro na conexão com o banco:\n" + erro.getMessage());

        }
    }

    // Cria um objeto Produto a partir do ResultSet
    private AblProduto montarProduto(ResultSet rs) throws SQLException {

        AblProduto item = new AblProduto();

        item.setId_produto(rs.getInt("id_produtos"));
        item.setDescricao(rs.getString("descricao"));
        item.setTipo(rs.getString("tipo"));
        item.setUnidade(rs.getString("unidade"));
        item.setPreco(rs.getDouble("preco"));

        return item;
    }

    @Override
    public boolean insert(Object object) {

        AblProduto item = (AblProduto) object;

        String sql = "INSERT INTO produtos(descricao,tipo,unidade,preco) VALUES(?,?,?,?)";

        try {

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, item.getDescricao());
            comando.setString(2, item.getTipo());
            comando.setString(3, item.getUnidade());
            comando.setDouble(4, item.getPreco());

            comando.executeUpdate();

            return true;

        } catch (SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);

        }

        return false;
    }

    @Override
    public void update(Object object) {

        AblProduto item = (AblProduto) object;

        String sql = "UPDATE produtos SET descricao=?, tipo=?, unidade=?, preco=? WHERE id_produtos=?";

        try {

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, item.getDescricao());
            comando.setString(2, item.getTipo());
            comando.setString(3, item.getUnidade());
            comando.setDouble(4, item.getPreco());
            comando.setInt(5, item.getId_produto());

            comando.executeUpdate();

        } catch (SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);

        }
    }

    @Override
    public void delete(Object object) {

        AblProduto item = (AblProduto) object;

        String sql = "DELETE FROM produtos WHERE id_produtos=?";

        try {

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, item.getId_produto());

            comando.executeUpdate();

        } catch (SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);

        }
    }

    @Override
    public Object list(int id) {

        AblProduto produto = null;

        String sql = "SELECT * FROM produtos WHERE id_produtos=?";

        try {

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {

                produto = montarProduto(resultado);

            }

        } catch (SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);

        }

        return produto;
    }

    @Override
    public Object listAll() {

        List<AblProduto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try {

            PreparedStatement comando = conexao.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {

                produtos.add(montarProduto(resultado));

            }

        } catch (SQLException erro) {

            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, erro);

        }

        return produtos;
    }

}