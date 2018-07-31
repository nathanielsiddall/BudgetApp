package com.siddall.budgetapp.DAOs;

import com.siddall.budgetapp.Models.User;

public  class UserDataAccess {
    private JDBC db = new JDBC();

    public  User findByUsername(String username){
        return db.data("finduserbyusername", username, null).get(0);
    }
}
