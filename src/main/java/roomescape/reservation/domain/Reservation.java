package roomescape.reservation.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;



public class Reservation {
    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public Reservation(){
    }

    public Reservation(Long id, String name, LocalDate date, LocalTime time){
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public LocalDate getDate(){
        return date;
    }
    public Optional<String> getTime() {
        return Optional.ofNullable(time)
                .map(t -> t.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public static Reservation toEntity(Reservation reservation, Long id) {
        return new Reservation(id, reservation.name, reservation.date, reservation.time);
    }

}