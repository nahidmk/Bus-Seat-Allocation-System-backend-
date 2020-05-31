package io.swagger.Repository;

import io.swagger.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findBookingsByBusNumber(String busNumber);
    public List<Booking> findBookingsByPhone(String phone);
}
