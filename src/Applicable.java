public interface Applicable {
    public abstract boolean isCustomerEligible(Member pelanggan);
    public abstract boolean isMinimumPriceEligible(Order pesanan);
    public abstract boolean isShippingFeeEligible(Order pesanan);
    public abstract int countDiscount(Order pesanan, Member pelanggan);
    public abstract int countCashback(Order pesanan, Member pelanggan);
    public abstract int countDeliveryDiscount(Order pesanan, Member pelanggan);
}

