package com.algotechie.model;


public class Computer {
	// Required
	private String cpu;
	private String ram;
	
	// Optional
	private String gpu;
	private String storege;
	private boolean wifiEnabled;
	private boolean bluetoothEnabled;
	
	 // Private constructor to enforce Builder usage
	public Computer(Builder builder) {
		this.cpu = builder.cpu;
		this.ram = builder.ram;
		this.gpu = builder.gpu;
		this.storege = builder.storage;
		this.wifiEnabled = builder.wifiEnabled;
		this.bluetoothEnabled = builder.bluetoohEnabled;
	}
	
		
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", gpu=" + gpu + ", storege=" + storege + ", wifiEnabled="
				+ wifiEnabled + ", bluetoothEnabled=" + bluetoothEnabled + "]";
	}


	// Builder Class
	public static class Builder {
		private String cpu;
		private String ram;
		private String gpu;
		private String storage;
		private boolean wifiEnabled;
		private boolean bluetoohEnabled;
		
		// Required parameters in Builder constructor
		public Builder(String cpu, String ram) {
			this.cpu = cpu;
			this.ram = ram;
		}
			
		// Optional setters with chaining
		public Builder setGpu(String gpu) {
			this.gpu = gpu;
			return this;
		}

		public Builder setStorage(String storage) {
			this.storage = storage;
			return this;
		}

		public Builder enableWifi(boolean wifiEnabled) {
			this.wifiEnabled = wifiEnabled;
			return this;
		}

		public Builder enableBluetooth(boolean bluetoohEnabled) {
			this.bluetoohEnabled = bluetoohEnabled;
			return this;
		}
			
		// Build method
		public Computer build() {
			return new Computer(this);
		}

	}
}
