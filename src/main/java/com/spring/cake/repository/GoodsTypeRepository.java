package com.spring.cake.repository;

import com.spring.cake.model.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("goodsTypeRepository")
public interface GoodsTypeRepository extends JpaRepository<TypeEntity, Integer> {

}
