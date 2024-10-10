package com.example.task02;

public class DiscountBill extends Bill {
    private final double discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice() - calculateDiscount();
    }

    public long calculateDiscount() {
        return (long) (super.getPrice() * discount / 100);
    }

    @Override
    public String toString() {
       // return String.format("Счет с учетом скидки: %d \nРазмер скидки в процентах: d% \nАбсолютное значение скидки: %d",
          //      getPrice(), getDiscount(), calculateDiscount());
        return Double.toString(getPrice());
    }
}
