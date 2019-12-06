package DatabaseConnection;

import BusinessLogic.OffenseType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;


public class OffenseTypeDB {
    
private Connection con=null;

    public OffenseTypeDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mugshot identification database", "root", "123");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //get all the offense type
    public Vector getAllOffenseTypes(){
       Vector v=new Vector();
        try {
            String selectQuery="select type from offense_type";
            PreparedStatement ps=con.prepareStatement(selectQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               String type=rs.getString("type");
               v.add(type);
            }
            ps.close();
            rs.close();
            return v;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }       
    }
    
    public int addData(OffenseType c) {
        try {            
            String query = "INSERT INTO offense_type(type)VALUES(?)";            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getType());           
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Entering Data!","Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
    public long getNextID() {
        String st = "select MAX(type_id)From offense_type";
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
    
    public int getTypeIdAccordingToType(String type) throws SQLException {
        int typeID = 0;

        String selectQuery = "select type_id from offense_type where type='" + type + "'";
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            typeID = rs.getInt("type_id");
        }
        ps.close();
        rs.close();

        return typeID;
    }
    
    public String getTypeAccordingToTypeID(int typeID){
        String type="";
        try {
            String selectQuery = "select type from offense_type where type_id='" + typeID + "'";
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            type = rs.getString("type");
        }
        ps.close();
        rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        

        return type;
    }
    
}
