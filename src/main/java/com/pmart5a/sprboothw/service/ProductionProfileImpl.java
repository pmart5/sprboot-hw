package com.pmart5a.sprboothw.service;

public class ProductionProfileImpl implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}