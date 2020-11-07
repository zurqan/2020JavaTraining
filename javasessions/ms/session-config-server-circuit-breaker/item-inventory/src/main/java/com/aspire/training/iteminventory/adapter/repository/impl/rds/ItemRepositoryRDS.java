package com.aspire.training.iteminventory.adapter.repository.impl.rds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepositoryRDS extends JpaRepository<ItemEntity,String> {

    public List<ItemEntity> findByShortDescContaining(String desc);

//    @Query(value = "SELECT * FROM ITEM_ENTITY ",nativeQuery = true)
//    public List<ItemEntity> custom();

//    findByShortDesc
//    findByShortDescIsNot
//    findByShortDescIsNull

//    findByActiveTrue

//    findByShortDescStartingWith sh%
//    findByShortDescEndingWith %parmValue
//    findByShortDescLike -> like pattern here%desc%fff

//    findByPriceLessThan
//    findByPriceLessThanEqual
//    findByPriceGraterThan

//    findByPriceAndDesc
//    findByPriceOrDesc

//    findByPriceOrderByPriceAsc
}
