package BusinessLogic;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Offense {
    private int offenseId;
    private ArrayList<Integer> criminalID;
    private String description;
    private Timestamp offenseDate;
    private int offenseTypeID;

    public Offense() {
    }

    public Offense(String description, Timestamp offenseDate, int offenseTypeID) {         
        this.description = description;
        this.offenseDate = offenseDate;
        this.offenseTypeID = offenseTypeID;
    }

    public void setCriminalID(ArrayList<Integer> criminalID) {
        this.criminalID = criminalID;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOffenseDate(Timestamp offenseDate) {
        this.offenseDate = offenseDate;
    }

    public void setOffenseId(int offenseId) {
        this.offenseId = offenseId;
    }

    public void setOffenseTypeID(int offenseTypeID) {
        this.offenseTypeID = offenseTypeID;
    }

    

    public ArrayList<Integer> getCriminalID() {
        return criminalID;
    }    

    public String getDescription() {
        return description;
    }

    public Timestamp getOffenseDate() {
        return offenseDate;
    }

    public int getOffenseId() {
        return offenseId;
    }

    public int getOffenseTypeID() {
        return offenseTypeID;
    }

        
    
}
