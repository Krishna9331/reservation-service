package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.model.ReservationRepository;

/**
 * Created by mishrk3 on 8/31/2016.
 */
@RefreshScope
@RestController
public class ReservationController {

	@Autowired
	private ReservationRepository repository;

	@Value("${reservationName}")
	private String reservationName;

	@RequestMapping("/reservation")
	public Reservation getReservation() {
		return repository.findByReservationName(reservationName);
	}
}
