package com.spring.cake.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicInsert
@Table(name = "attr", schema = "cake", catalog = "")
public class AttrEntity {
    private int attrId;
    private String name;
    @JsonIgnore
    private List<GoodsEntity> goodsAttrsByAttrId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attr_id")
    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttrEntity that = (AttrEntity) o;

        if (attrId != that.attrId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attrId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToMany()
    @JoinTable(name = "goods_attr",joinColumns = {@JoinColumn(name = "attr_id")},inverseJoinColumns = {@JoinColumn(name = "goods_id")})
    public List<GoodsEntity> getGoodsAttrsByAttrId() {
        return goodsAttrsByAttrId;
    }

    public void setGoodsAttrsByAttrId(List<GoodsEntity> goodsAttrsByAttrId) {
        this.goodsAttrsByAttrId = goodsAttrsByAttrId;
    }
}
