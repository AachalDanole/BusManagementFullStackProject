package com.BusManagement.Bus;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.DynamicUpdate;
//http://localhost:8080/email/?userEmail="aachaldanole@gmail.com"
/*In this class, we declare private attribute to represent bus details 
and provide getter and setter for accessing these attributes.
*/

@Entity
@Table(name = "Bus")
@DynamicUpdate


public class Bus {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	@Column(name = "DriverName", nullable = false)
	private String driverName;

	@Column(name = "Destination", nullable = false)
	private String destination;
	
	@Column(name = "Source", nullable = false)
	private String source;

	@Column(name = "Cost", nullable = false)
	private int cost;
	
	@Column(name="Total_seat", nullable = false )
	private int totalSeat;
	
	@Column(name="ACBus",nullable = false)
	private Boolean isAcBus;
	
	
	@Column(name="TravelsName",nullable = false)
	private String travelsName;
	
	@Column(name="Rating",nullable = false)
	private int  rating; 
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//    private Route route;
//	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
//	
//	@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
//    private List<Reservation> reservationList = new ArrayList<>();
//	
//	
//	
//	public Route getRoute() {
//		return route;
//	}
//
//	public void setRoute(Route route) {
//		this.route = route;
//	}
//
//	public List<Reservation> getReservationList() {
//		return reservationList;
//	}
//
//	public void setReservationList(List<Reservation> reservationList) {
//		this.reservationList = reservationList;
//	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Boolean getIsAcBus() {
		return isAcBus;
	}

	public void setIsAcBus(Boolean isAcBus) {
		this.isAcBus = isAcBus;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	

	public Bus() {
		
	}
	
	public Bus(String driverName, String destination,int cost,int total_seat,int rating) {
		this.driverName = driverName;
		this.destination = destination;
		this.cost = cost;
		this.totalSeat = total_seat;
		this.rating = rating;
	}
	
    public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", driverName=" + driverName + ", source=" + source+",destination=" + destination + ",rating=" + rating +" ,cost=" + cost
				+ ", totalSeat=" + totalSeat + ", isACBus=" + isAcBus + ", travelsName=" + travelsName + "]";
	}
	

}
