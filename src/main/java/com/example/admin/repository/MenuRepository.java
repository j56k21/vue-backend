package com.example.admin.repository;

import com.example.admin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
    // depth로 메뉴 찾기
    List<Menu> findByDepth(Integer depth);

    // parentOrderNo로 자식 메뉴 찾기
    List<Menu> findByParentOrderNo(String parentOrderNo);

    // 최상위 메뉴 조회 (depth=0)
    @Query("SELECT m FROM Menu m WHERE m.depth = 0 ORDER BY m.orderNo")
    List<Menu> findTopLevelMenus();

    // 특정 부모의 자식 메뉴 조회 (orderNo 정렬)
    @Query("SELECT m FROM Menu m WHERE m.parentOrderNo = :parentOrderNo ORDER BY m.orderNo")
    List<Menu> findChildrenByParentOrderNo(String parentOrderNo);
}