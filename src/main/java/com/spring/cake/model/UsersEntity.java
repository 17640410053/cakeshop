package com.spring.cake.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DynamicInsert
@Table(name = "users", schema = "cake", catalog = "")
public class UsersEntity {
    private int userId;
    private String username;
    private String password;
    private String phone;
    private String mail;
    private Date birth;
    private Integer gender;
    private String image;
    private String token;
    private Timestamp createtime;
    @JsonIgnore
    private List<AddressEntity> addressesByUserId;
    @JsonIgnore
    private List<CartEntity> cartsByUserId;
    @JsonIgnore
    private List<CommentEntity> commentsByUserId;
    @JsonIgnore
    private List<OrderEntity> ordersByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "birth")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public List<AddressEntity> getAddressesByUserId() {
        return addressesByUserId;
    }

    public void setAddressesByUserId(List<AddressEntity> addressesByUserId) {
        this.addressesByUserId = addressesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public List<CartEntity> getCartsByUserId() {
        return cartsByUserId;
    }

    public void setCartsByUserId(List<CartEntity> cartsByUserId) {
        this.cartsByUserId = cartsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public List<CommentEntity> getCommentsByUserId() {
        return commentsByUserId;
    }

    public void setCommentsByUserId(List<CommentEntity> commentsByUserId) {
        this.commentsByUserId = commentsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public List<OrderEntity> getOrdersByUserId() {
        return ordersByUserId;
    }

    public void setOrdersByUserId(List<OrderEntity> ordersByUserId) {
        this.ordersByUserId = ordersByUserId;
    }
}
