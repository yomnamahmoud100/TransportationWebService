package com.transportation;
import com.transportation.Persistence.ISaving;
import com.transportation.Persistence.arraySaving;
import com.transportation.application.*;
import com.transportation.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class DriverController  {
    private IDriver driver;
     DriverController(){
        driver= new Driver();
    }
    ISaving saving= arraySaving.getInstance();
    @PostMapping("/addDriverReq")
    public boolean addDriverReq(@RequestBody RideRequest nwRequest){
       return driver.addDriverReq(nwRequest);
    }

    @GetMapping("/getDriverRequsets")
    public ArrayList<RideRequest> getDriverRequsets() {
        return driver.getDriverRequsets();
    }

    @PostMapping("/calcbalance/{price}")
    public double calcbalance(@PathVariable double price)
    {
        return driver.calcbalance(price);
    }

    @PostMapping("/AddNewFavArea/{name}/{pass}")
    public boolean AddNewFavArea(@RequestBody Area area,@PathVariable String name,@PathVariable String pass)
    {   Driver driver1= (Driver) saving.searchIUser(name,pass);
        Area area1= (Area) saving.searchArea(area.getName());
        area.addDriver(driver1);
        return driver.AddNewFavArea(area1);
    }

    @PostMapping("/rateDriver/{rate}")
    public boolean rateMe(@PathVariable int rate ,@RequestBody User user)
    {
       return driver.rateMe(rate,user);
    }

   @PostMapping("/makeOffer/{price}")
    public void makeOffer(@RequestBody Ride ride ,@PathVariable double price)
    {
        driver.makeOffer(ride,price);
    }

    @GetMapping("/getFavAreas")
    public ArrayList<Area> getFavAreas()
    {
        return driver.getFavAreas();
    }

    @GetMapping("/listRides")
    public ArrayList<String> listRides()
    {
      return driver.listRides();
    }

    @GetMapping("/getRides")
    public ArrayList<Ride> getRides()
    {
        return driver.getRides();
    }

    @PostMapping("/addRide")
    public boolean addRide(@RequestBody Ride ride){
        return driver.addRide(ride);
    }

    @PostMapping("/startRide")
    public boolean startRide( @RequestBody User user)
    {
       return driver.startRide(user);
    }

    @PostMapping("/endRide")
    public boolean endRide(@RequestBody User user)
    {
        return driver.endRide(user);
    }
}
