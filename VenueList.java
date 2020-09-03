package com.ffxiv;

public class VenueList {
	private String name, layout, type, server, housing, aetheryte, day, time;
	private int ward, plot;
	
	public VenueList() {
		this.name = "";
		this.layout = "";
		this.type = "";
		this.server = "";
		this.housing = "";
		this.aetheryte = "";
		this.day = "";
		this.ward = 0;
		this.plot = 0;
		this.time = "";
	}
	
	public VenueList(String name) {
		this();
		this.name = name;
	}
	public VenueList(String name, String layout, String type, String server, String housing, String aetheryte, int ward, int plot, String day, String time) {
		this.name = name;
		this.layout = layout;
		this.type = type;
		this.server = server;
		this.housing = housing;
		this.aetheryte = aetheryte;
		this.day = day;
		this.ward = ward;
		this.plot = plot;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getAetheryte() {
		return aetheryte;
	}

	public void setAetheryte(String aetheryte) {
		this.aetheryte = aetheryte;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getWard() {
		return ward;
	}

	public void setWard(int ward) {
		this.ward = ward;
	}

	public int getPlot() {
		return plot;
	}

	public void setPlot(int plot) {
		this.plot = plot;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String toString() {
		String s = name + "| " + layout + "| " + type + "| " + server + "| " + housing + "| " + aetheryte + "| " + ward + "| " + plot + "| " + day + "| " + time + "\n";
		return s;
	}
	
	
}
