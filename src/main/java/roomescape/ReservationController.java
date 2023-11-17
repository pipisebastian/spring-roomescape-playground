package roomescape;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ReservationController {
    private final List<Reservation> reservations = new ArrayList<>();
    private final AtomicLong index = new AtomicLong(1);

    @GetMapping("/reservation")
    public String reservation(Model model) {
        if (reservations.isEmpty()) {
            reservations.add(new Reservation(index.getAndIncrement(), "브라운", LocalDate.of(2023, 1, 1), LocalTime.of(10, 0, 0)));
            reservations.add(new Reservation(index.getAndIncrement(), "브라운", LocalDate.of(2023, 1, 2), LocalTime.of(11, 0, 0)));
            reservations.add(new Reservation(index.getAndIncrement(), "브라운", LocalDate.of(2023, 1, 3), LocalTime.of(12, 0, 0)));
        }

        return "reservation";
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> read() {
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }


}