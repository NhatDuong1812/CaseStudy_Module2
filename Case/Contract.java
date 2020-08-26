package Case;

import java.io.Serializable;

public class Contract implements Serializable {
    private String phoneNumber;
    private int id;
    private String name;
    private String lop;
    private String address;
    private String dateOfBirth;
    private String emailAdress;

    public Contract() {
    }

    public Contract(String phoneNumber, int id, String name, String lop, String address, String dateOfBirth, String emailAdress) {
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.name = name;
        this.lop = lop;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        //return " Phone: " + getPhoneNumber() + "\n" + " ID: " + getId() + "\n" + " Name: " + getName() + "\n" + " Class: " + getLop() + "\n" + " Address: " + getAddress() + "\n";
        return " ID: " + getId() + "\n" + " Name: " + getName() + "\n" + " Ngày Sinh: " + getDateOfBirth() + "\n" + " Class: " + getLop() + "\n" + " Address: " + getAddress() + "\n" + " Phone: " + getPhoneNumber() + "\n" + " Email: " + getEmailAdress() + "\n";
    }

//    @Override
//    public String toString() {
//        return "Phone: " +
//                "phoneNumber='" + phoneNumber + '\'' +
//                ", groupName='" + groupName + '\'' +
//                ", name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", address='" + address + '\'' +
//                ", dateOfBirth='" + dateOfBirth + '\'' +
//                ", emailAdress='" + emailAdress + '\'' +
//                '}';
//
//    }
}



