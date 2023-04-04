public class Guest extends Customer{
    private Order pesanan;

    public Guest (){
        super();
    }

    @Override
    public void makeOrder() {
        pesanan = new Order();
    }
    public Order getPesanan() {
        return pesanan;
    }
}

