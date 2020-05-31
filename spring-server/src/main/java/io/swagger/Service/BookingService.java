package io.swagger.Service;

import io.swagger.Repository.BookingRepository;
import io.swagger.api.NotFoundException;
import io.swagger.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll()
    {
        return bookingRepository.findAll();
    }

    public void saveBooking(Booking booking)
    {
        bookingRepository.save(booking);
    }

    public void deleteBooking(Booking booking) throws NotFoundException {
        if(bookingRepository.findBookingsByPhone(booking.getPhone()).size()!=0) {
            bookingRepository.delete(booking);
        }else
        {
            throw new NotFoundException(404,"notFount");
        }
    }

    public void updateBooking(Booking booking) throws NotFoundException {
        if(bookingRepository.findBookingsByPhone(booking.getPhone()).size()!=0){
            bookingRepository.save(booking);
        }else{
            throw new NotFoundException(404,"notFount");
        }
    }

    public List<Booking> findByPhone(String phone)
    {
       return bookingRepository.findBookingsByPhone(phone);
    }

    public List<Booking> findByBusNumber(String busNumber){
        return bookingRepository.findBookingsByBusNumber(busNumber);
    }

    public Booking findbyid(Long id)
    {
        return bookingRepository.findOne(id);
    }

    public void listOfDelete(String phone, int noOfBooking)
    {
        List<Booking> bookings = bookingRepository.findBookingsByPhone(phone);
        for(int i = 0;i<noOfBooking;i++)
        {
            bookings.remove(i);
        }
        bookingRepository.deleteInBatch(bookings);
    }
}
