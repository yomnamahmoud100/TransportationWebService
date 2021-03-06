package com.transportation.core;

import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.Event;
import com.transportation.application.IUser;


import java.util.ArrayList;

public class admin extends IUser {
    public ISaving saving = arraySaving.getInstance();
    public admin(){

    }

    public boolean addDiscount(Area area){
        for (Area area1:saving.retrieveArea()){
            if(area.getName().equals(area1.getName())){
                area1.setHasAdminDiscount(true);
                return true;
            }

        }
        return false;
    }

    public ArrayList<String> showEvents(RideRequest req)
    {
     ArrayList<String>printing= new ArrayList<>();
       // for (RideRequest req:ride.getRequests()) {
            for(int j=0;j<req.getEvents().size();j++){
               printing.add( req.getEvents().get(j).printEvent());
            }
             return printing;
        //}

    }

    public boolean suspend(IUser user) {
        for (IUser iuser : saving.retrieveUsers()) {
            if (iuser.getUserName().equals(user.getUserName())&&iuser.getPassword().equals(user.getPassword())) {
                if(iuser instanceof User) ((User)iuser).setVerified(false);
                if(iuser instanceof Driver) ((Driver)iuser).setVerified(false);
                saving.savePended(iuser);
                saving.retrieveUsers().remove(iuser);
                return true;

            }
        }
        return false;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return super.getUserName();
    }

    @Override
    public void setPassword(String password) {
        // TODO Auto-generated method stub
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        // TODO Auto-generated method stub
        super.setUserName(userName);
    }

    @Override
    public String toString() {
        return "admin [name=" + this.userName + "pass"+ this.password+"]";
    }

    public boolean verify(IUser driver) {
        for (IUser itdriver : saving.retrievePended()) {
            if (driver.equals(itdriver) && itdriver instanceof Driver) {
                ((Driver) driver).setVerified(true);
                saving.retrievePended().remove(driver);
                return saving.saveUser(driver);
            }

        }
        return false;
    }

    public ArrayList<IUser> listPendingRegistration() {
        return saving.retrievePended();
    }

    public boolean loginAdmin(IUser iuser) {
        IUser result;
        result = saving.searchAdmin(iuser.getUserName(), iuser.getPassword());

        if (result == null) {
            saving.addAdmin(iuser);

           // System.out.println("You are not an admin!");
        } else {
           // System.out.println("You logged in successfully.");
            return true;
        }
        return false;
    }
}