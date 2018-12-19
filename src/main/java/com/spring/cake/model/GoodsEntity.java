package com.spring.cake.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@DynamicInsert
@Table(name = "goods", schema = "cake", catalog = "")
public class GoodsEntity {
    private int goodsId;
    private String name;
    private String detail;
    private Integer price;
    private Integer status;
    private Timestamp createtime;
  /*  private Timestamp updatetime;*/
    private String img;
    private Integer  star;
    @JsonIgnore
    private List<CartEntity> cartsByGoodsId;
    @JsonIgnore
    private List<CommentEntity> commentsByGoodsId;
    private TypeEntity typeByTypeId;
    @JsonIgnore
    private List<AttrEntity> goodsAttrsByGoodsId;
    @JsonIgnore
    private List<OrderdetailEntity> orderdetailsByGoodsId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

/*
    @Basic
    @Column(name = "updatetime")
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
*/


    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @Basic
    @Column(name = "star")
    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (goodsId != that.goodsId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (star != null ? !star.equals(that.star) : that.star != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (star != null ? star.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "goodsByGoodsId")
    public List<CartEntity> getCartsByGoodsId() {
        return cartsByGoodsId;
    }

    public void setCartsByGoodsId(List<CartEntity> cartsByGoodsId) {
        this.cartsByGoodsId = cartsByGoodsId;
    }

    @OneToMany(mappedBy = "goodsByGoodsId")
    public List<CommentEntity> getCommentsByGoodsId() {
        return commentsByGoodsId;
    }

    public void setCommentsByGoodsId(List<CommentEntity> commentsByGoodsId) {
        this.commentsByGoodsId = commentsByGoodsId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @ManyToMany()
    @JoinTable(name = "goods_attr",joinColumns = {@JoinColumn(name = "goods_id")},inverseJoinColumns = {@JoinColumn(name = "attr_id")})
    public List<AttrEntity> getGoodsAttrsByGoodsId() {
        return goodsAttrsByGoodsId;
    }

    public void setGoodsAttrsByGoodsId(List<AttrEntity> goodsAttrsByGoodsId) {
        this.goodsAttrsByGoodsId = goodsAttrsByGoodsId;
    }

    @OneToMany(mappedBy = "goodsByGoodsId")
    public List<OrderdetailEntity> getOrderdetailsByGoodsId() {
        return orderdetailsByGoodsId;
    }

    public void setOrderdetailsByGoodsId(List<OrderdetailEntity> orderdetailsByGoodsId) {
        this.orderdetailsByGoodsId = orderdetailsByGoodsId;
    }
}
