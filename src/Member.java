import java.time.LocalDate;
import java.time.Period;
public class Member extends Customer{
    private LocalDate joinDate;
    private String idNumber;
    private Order pesanan;

    public Member(){
        joinDate = null;
        idNumber = null;
    }

    public void setJoinDate() {
        this.joinDate = LocalDate.of(Integer.parseInt(idNumber.substring(0,4)),
                Integer.parseInt(idNumber.substring(4,6)),
                Integer.parseInt(idNumber.substring(6)));
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Order getPesanan() {
        return pesanan;
    }

    @Override
    public void makeOrder() {
        pesanan = new Order();
    }
    public int joinTime (){
        Period diff = Period.between(joinDate,LocalDate.now());
        return diff.getDays()+ diff.getMonths()*30 +diff.getYears()*356;
    }

}
