package io.swagger.Repository;

import io.swagger.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findBookingsByBusNumber(String busNumber);
    public List<Booking> findBookingsByPhone(String phone);
    public List<Booking> findBookingsByPhoneAndBusNumber(String phone, String busNumber);
}
