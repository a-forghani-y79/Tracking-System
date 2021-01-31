package com.moon.trackingsystem.service;

import com.moon.trackingsystem.entity.ThrowawayAuth;

import java.util.List;

public class ThrowawayService {

    private static ThrowawayService throwawayService;
    private List<ThrowawayAuth> list;

    private ThrowawayService() {
    }

    public static ThrowawayService getInstance() {
        if(throwawayService == null)
            return new ThrowawayService();
        return throwawayService;
    }//end getInstance

    public void add(ThrowawayAuth throwawayAuth) {
        list.add(throwawayAuth);
    }//end add

    public void remove(ThrowawayAuth throwawayAuth) {
        list.remove(throwawayAuth);
    }//end remove

}//end class
