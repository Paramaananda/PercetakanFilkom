public class CashbackPromo extends Promotion {

    public CashbackPromo(Order pesanan, Member pelanggan) {
        super(pesanan, pelanggan);
    }

    public void setDiscount() {
        setDiscount(countCashback(getOrder(), getPelanggan()));
    }


    @Override
    public boolean isCustomerEligible(Member pelanggan) {
        if (pelanggan.joinTime() > 30) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isMinimumPriceEligible(Order pesanan) {
        if (pesanan.getSubTotalBiaya() < 50_000) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isShippingFeeEligible(Order pesanan) {
        if (pesanan.getJarak() < 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int countDiscount(Order pesanan, Member pelanggan) {
        return 0;
    }

    @Override
    public int countCashback(Order pesanan, Member pelanggan) {
        if (isCustomerEligible(pelanggan) && isMinimumPriceEligible(pesanan)) {
            return 10000;
        } else {
            return 0;
        }
    }

    @Override
    public int countDeliveryDiscount(Order pesanan, Member pelanggan) {
        return 0;
    }

    @Override
    public int compareTo(Promotion promo) {
        if (getDiscount() > promo.getDiscount()) {
            return 1;
        } else if (getDiscount() < promo.getDiscount()) {
            return -1;
        } else {
            return 0;
        }
    }
}