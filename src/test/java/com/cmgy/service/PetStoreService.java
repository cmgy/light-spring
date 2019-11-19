package com.cmgy.service;

public class PetStoreService {

    private ChenDao chenDao;
    private HaoDao haoDao;
    private String owner;

    public ChenDao getChenDao() {
        return chenDao;
    }

    public void setChenDao(ChenDao chenDao) {
        this.chenDao = chenDao;
    }

    public HaoDao getHaoDao() {
        return haoDao;
    }

    public void setHaoDao(HaoDao haoDao) {
        this.haoDao = haoDao;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
