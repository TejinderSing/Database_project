/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.Container;
import java.awt.PopupMenu;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Happy
 */
public class Search extends JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
//    JTable jtbl = new JTable(model);
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    
    public Search(){
    
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        } catch (SQLException e) {
            msg ss=new msg();
            JOptionPane.showMessageDialog(ss, e);
        }
    
    }
    
    public void show(String id, String b) throws SQLException {


        try {
            Show_books ss = new Show_books();
            ss.setVisible(true);
            DefaultTableModel model1 = (DefaultTableModel)ss.jTable1.getModel();
            
            
            stmt = con.prepareStatement("select * from book where "+b+"=?");
            stmt.setInt(1, Integer.parseInt(id));
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                   
                model1.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5)});

            }
        
        stmt.execute();
         
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
            }
    
    public  void showall() {
        try {
            Show_books ss = new Show_books();
            ss.setVisible(true);
            DefaultTableModel model1 = (DefaultTableModel)ss.jTable1.getModel();
            stmt = con.prepareStatement("select * from book");
            rs = stmt.executeQuery();
          
            while(rs.next()){
                   
                model1.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5)});

            }
        
        stmt.execute();
        
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void show1(String id) throws SQLException{
        Update_data ss = new Update_data();
            ss.setVisible(true);
       
            
            
            stmt = con.prepareStatement("select * from book where book_id=?");
            stmt.setInt(1, Integer.parseInt(id));
            rs = stmt.executeQuery();
            
          
             if (rs.next()) {
                ss.jTextField1.setText(String.valueOf(rs.getInt(1)));
                ss.jTextField2.setText(rs.getString(2));
                ss.jTextField3.setText(rs.getString(3));
                ss.jTextField4.setText(rs.getString(4));
                ss.jTextField5.setText(String.valueOf(rs.getInt(5)));
             }
             else{
                 JOptionPane.showMessageDialog(ss, "no info");
             }
        stmt.execute();
         
        }
    
        public void shows(String data, String column){
           
            try {
            Show_books ss = new Show_books();
            ss.setVisible(true);
            DefaultTableModel model1 = (DefaultTableModel)ss.jTable1.getModel();
            
            
            stmt = con.prepareStatement("select * from book where "+column+"=?");
            stmt.setString(1, data);
            rs = stmt.executeQuery();
            
          
            while(rs.next()){
                   
                model1.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5)});
              
            }
           
        
        stmt.execute();
         
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
             
        }
    }        

  

