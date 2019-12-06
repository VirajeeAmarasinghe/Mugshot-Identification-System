package DatabaseConnection;

import BusinessLogic.Offense;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class OffenseDB {
    
    private Connection con;

    public OffenseDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mugshot identification database", "root", "123");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public long getNextID() {
        String st = "select MAX(offense_id)From offense";
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
    
    public int addOffenseIDCriminalIDs(int offenseID,int criminalID) {
        try {
            
            String query = "INSERT INTO offense_criminal(offense_id,criminal_id)VALUES(?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,offenseID);
            ps.setInt(2,criminalID);            
            
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
    
    public int addOffense(Offense o) {
        try {
            
            String query = "INSERT INTO offense(offense_description,date_and_time,type_id)VALUES(?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,o.getDescription());
            ps.setTimestamp(2,o.getOffenseDate());            
            ps.setInt(3,o.getOffenseTypeID());
            
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());            
            return 0;
        }
    }
    
    public ArrayList<Offense> getOffenseAccordingToID(int id){
        ArrayList<Offense> ar=new ArrayList<>();
        try {
            String selectQuery="select offense_id,offense_description,date_and_time,type_id "+
                    "from offense where offense_id in(select offense_id from offense_criminal where criminal_id='"+id+"')";
            PreparedStatement ps=con.prepareStatement(selectQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               Offense o=new Offense();
               o.setOffenseId(rs.getInt("offense_id"));
               o.setDescription(rs.getString("offense_description"));
               o.setOffenseDate(rs.getTimestamp("date_and_time"));
               o.setOffenseTypeID(rs.getInt("type_id"));
               ar.add(o);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error Accessing Data!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return ar;
    }
}
