package DatabaseConnection;

import BusinessLogic.Criminal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CriminalDB {

    private Connection con;

    public CriminalDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mugshot identification database", "root", "123");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /*getNextID() method is for creating next criminal id. 
     so user does not need to enter the criminal id explicitly.
     System automatically generates it.This avoids entering duplicate id*/
    public long getNextID() {
        String st = "select MAX(criminal_id)From criminal";
        try {
            PreparedStatement ps = con.prepareStatement(st);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int i = rs.getInt(1);
                long l = i + 1;
                return l;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    public int addData(Criminal c) {
        try {
            String query = "";
            if (c.getPhotoPath().equals("")) {
                query = "INSERT INTO criminal(first_name,middle_name,last_name,gender,date_of_birth,nic,add_no,"
                        + "add_street,add_city)VALUES(?,?,?,?,?,?,?,?,?)";
            } else {
                query = "INSERT INTO criminal(first_name,middle_name,last_name,gender,date_of_birth,nic,add_no,add_street,add_city,original_photo)VALUES(?,?,?,?,?,?,?,?,?,?)";
            }
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getFirst_name());
            ps.setString(2, c.getMiddle_name());
            ps.setString(3, c.getLast_name());
            ps.setString(4, c.getGender());
            ps.setDate(5, c.getDob());
            ps.setString(6, c.getNic());
            ps.setString(7, c.getAddNo());
            ps.setString(8, c.getAddStreet());
            ps.setString(9, c.getAddCity());
            if (!c.getPhotoPath().equals("")) {
                File image = new File(c.getPhotoPath());
                FileInputStream fis = new FileInputStream(image);
                ps.setBinaryStream(10, (InputStream) fis, (int) (image.length()));
            }
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    //insert nick name 
    public int addNickName(int criminalID,String nickName) {
        try {
            String query = "INSERT INTO criminal_nick_name(criminal_id,nick_name)VALUES(?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,criminalID);
            ps.setString(2,nickName);            
            
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    public ArrayList<Integer> getAllCriminalIds(String type){
         ArrayList<Integer> v=new ArrayList<>();
        try {
            String selectQuery="select criminal_id from offense_criminal where offense_id in"+
                    "(select offense_id from offense where type_id in (select type_id from offense_type where type='"+type+"'))";
            PreparedStatement ps=con.prepareStatement(selectQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               int criminalID=rs.getInt("criminal_id");               
               v.add(criminalID);
            }
            ps.close();
            rs.close();
            return v;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }   
    }
    
    public ArrayList<Integer> getAllCriminalIDS(){
         ArrayList<Integer> v=new ArrayList<>();
        try {
            String selectQuery="select criminal_id from criminal";
            PreparedStatement ps=con.prepareStatement(selectQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               int criminalID=rs.getInt("criminal_id");               
               v.add(criminalID);
            }
            ps.close();
            rs.close();
            return v;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }   
    }
    
    public Criminal getCriminalDetailsAccordingToID(int id){
       Criminal c=null;
        try {
            String selectQuery="select first_name,middle_name,last_name,gender,date_of_birth,nic,add_no,add_street,add_city from criminal where criminal_id='"+id+"'";
            PreparedStatement ps=con.prepareStatement(selectQuery);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
              c=new Criminal();
              c.setCriminal_id(id);
              c.setFirst_name(rs.getString("first_name"));
              c.setMiddle_name(rs.getString("middle_name"));
              c.setLast_name(rs.getString("last_name"));
              if(rs.getString("gender").equals("M")){
                 c.setGender("Male");
              }else{
                 c.setGender("Female");
              } 
              c.setDob(rs.getDate("date_of_birth"));
              c.setNic(rs.getString("nic"));
              c.setAddNo(rs.getString("add_no"));
              c.setAddStreet(rs.getString("add_street"));
              c.setAddCity(rs.getString("add_city"));
            }
            return c;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }       
    }

}
