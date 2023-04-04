
import java.time.LocalDate;
import java.util.ArrayList;
public class Order {
    private LocalDate tanggalPesanan;
    private static int nomor = 0;
    private int nomorPesanan;
    private int subTotalBiaya;
    private int diskon;
    private int totalHarga;
    private ArrayList<Lembar> item;
    private int index;
    private Status statusPesanan;
    private int ongkosKirim;
    private double jarak;


    public Order (){
        tanggalPesanan = LocalDate.now();
        nomor++;
        nomorPesanan = nomor;
        subTotalBiaya = 0;
        diskon = 0;
        totalHarga = 0;
        item = new ArrayList<Lembar>();
        index = 0;
        statusPesanan = Status.UNPAID;
        ongkosKirim = 0;
        jarak = 0;
    }

    public void setSubTotalBiaya(int subTotal){
        this.subTotalBiaya = subTotal;
    }

    public void setItem(Lembar item) {
        this.item.add(item);
    }

    public void setDiskon(int diskon){
        this.diskon = diskon;
    }
    public void setTotalHarga(){
        this.totalHarga = subTotalBiaya + ongkosKirim - diskon;
    }

    public void setStatusPesanan(int pilihan) {
        if (pilihan==1){
            statusPesanan = Status.SUCCESSFUL;
        }
        else if (pilihan == 2){
            statusPesanan = Status.CANCELLED;
        }
    }
    public void setOngkosKirim(){
        ongkosKirim = (int)jarak*5000;
    }
    public void setJarak(double jarak){
        this.jarak = jarak;
    }
    public LocalDate getTanggalPesanan(){
        return tanggalPesanan;
    }
    public int getSubTotalBiaya(){
        return subTotalBiaya;
    }
    public int getDiskon(){
        return diskon;
    }
    public int getTotalHarga(){
        return totalHarga;
    }
    public Status getStatusPesanan(){
        return statusPesanan;
    }
    public int getNomorPesanan() {
        return nomorPesanan;
    }

    public ArrayList<Lembar> getItem() {
        return item;
    }

    public int getOngkosKirim(){
        return ongkosKirim;
    }
    public double getJarak(){
        return jarak;
    }

    public int getIndex() {
        return index;
    }

    public void checkOut(){
        System.out.println(tanggalPesanan);

        for (int i=0 ; i<index ; i++){
            System.out.println(item.get(i));
        }
    }
    public void addItem (Lembar lembar){
        item.add(lembar);
        index++;
    }
    public void printDetails(){
        checkOut();
        setTotalHarga();
        System.out.println("Total yang harus dibayarkan : " + getTotalHarga());
        System.out.println(statusPesanan);
    }
    public void applyPromo(Promotion promo){
        setDiskon(promo.getDiscount());
    }
    public void pay(){
        setStatusPesanan(1);
    }
}

