public abstract class Customer {
    private String firstName;
    private String lastName;

    public Customer (){
        this.firstName = null;
        this.lastName = null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        String fullname = getFirstName()+ " " + getLastName();
        return fullname;
    }

    public abstract void makeOrder();

    public void confirmPay(int nomorPesanan){

    }
}
