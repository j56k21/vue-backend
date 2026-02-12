package com.example.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu", uniqueConstraints = @UniqueConstraint(columnNames = {"depth", "parent_order_no", "order_no"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @Column(name = "menu_code", length = 10)
    private String menuCode;
    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;
    @Column(name = "order_no", nullable = false, length = 10)
    private String orderNo;
    @Column(name = "parent_order_no", length = 255)
    private String parentOrderNo;
    @Column(name = "depth", nullable = false)
    private Integer depth = 0;
    @Column(name = "url", length = 255)
    private String url;
    @Column(name = "icon", length = 50)
    private String icon;
    @Column(name = "is_visible")
    private Boolean isVisible = true;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }          // 전체 경로 계산 메서드

    public String getFullPath() {
        if (parentOrderNo == null) {
            return orderNo;
        }
        return parentOrderNo + "." + orderNo;
    }
}
