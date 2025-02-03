package org.mon.iocanddi.captcha.facade;


//灯的门面

//门面模式实现了客户短和子系统的解耦合
public class LightFacade {


    void LightOn(){
        BedRoomLight bedRoomLight=new BedRoomLight();
        LivingRoomLight livingRoomLight=new LivingRoomLight();
        bedRoomLight.on();
        livingRoomLight.on();
    }

    void LightOff(){
        BedRoomLight bedRoomLight=new BedRoomLight();
        LivingRoomLight livingRoomLight=new LivingRoomLight();
        bedRoomLight.off();
        livingRoomLight.off();
    }




}

