package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ProductInfo extends BaseEntity {

    private String productName;
    private String productDetail;
    private Integer productSortId;
    private Integer isSale;
    private Date saleTime;
    private BigDecimal price;

    public ProductInfo() {
    }

    public ProductInfo(String productName, String productDetail, Integer productSortId, Integer isSale, Date saleTime, BigDecimal price) {
        this.productName = productName;
        this.productDetail = productDetail;
        this.productSortId = productSortId;
        this.isSale = isSale;
        this.saleTime = saleTime;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public Integer getProductSortId() {
        return productSortId;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public void setProductSortId(Integer productSortId) {
        this.productSortId = productSortId;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return Objects.equals(productName, that.productName) &&
                Objects.equals(productDetail, that.productDetail) &&
                Objects.equals(productSortId, that.productSortId) &&
                Objects.equals(isSale, that.isSale) &&
                Objects.equals(saleTime, that.saleTime) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productDetail, productSortId, isSale, saleTime, price);
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productName='" + productName + '\'' +
                ", productDetail='" + productDetail + '\'' +
                ", productSortId=" + productSortId +
                ", isSale=" + isSale +
                ", saleTime=" + saleTime +
                ", price=" + price +
                '}';
    }
}
