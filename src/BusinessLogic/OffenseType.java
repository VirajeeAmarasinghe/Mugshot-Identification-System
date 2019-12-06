package BusinessLogic;


public class OffenseType {
    private int offenseTypeID;
    private String type;
    

    public OffenseType() {
    }

    public OffenseType(int offenseID, String type) {
        this.offenseTypeID = offenseID;
        this.type = type;
    }

    public void setOffenseID(int offenseID) {
        this.offenseTypeID = offenseID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffenseID() {
        return offenseTypeID;
    }

    public String getType() {
        return type;
    }    
    
}
