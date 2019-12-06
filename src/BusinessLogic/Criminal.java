package BusinessLogic;

import java.sql.Date;
import java.util.ArrayList;

public class Criminal {

    private int criminal_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String gender;
    private Date dob;
    private String nic;
    private String addNo;
    private String addStreet;
    private String addCity;
    private String photoPath;
    private ArrayList<String> nickName;

    public Criminal() {
    }

    public Criminal(int criminal_id, String first_name, String middle_name, String last_name, String gender, Date dob, String nic, String addNo, String addStreet, String addCity, String photoPath) {
        this.criminal_id = criminal_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.nic = nic;
        this.addNo = addNo;
        this.addStreet = addStreet;
        this.addCity = addCity;
        this.photoPath = photoPath;
    }

    public Criminal(String first_name, String middle_name, String last_name, String gender, Date dob, String nic, String addNo, String addStreet, String addCity, String photoPath) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.nic = nic;
        this.addNo = addNo;
        this.addStreet = addStreet;
        this.addCity = addCity;
        this.photoPath = photoPath;
    }

    public void setNickName(ArrayList<String> nickName) {
        this.nickName = nickName;
    }

    public ArrayList<String> getNickName() {
        return nickName;
    }     

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public void setCriminal_id(int criminal_id) {
        this.criminal_id = criminal_id;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getAddCity() {
        return addCity;
    }

    public String getAddNo() {
        return addNo;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public int getCriminal_id() {
        return criminal_id;
    }

    public Date getDob() {
        return dob;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getGender() {
        return gender;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getNic() {
        return nic;
    }

    public String getPhotoPath() {
        return photoPath;
    }

}
