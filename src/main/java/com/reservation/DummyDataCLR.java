package com.reservation;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reservation.model.Reservation;
import com.reservation.model.ReservationRepository;

/**
 * Created by mishrk3 on 8/31/2016.
 */
@Component
public class DummyDataCLR implements CommandLineRunner {

	@Autowired
	private ReservationRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Dave", "Stephan", "Krishna", "Joe", "John", "Nina", "Oliver", "Mark")
				.forEach(name -> repository.save(new Reservation(name)));

		repository.findAll().forEach(System.out::println);
	}
}
