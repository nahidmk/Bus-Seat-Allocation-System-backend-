package BookingTesting;

import io.swagger.Service.BookingService;
import io.swagger.Service.BusService;
import io.swagger.model.Booking;
import io.swagger.model.Bus;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.threeten.bp.LocalDate;

import java.util.List;

@SpringBootTest
public class BookingTest {

    @Autowired
    private BookingService service;

    public Booking GenarateBooking(long id, String name, String phone, String busNumber, LocalDate date, Booking.PaymentTypeEnum paymentTypeEnum, String seatNumber)
    {
        Booking booking = new Booking();
        booking.setId(id);
        booking.setName(name);
        booking.setPhone(phone);
        booking.setBusNumber(busNumber);
        booking.setDate(date);
        booking.setPaymentType(paymentTypeEnum);
        booking.setSeatNumber(seatNumber);
        return booking;
    }
    Booking booking1 = GenarateBooking(1,"nahid","+008","16A", LocalDate.now(), Booking.PaymentTypeEnum.NAGAD,"16A.1");


    @Test
    public void addBooking(){
        System.out.println("Add booking");

        List<Booking> bookings = service.findAll();
        System.out.println(bookings);

        service.saveBooking(booking1);

        Booking booking = service.findbyid(booking1.getId());

        Assert.assertEquals(booking,booking1);
        System.out.println("add done");

    }

}
