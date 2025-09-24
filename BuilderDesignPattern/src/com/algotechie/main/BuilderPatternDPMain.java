package com.algotechie.main;

import com.algotechie.model.Computer;

public class BuilderPatternDPMain {
	
	public static void main(String[] args) {
		Computer gamingPC = new Computer.Builder("Intel 19", "64 GB")
						   .setGpu("NVIDIA RTX 4090")
						   .setStorage("1 TB SSD")
						   .enableWifi(true)
						   .enableBluetooth(true)
				           .build();
		
		System.out.println(gamingPC);

        Computer officePC = new Computer.Builder("Intel i5", "16GB")
                                .setStorage("512GB SSD")
                                .enableWifi(true)
                                .build();

        System.out.println(officePC);
	}

}
