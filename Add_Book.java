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
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Happy
 */
public class Add_Book {
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Calendar ca = Calendar.getInstance();
    String book_id = "", title = "", author = "", publisher = "", published_year = "";

    public Add_Book() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
        } catch (SQLException e) {
            msg ss=new msg();
            JOptionPane.showMessageDialog(ss,e);
        }
    }
    
    
    
    public void assign(String id, String book_title, String book_author, String book_publisher,String book_pub_year) {
        book_id = id;
        title = book_title;
        author = book_author;
        publisher = book_publisher;
        published_year = book_pub_year;
    
        try {
            stmt = con.prepareStatement("insert into book value(?,?,?,?,?)");
            stmt.setInt(1, Integer.parseInt(book_id));
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publisher);
            stmt.setInt(5, Integer.parseInt(published_year));

            stmt.execute();
        } catch (SQLException | NullPointerException el) {
            Add_new_book ss = new Add_new_book();
            JOptionPane.showMessageDialog(ss, el);
        }


        Add_new_book ss = new Add_new_book();
        ss.setVisible(true);
        JOptionPane.showMessageDialog(ss, "done");

    }
    
    public void update(int id, String title, String author, String publisher, int year) {
        Update_data ss = new Update_data();
        try {
            stmt = con.prepareStatement("update book set title=?,"+" author=?,"+" publisher=?,"+" published_year=?,"+"  where book_id=?");
           stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, publisher);
            stmt.setInt(4, year);
           
            stmt.setInt(5, id);
            stmt.execute();
            
            
            ss.setVisible(true);
        
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(ss, "error "+e);
             
        }
    }
    }

