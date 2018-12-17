package com.spring.cake.model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DynamicInsert
@Table(name = "ordertable", schema = "cake", catalog = "")
public class OrderEntity {
    private int orderId;
    private Integer money;
    private Integer status;
    private Timestamp time;
    private UsersEntity usersByUserId;
    private AddressEntity addressByAddressId;
    private List<OrderdetailEntity> orderdetailsByOrderId;

    /**
     * Repeated column in mapping for entity: com.spring.cake.model.OrderEntity column: user_id (should be mapped with insert="false" update="false")
     * 应该加上insert="false" update="false"，意思就是添加不管我事，更新也不关我事
     * 因为都被实体和集合维护过了，就不需要外键字段去维护了
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    @Basic
    @Column(name = "money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public AddressEntity getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(AddressEntity addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "orderByOrderId")
    public List<OrderdetailEntity> getOrderdetailsByOrderId() {
        return orderdetailsByOrderId;
    }

    public void setOrderdetailsByOrderId(List<OrderdetailEntity> orderdetailsByOrderId) {
        this.orderdetailsByOrderId = orderdetailsByOrderId;
    }
}
