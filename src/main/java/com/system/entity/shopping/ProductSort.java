package com.system.entity.shopping;

import com.system.entity.BaseEntity;

import java.util.Objects;

public class ProductSort extends BaseEntity {
    private String sortName;
    private Integer parentSortId;

    public ProductSort(){}

    public ProductSort(String sortName, Integer parentSortId) {
        this.sortName = sortName;
        this.parentSortId = parentSortId;
    }

    public String getSortName() {
        return sortName;
    }

    public Integer getParentSortId() {
        return parentSortId;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public void setParentSortId(Integer parentSortId) {
        this.parentSortId = parentSortId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSort that = (ProductSort) o;
        return Objects.equals(sortName, that.sortName) &&
                Objects.equals(parentSortId, that.parentSortId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sortName, parentSortId);
    }

    @Override
    public String toString() {
        return "ProductSort{" +
                "sortName='" + sortName + '\'' +
                ", parentSortId=" + parentSortId +
                '}';
    }
}
