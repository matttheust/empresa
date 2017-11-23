/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author EtecAB
 */
public class Crud {
   Connection conexao;
    private Object resultSet;
              public void Conectar(){
          String driver = "com.mysql.jdbc.Driver";
          String url = "jdbc:mysql://localhost/empresa";
          
       
              try{
                  conexao = (Connection) DriverManager.getConnection(url,"root","1234");
                  JOptionPane.showMessageDialog(null, "CONECTADO COM SUCESSO");
                  
              } 
     
              catch(SQLException ex){
                  JOptionPane.showMessageDialog(null, "Erro no banco: " + ex);
              }  
              
              catch(Exception x){
                  JOptionPane.showMessageDialog(null, "Erro generico: " + x);
             
              }
              
      }
     
      public void cadastrarFuncionario(String nome, String prNome,String ulNome, String dtAdmissao) throws Exception{
          PreparedStatement p = conexao.prepareStatement("insert into tb_funcionario"
                  + "(nm_funcionario , pr_nome, ul_nome, dt_admissao)"
                  + " values (?,?,?,?)");
              p.setString(1, nome);
              p.setString(2, prNome);
              p.setString(3, ulNome);
              p.setString(4, dtAdmissao);              
              p.executeUpdate();
              p.close();
            }
      public void cadastrarFuncao(String nome, Double salario,Boolean estComissao) throws Exception{
          PreparedStatement p = conexao.prepareStatement("insert into tb_funcao"
                  + "(nm_funcao , sal_funcao, est_comissao)"
                  + " values (?,?,?)");
              p.setString(1, nome);
              p.setDouble(2, salario);
              p.setBoolean(3, estComissao);
                          
              p.executeUpdate();
              p.close();
            }
      public void cadastrarDepartamento(String nome, String descricao) throws Exception{
          PreparedStatement p = conexao.prepareStatement("insert into tb_departartamento"
                  + "(nm_dpto , ds_localizacao)"
                  + " values (?,?)");
              p.setString(1, nome);
              p.setString(2, descricao);                            
              p.executeUpdate();
              p.close();
            }
      
      public void alterarFuncionario(String nome, String prNome,String ulNome, String dtAdmissao, String cod) throws SQLException{
    PreparedStatement p = conexao.prepareStatement("update tb_funcionario set nm_funcionario=? , pr_nome=?, ul_nome=?"
           + ", dt_admissao=? where cd_funcionario=?;");
         p.setString(1, nome);
         p.setString(2, prNome);
         p.setString(3, ulNome);
         p.setString(4, dtAdmissao);
         p.setString(5, cod);
         p.executeUpdate();
         p.close();            
    }
    public void alterarFuncao(String nome, Double salario,Boolean estComissao, String cod) throws SQLException{
    PreparedStatement p = conexao.prepareStatement("update tb_funcao set nm_funcao=? , "
            + "sal_funcao=?, est_comissao=? where cd_funcao=?;");
         p.setString(1, nome);
         p.setDouble(2, salario);
         p.setBoolean(3, estComissao);
         p.setString(4, cod);
         p.executeUpdate();
         p.close();            
    }
    public void alterarDepartamento(String nome, String descricao, String cod) throws SQLException{
    PreparedStatement p = conexao.prepareStatement("update tb_departartamento set nm_dpto=?"
            + " , ds_localizacao=? where cd_dpto=?;");   
        p.setString(1, nome);
        p.setString(2, descricao);                           
        p.setString(3, cod);
        p.executeUpdate();
        p.close();            
    }
    
    
    public void deletarFuncionario(String codigo) throws SQLException{
   PreparedStatement p = conexao.prepareStatement("delete from tb_funcionario where cd_funcionario=?;");        
         p.setString(1,codigo);
         p.executeUpdate();
         p.close();    
    }
     public void deletarFuncao(String codigo) throws SQLException{
   PreparedStatement p = conexao.prepareStatement("delete from tb_funcao where cd_funcao=?;");        
         p.setString(1,codigo);
         p.executeUpdate();
         p.close();    
    }
      public void deletarDepartamento(String codigo) throws SQLException{
   PreparedStatement p = conexao.prepareStatement("delete from tb_departartamento where cd_dpto=?;");        
         p.setString(1,codigo);
         p.executeUpdate();
         p.close();    
    }
      
    public String consultar(){
        String sql = "select * from empresa where cd_cadastro =;";
        String texto="<html><table border=1><tr><td>Código</td><td>Nome</td><td>Nota</td></tr></html>";

    Statement statement;
           try {
               statement = conexao.createStatement();
               ResultSet resultSet = statement. executeQuery(sql);
    while(resultSet.next()){
         String codigo = resultSet.getString ("cd_aluno");
         String nome = resultSet.getString ("nm_aluno");
         String nota = resultSet.getString ("nm_nota");
         texto +="<tr><td>"+codigo+"</td><td>"+nome+"</td><td>"+nota+"</td></tr>";
        }
         texto +="</table></html>";
         resultSet.close();
        }catch (SQLException ex) {
         Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }   
           return texto;
        }
}
