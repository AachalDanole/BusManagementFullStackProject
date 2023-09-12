//package com.BusManagement.BusServiceImplementation;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.ArrayList;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.BusManagement.Bus.Bus;
//import com.BusManagement.Bus.Route;
//import com.BusManagement.BusRepository.RouteRepository;
//import com.BusManagement.BusService.RouteService;
//
//public class RouteServiceImpl implements RouteService {

//	@Autowired
//	private RouteRepository  routerepository;
//
//	public Route addRoute(Route route) {
//
//		Route newRoute = routerepository.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());
//
//
//
//		List<Bus> buses = new ArrayList<>();	
//
//		if(route != null) {
//			route.setBusList(buses);
//			return routerepository.save(route);
//		}
//		return null;
//		
//	}
//
//
//	public List<Route> viewAllRoute()  {
//
//		List<Route> routes=routerepository.findAll();
//
//		if(routes.isEmpty())
//			System.out.println("No route available");
//		else
//			return routes;
//		return null;	
//
//	}
//
//
//	public Route updateRoute(Route route) throws Exception{
//
//		Optional<Route> existedRoute = routerepository.findById(route.getRouteID());
//		if(existedRoute.isPresent()) {
//
//			Route presentRoute = existedRoute.get();
//			List<Bus> busList = presentRoute.getBusList();
//
//			if(!busList.isEmpty()) throw new Exception("Cannot update running route! Buses are already scheduled in the route.");
//
//			return routerepository.save(route);
//		}
//		else
//			throw new Exception("Route doesn't exist of  this routeId : "+ route.getRouteID());
//
//	}
//
//	public Route viewRoute(int routeId) throws Exception {
//		Optional<Route> opt=routerepository.findById(routeId);
//
//		return opt.orElseThrow(()->new Exception("There is no route present of this  routeId :" + routeId));
//	}
//
//	
//	
//	public Route deleteRoute(int routeID) throws Exception{
//
//		Optional<Route> route=routerepository.findById(routeID);
//
//		if(route.isPresent()) {
//			Route existingRoute=route.get();
//			routerepository.delete(existingRoute);
//			return existingRoute;
//		                }
//		else {
//		
//			throw new Exception("There is no route of this routeId : "+ routeID);
//	                 }
//}
//}
