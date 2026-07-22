        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.AblUsuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class UsuarioDAO extends DaoAbstract {
    Connection cnt;
    public UsuarioDAO(){//metodo contrutor, nome da classe
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://localhost:3306/root";
            user = "root";
            password = "";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.getLogger(UsuarioDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(UsuarioDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    
    @Override
    public boolean insert(Object object) {
        AblUsuarios mpvUsuarios = (AblUsuarios) object;
        try {
            String sql = "insert into mpv_usuarios(mpv_nome,mpv_apelido,mpv_cpf,"
                    + "mpv_dataNascimento, mpv_nivel,mpv_senha,mpv_ativo) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            //pst.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4, (Date) mpvUsuarios.getMpvDataNascimento());
            pst.setInt(5, mpvUsuarios.getMpvNivel()+1);
            pst.setString(6, mpvUsuarios.getMpvSenha());
            pst.setString(7, mpvUsuarios.getMpvAtivo());
            pst.executeUpdate();            
      
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public void update(Object object) {
     
        try {
            AblUsuarios usuario = (AblUsuarios) object;
            String sql = "UPDATE mpv_usuarios SET mpv_nome=?, mpv_apelido=?,"
                    + "mpv_cpf=?, mpv_dataNascimento=?, mpv_nivel=?, "
                    + "mpv_senha=?, mpv_ativo=? WHERE mpv_idusuarios=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, usuario.getMpvNome());
            pst.setString(2, usuario.getMpvApelido());
            pst.setString(3, usuario.getMpvCpf());
            pst.setDate(4, (Date) usuario.getMpvDataNascimento());
            pst.setInt(5, usuario.getMpvNivel());
            pst.setString(6, usuario.getMpvSenha());
            pst.setString(7, usuario.getMpvAtivo());
            pst.setInt(8, usuario.getMpvIdUsuarios());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(UsuarioDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        
        
    }

    @Override
    public void delete(Object object) {
        AblUsuarios usuario = (AblUsuarios) object;
        String sql = "DELETE FROM mpv_usuarios WHERE  mpv_idusuarios=?";   
        try {    
            PreparedStatement smt =  cnt.prepareStatement(sql);
            smt.setInt(1, usuario.getMpvIdUsuarios());
            smt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " 
                    + e.getMessage());
        }
    }

    @Override
    public Object list(int id) {
        AblUsuarios usuario = null;
        String sql = "SELECT * FROM mpv_usuarios WHERE mpv_idusuarios=?";
            
        try {    
            PreparedStatement smt =  cnt.prepareStatement(sql);
            smt.setInt(1, id);
            //import java.sql.ResultSet;
            ResultSet resp = smt.executeQuery();
            if(resp.next()){
                usuario = new AblUsuarios();
                usuario.setMpvIdUsuarios(resp.getInt("mpv_idusuarios"));
                usuario.setMpvNome(resp.getString("mpv_nome"));
                usuario.setMpvApelido(resp.getString("mpv_apelido"));
                usuario.setMpvCpf(resp.getString("mpv_cpf"));
                usuario.setMpvDataNascimento(resp.getDate("mpv_dataNascimento"));
                usuario.setMpvNivel(resp.getInt("mpv_nivel"));
                usuario.setMpvSenha(resp.getString("mpv_senha"));
                usuario.setMpvAtivo(resp.getString("mpv_ativo"));      
            }
        } catch (SQLException ex) {
            return null;
        }
         return usuario;
    }

    @Override
    public Object listAll() {
        List lista = new ArrayList(); 
        String sql = "SELECT * FROM mpv_usuarios";
        try {    
            PreparedStatement smt =  cnt.prepareStatement(sql);
            ResultSet resp = smt.executeQuery();
            while(resp.next()){
                AblUsuarios usuario = new AblUsuarios();
                usuario.setMpvIdUsuarios(resp.getInt("mpv_idusuarios"));
                usuario.setMpvNome(resp.getString("mpv_nome"));
                usuario.setMpvApelido(resp.getString("mpv_apelido"));
                usuario.setMpvCpf(resp.getString("mpv_cpf"));
                usuario.setMpvDataNascimento(resp.getDate("mpv_dataNascimento"));
                usuario.setMpvNivel(resp.getInt("mpv_nivel"));
                usuario.setMpvSenha(resp.getString("mpv_senha"));
                usuario.setMpvAtivo(resp.getString("mpv_ativo"));      
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }

}
