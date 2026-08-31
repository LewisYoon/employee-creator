// package io.nology.employee_creator;

// import java.util.Random;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.server.ResponseStatusException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;

// @RestController
// @RequestMapping("/orders")
// public class OrderController {
// private final Logger log = LogManager.getLogger(OrderController.class);
// private final Random rand = new Random();

// @GetMapping("/{id}")
// public ResponseEntity<String> getFakeOrder(@PathVariable int id) {
// // fake timeout - make it feel like a real app
// try {
// Thread.sleep(rand.nextInt(200));
// } catch (InterruptedException e) {
// Thread.currentThread().interrupt();
// }

// // things break randomly
// if (rand.nextInt(5) == 0) {
// log.error("Failed to find order #{} - order api timeout", id);
// throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
// "Timeout");
// }

// log.info("Found order #{}", id);
// return ResponseEntity.ok("Order # " + id + " - soy flat white");
// }

// }
