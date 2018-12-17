package com.spring.cake.repository;

import com.spring.cake.model.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("goodsRepository")
public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {

}
