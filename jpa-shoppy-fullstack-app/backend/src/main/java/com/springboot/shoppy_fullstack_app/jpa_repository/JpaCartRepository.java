package com.springboot.shoppy_fullstack_app.jpa_repository;

import com.springboot.shoppy_fullstack_app.dto.CartCheckQtyDto;
import com.springboot.shoppy_fullstack_app.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCartRepository extends JpaRepository<CartItem, Integer> {

    //🛒 장바구니 상품 수량 업데이트
    @Modifying
    @Query("update CartItem c set c.qty = c.qty + 1 where c.cid = :cid")
    int increaseQty(@Param("cid") int cid);

    @Modifying
    @Query("update CartItem c set c.qty = c.qty - 1 where c.cid = :cid")
    int decreaseQty(@Param("cid") int cid);

    //🛒 장바구니 상품 수량 체크
    @Query("""
            select new com.springboot.shoppy_fullstack_app.dto.CartCheckQtyDto(c.cid, count(c))
                from CartItem c 
                where c.pid = :pid 
                  and c.size = :size 
                  and c.id = :id
                group by c.cid 
            """)
    CartCheckQtyDto checkQty(@Param("pid") int pid,
                             @Param("size") String size,
                             @Param("id") String id);

    CartItem save(CartItem cartItem);   //🛒 장바구니 상품 추가
}

