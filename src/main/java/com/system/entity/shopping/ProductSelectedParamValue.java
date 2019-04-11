package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.util.Objects;

public class ProductSelectedParamValue extends BaseEntity {

    private Integer paramId;
    private String value;
    private Integer inventory;
    private Integer salesVolume;

    public ProductSelectedParamValue(){

    }

    public ProductSelectedParamValue(Integer paramId, String value, Integer inventory, Integer salesVolume) {
        this.paramId = paramId;
        this.value = value;
        this.inventory = inventory;
        this.salesVolume = salesVolume;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSelectedParamValue that = (ProductSelectedParamValue) o;
        return Objects.equals(paramId, that.paramId) &&
                Objects.equals(value, that.value) &&
                Objects.equals(inventory, that.inventory) &&
                Objects.equals(salesVolume, that.salesVolume);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paramId, value, inventory, salesVolume);
    }

    @Override
    public String toString() {
        return "ProductSelectedParamValue{" +
                "paramId=" + paramId +
                ", value='" + value + '\'' +
                ", inventory=" + inventory +
                ", salesVolume=" + salesVolume +
                '}';
    }
}
