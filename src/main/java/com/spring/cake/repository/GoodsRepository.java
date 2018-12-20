package com.spring.cake.repository;

import com.spring.cake.model.GoodsEntity;
import com.spring.cake.model.TypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goodsRepository")
public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {
//    List<GoodsEntity> findByNameLikeAndOrderByPriceAsc(String name);

//    List<GoodsEntity> findByTypeId(TypeEntity typeEntity); //你看这个就不对，你要按照他的提示来，黄色就是警告，表示你没有按他的规则来，不能帮你自动实现

    Page<GoodsEntity> findByTypeByTypeId(TypeEntity typeEntity, Pageable pageable); // private TypeEntity typeByTypeId;能懂？嗯嗯，实体类里面是什么类型的，你参数就要是什么类型的，懂吗yes

}
