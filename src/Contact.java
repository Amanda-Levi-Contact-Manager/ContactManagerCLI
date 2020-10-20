public class Contact {
    private String name, phoneNumber;

    public Contact(String cName, String cPhone){
        this.name = cName;
        this.phoneNumber = cPhone;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setName(String cName){
        this.name = cName;
    }

    public void setPhoneNumber(String cPhone){
        this.phoneNumber = cPhone;
    }

    public void printContact(){
        System.out.printf("%s  | \uD83D\uDCF1 %s |\n", this.name, this.phoneNumber);
        System.out.println("---------------------------------");
        System.out.println();
    }

}
