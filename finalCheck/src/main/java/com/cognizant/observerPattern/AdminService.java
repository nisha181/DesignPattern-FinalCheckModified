package com.cognizant.observerPattern;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminService implements IAdminService {
	List<IAdminObserver> observers;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	public AdminService() {
		super();
		this.observers = new ArrayList<>();
	}

	public void subScribe(IAdminObserver adminObserver) {
		observers.add(adminObserver);
		LOGGER.info("start");
		for (IAdminObserver iAdminObserver : observers) {
			LOGGER.info(iAdminObserver.toString());
		}
		LOGGER.info("end");
	}

	public void unSubScribe(IAdminObserver adminObserver) {
		observers.remove(adminObserver);
		LOGGER.info("start");
		for (IAdminObserver iAdminObserver : observers) {
			LOGGER.info(iAdminObserver.toString());
		}
		LOGGER.info("end");
	}

	public void notificationToAll() {
		for (IAdminObserver iAdminObserver : observers) {
			if (iAdminObserver.getNoOfTickets() >= 100)
				iAdminObserver.notification();
		}
	}

}
