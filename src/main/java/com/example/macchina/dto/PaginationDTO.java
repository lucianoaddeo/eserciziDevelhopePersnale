package com.example.macchina.dto;

public class PaginationDTO {
        private Integer pageNum;
        private Integer pageSize;
        private SortDirection sortDir;
        private String sortProperty;

//il costruttore vuoto non serve, forse

    public PaginationDTO(){
        pageNum=0;
        pageSize=10;
        sortDir=SortDirection.ASC;
        sortProperty="id";
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SortDirection getSortDir() {
        return sortDir;
    }

    public void setSortDir(SortDirection sortDir) {
        this.sortDir = sortDir;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }

    public enum SortDirection {
        ASC, DESC
    }
}
