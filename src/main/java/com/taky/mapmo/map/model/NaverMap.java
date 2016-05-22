package com.taky.mapmo.map.model;

import java.util.List;

public class NaverMap {
	private Result result;
	
	public class Result {
		private List<Address> items;

		public List<Address> getItems() {
			return items;
		}

		public void setItems(List<Address> items) {
			this.items = items;
		}
	}
	
	public class Address {
		private String address;
		private boolean isRoadAddress;
		private Point point;

		public Point getPoint() {
			return point;
		}

		public void setPoint(Point point) {
			this.point = point;
		}

		public boolean isRoadAddress() {
			return isRoadAddress;
		}

		public void setRoadAddress(boolean isRoadAddress) {
			this.isRoadAddress = isRoadAddress;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	}
	
	public class Point {
		private double x;
		private double y;
		
		public double getX() {
			return x;
		}
		
		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
	}
	
	public Result createResult() {
		return new Result();
	}
	
	public Address createAddress() {
		return new Address();
	}
	
	public Point createPoint() {
		return new Point();
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
