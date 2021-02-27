package com.test.dto;

import java.util.Objects;

public class FareSource {
    private String name;
    private String type;
    private Long shopId;

    public FareSource() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FareSource fareTemp = (FareSource) o;
        return Objects.equals(name, fareTemp.name) &&
                Objects.equals(type, fareTemp.type) &&
                Objects.equals(shopId, fareTemp.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, shopId);
    }

    public FareSource(String name, String type, Long shopId) {
        this.name = name;
        this.type = type;
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
