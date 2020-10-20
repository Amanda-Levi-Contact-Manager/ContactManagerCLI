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

        System.out.println();
        System.out.println("---------------------------------");
        System.out.printf("%s  | \uD83D\uDCF1 %s |\n", this.name, this.phoneNumber);
        System.out.println("---------------------------------");
        System.out.println();
    }

    public static String formatPhoneNumber(String phoneNumber){

        if (phoneNumber.length() == 7){
            String firstSet = phoneNumber.substring(0, 3);
            String secondSet = phoneNumber.substring(3);
            return String.format("%s-%s", firstSet, secondSet);
        } else if (phoneNumber.length() == 10) {
            String areaSet = phoneNumber.substring(0, 3);
            String firstSet = phoneNumber.substring(3, 6);
            String secondSet = phoneNumber.substring(6);
            return String.format("%s-%s-%s", areaSet, firstSet, secondSet);
        } else {
            return phoneNumber;
        }
    }

}
