package org.mon.iocanddi.captcha.facade;

public class Main {
    public static void main(String[] args) {
//        BedRoomLight bedRoomLight=new BedRoomLight();
//        LivingRoomLight livingRoomLight=new LivingRoomLight();
//
//        bedRoomLight.on();
//        livingRoomLight.on();

        LightFacade lightFacade=new LightFacade();
        lightFacade.LightOn();
        lightFacade.LightOff();
    }
}
