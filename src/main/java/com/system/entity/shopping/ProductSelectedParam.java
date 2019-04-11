package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.util.Objects;

public class ProductSelectedParam extends BaseEntity {

    private String paramName;
    private Integer productId;

    public ProductSelectedParam(){

    }

    public ProductSelectedParam(String paramName, Integer productId) {
        this.paramName = paramName;
        this.productId = productId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSelectedParam that = (ProductSelectedParam) o;
        return Objects.equals(paramName, that.paramName) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paramName, productId);
    }

    @Override
    public String toString() {
        return "ProductSelectedParam{" +
                "paramName='" + paramName + '\'' +
                ", productId=" + productId +
                '}';
    }
}
