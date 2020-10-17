

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String cName, String cPhone){
        this.name = cName;
        this.phoneNumber = cPhone;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getFullContact(){
        String fullContact = getName() + " " + getPhoneNumber();
        return fullContact;
    }

//    public void printContact(){
//        System.out.printf("%s  | \uD83D\uDCF1 %s |\n", this.name, this.phoneNumber);
//    }

}
