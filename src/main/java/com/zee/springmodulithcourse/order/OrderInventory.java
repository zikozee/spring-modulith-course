package com.zee.springmodulithcourse.order;

import jakarta.persistence.*;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Entity
@Table(indexes = {
        @Index(name = "ord_idx", columnList = "order_id"),
        @Index(name = "inv_idx", columnList = "inventory_id")
})
public class OrderInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long orderId;
    private long inventoryId;
    private int qty;
    private long totalQtyPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getTotalQtyPrice() {
        return totalQtyPrice;
    }

    public void setTotalQtyPrice(long totalQtyPrice) {
        this.totalQtyPrice = totalQtyPrice;
    }

    @Override
    public String toString() {
        return "OrderInventory{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", inventoryId=" + inventoryId +
                ", qty=" + qty +
                ", totalQtyPrice=" + totalQtyPrice +
                '}';
    }
}
