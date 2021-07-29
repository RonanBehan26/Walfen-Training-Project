package com.walfen.training.api.zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ZooTest {

	@Test
	public void testZoo() {

	}

	@Test
	public void testVisitors() {

		Ticket ticketTomMartin = new Ticket(LocalDateTime.parse("2021-04-08T12:30:32"), 2, 27.00);
		Ticket ticketJackBrinog = new Ticket(LocalDateTime.parse("2020-05-09T10:30:12"), 3, 35.00);
		Ticket ticketMikeThomson = new Ticket(LocalDateTime.parse("2021-01-08T14:30:14"), 4, 42);

		Visitor visitor1 = new Visitor("Tom", "Martin", ticketTomMartin);
		Visitor visitor2 = new Visitor("Jack", "Brinog", ticketJackBrinog);
		Visitor visitor3 = new Visitor("Mike", "Thomson", ticketMikeThomson);

		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.add(visitor1);
		visitors.add(visitor2);
		visitors.add(visitor3);

		assertEquals("Tom Martin", (visitor1.getFirstName() + " " + visitor1.getLastName()));
		assertEquals(ticketTomMartin, visitor1.getTicket());
		assertEquals(27, visitor1.getTicket().getPrice());
		System.out.println(visitor1.getTicket().getPrice());

		System.out.println(visitors.get(0).getTicket().getPrice());
		System.out.println(visitors.get(1).getTicket().getPrice());
		System.out.println(visitors.get(2).getTicket().getPrice());

		// get total amount of the tickets
		double totalAmountfromTickets = 0;
		for (int i = 0; i < visitors.size(); i++) {
			totalAmountfromTickets = totalAmountfromTickets + visitors.get(i).getTicket().getPrice();
		}
		System.out.println("Total amount Tickets: " + totalAmountfromTickets);

		// get the total number of tickets
		int totalTickets = 0;
		for (int i = 0; i < visitors.size(); i++) {
			totalTickets = totalTickets + visitors.get(i).getTicket().getNumOfTickets();
		}
		System.out.println("Total Tickets: " + totalTickets);

		// total amount of the tickets
		assertEquals(104.0, totalAmountfromTickets);
		// num of visitors
		assertEquals(3, visitors.size());
		// total tickets
		assertEquals(9, totalTickets);

		// sort the last names alphabetically
		visitors.sort((Visitor s1, Visitor s2) -> s1.getLastName().compareTo(s2.getLastName()));
		visitors.forEach((s) -> System.out.println(s.getLastName()));

		assertEquals("Brinog", (visitors.get(0).getLastName()));
		assertEquals("Martin", (visitors.get(1).getLastName()));
		assertEquals("Thomson", (visitors.get(2).getLastName()));

		// sort the last names & then firstName alphabetically
		visitors.sort((Visitor s1, Visitor s2) -> (s1.getLastName()
				.compareTo(s2.getLastName() + s1.getFirstName().compareTo(s2.getFirstName()))));
		visitors.forEach((s) -> System.out.println(s.getLastName() + " " + s.getFirstName()));

		assertEquals("Brinog Jack", (visitors.get(0).getLastName() + " " + visitors.get(0).getFirstName()));
		assertEquals("Martin Tom", (visitors.get(1).getLastName() + " " + visitors.get(1).getFirstName()));
		assertEquals("Thomson Mike", (visitors.get(2).getLastName() + " " + visitors.get(2).getFirstName()));

		// sort the last names datetime
		visitors.sort(
				(Visitor s1, Visitor s2) -> s1.getTicket().getVisitTime().compareTo(s2.getTicket().getVisitTime()));
		visitors.forEach((s) -> System.out.println(s.getTicket().getVisitTime()));

		assertEquals(LocalDateTime.parse("2020-05-09T10:30:12"), (visitors.get(0).getTicket().getVisitTime()));
		assertEquals(LocalDateTime.parse("2021-01-08T14:30:14"), (visitors.get(1).getTicket().getVisitTime()));
		assertEquals(LocalDateTime.parse("2021-04-08T12:30:32"), (visitors.get(2).getTicket().getVisitTime()));

	}

}
