package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.util.Objects;

public class ProductImg extends BaseEntity {
    private Integer productSelectedValueId;
    private String imgDetail;
    private String imgUrl;
    public ProductImg(){

    }

    public ProductImg(Integer productSelectedValueId, String imgDetail, String imgUrl) {
        this.productSelectedValueId = productSelectedValueId;
        this.imgDetail = imgDetail;
        this.imgUrl = imgUrl;
    }

    public Integer getProductSelectedValueId() {
        return productSelectedValueId;
    }

    public void setProductSelectedValueId(Integer productSelectedValueId) {
        this.productSelectedValueId = productSelectedValueId;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImg that = (ProductImg) o;
        return Objects.equals(productSelectedValueId, that.productSelectedValueId) &&
                Objects.equals(imgDetail, that.imgDetail) &&
                Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productSelectedValueId, imgDetail, imgUrl);
    }

    @Override
    public String toString() {
        return "ProductImg{" +
                "productSelectedValueId=" + productSelectedValueId +
                ", imgDetail='" + imgDetail + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
