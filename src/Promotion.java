
import java.time.LocalDate;

public abstract class Promotion implements Applicable, Comparable<Promotion> {
    private String promoCode = "2023CERIA";
    private LocalDate tanggalAkhir = LocalDate.of(2023, 12, 31);
    private LocalDate tanggalAwal = LocalDate.of(2023, 01, 01);
    private Order pesanan;
    private Member pelanggan;
    private int discount;

    public Promotion(Order pesanan, Member pelanggan) {
        this.pesanan = pesanan;
        this.pelanggan = pelanggan;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int a) {
        this.discount = a;
    }
    public void setOrder(Order pesanan) {
        this.pesanan = pesanan;
    }

    public Order getOrder() {
        return this.pesanan;
    }

    public void setPelanggan(Member pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Member getPelanggan() {
        return this.pelanggan;
    }

    public void setPromoCode(String pc) {
        this.promoCode = pc;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public boolean isCustomerEligible(Member pelanggan) {
        if (pelanggan.joinTime() > 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMinimumPriceEligible(Order pesanan) {
        if (pesanan.getSubTotalBiaya() < 50_000) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isShippingFeeEligible(Order pesanan) {
        if (pesanan.getJarak() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public abstract int countDiscount(Order pesanan, Member pelanggan);

    public abstract int countCashback(Order pesanan, Member pelanggan);

    public abstract int countDeliveryDiscount(Order pesanan, Member pelanggan);

    @Override
    public abstract int compareTo(Promotion promo);
}
