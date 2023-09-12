//package com.BusManagement.Bus;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Reservation {
//	
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer reservationID;
//    public Integer getReservationID() {
//		return reservationID;
//	}
//
//	public void setReservationID(Integer reservationID) {
//		this.reservationID = reservationID;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public LocalTime getTime() {
//		return time;
//	}
//
//	public void setTime(LocalTime time) {
//		this.time = time;
//	}
//
//	public String getSource() {
//		return source;
//	}
//
//	public void setSource(String source) {
//		this.source = source;
//	}
//
//	public String getDestination() {
//		return destination;
//	}
//
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//
//	public LocalDate getJourneyDate() {
//		return journeyDate;
//	}
//
//	public void setJourneyDate(LocalDate journeyDate) {
//		this.journeyDate = journeyDate;
//	}
//
//	public Integer getBookedSeat() {
//		return bookedSeat;
//	}
//
//	public void setBookedSeat(Integer bookedSeat) {
//		this.bookedSeat = bookedSeat;
//	}
//
//	public Integer getFare() {
//		return fare;
//	}
//
//	public void setFare(Integer fare) {
//		this.fare = fare;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Bus getBus() {
//		return bus;
//	}
//
//	public void setBus(Bus bus) {
//		this.bus = bus;
//	}
//
//	private String status;
//    private LocalDate date;
//    private LocalTime time;
//
//    private String source;
//    private String destination;
//    private LocalDate journeyDate;
//    private Integer bookedSeat;
//    private Integer fare;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private Bus bus;
//	
//}
