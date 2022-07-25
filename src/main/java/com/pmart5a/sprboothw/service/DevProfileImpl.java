package com.pmart5a.sprboothw.service;

public class DevProfileImpl implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}