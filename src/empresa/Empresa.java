/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

/**
 *
 * @author Aluno
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Crud cr = new Crud();
       cr.Conectar();
       Principal x = new Principal();
       x.show();
       
    }
    
}
