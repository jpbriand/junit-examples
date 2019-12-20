package xyz.howtoprogram.junit5.timeout;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class TestOrderService {

	@Test
	void doPaymentNotExceed15Seconds() {
		OrderService orderService = new OrderService();
		// This method runs in 10 seconds
		assertTimeout(ofSeconds(15), orderService::doPayment);
	}

	@Test
	void doPaymentExceed5Seconds() {
		OrderService orderService = new OrderService();
		// This method runs in 10 seconds
		assertTimeout(ofSeconds(5), orderService::doPayment, "The doPayment method take more than 5 seconds");
	}

	@Test
	void printShippingLabelExceeded15SecondsWithPreemptiveTermination() {
		OrderService orderService = new OrderService();
		// This method takes 20 seconds to run
		assertTimeoutPreemptively(ofSeconds(15), orderService::printShippingLabel, () -> "The printShippingLabel method took more than 15 seconds and was aborted.");
	}
}
