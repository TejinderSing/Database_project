/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Happy
 */
public class Remove_book {
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public Remove_book() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        } catch (SQLException e) {
            msg ss=new msg();
            JOptionPane.showMessageDialog(ss, e);
        }
    }
    
    
    
    public void delete(int id){
        delete ss=new delete();
        ss.setVisible(true);
//    try {
//        stmt=con.prepareStatement("insert into remove select * from book where book_id ="+id);
//        stmt.execute();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(ss, e);
//    }
    try {
        stmt=con.prepareStatement("delete from book where book_id="+id);
        stmt.execute();
        
        JOptionPane.showMessageDialog(ss, "Record deleted");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(ss, e);
    }
    
}
    
}
