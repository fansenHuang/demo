package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.util.Objects;

public class ProducCanNotSelectedParam extends BaseEntity {

    private String param_name;
    private Integer product_id;
    private String value;

    public ProducCanNotSelectedParam(){

    }

    public ProducCanNotSelectedParam(String param_name, Integer product_id, String value) {
        this.param_name = param_name;
        this.product_id = product_id;
        this.value = value;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducCanNotSelectedParam that = (ProducCanNotSelectedParam) o;
        return Objects.equals(param_name, that.param_name) &&
                Objects.equals(product_id, that.product_id) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(param_name, product_id, value);
    }

    @Override
    public String toString() {
        return "ProducCanNotSelectedParam{" +
                "param_name='" + param_name + '\'' +
                ", product_id=" + product_id +
                ", value='" + value + '\'' +
                '}';
    }
}
