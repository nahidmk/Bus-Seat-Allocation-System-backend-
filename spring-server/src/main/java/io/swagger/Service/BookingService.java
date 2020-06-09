package io.swagger.Service;

import io.swagger.Repository.BookingRepository;
import io.swagger.api.NotFoundException;
import io.swagger.model.Booking;
import io.swagger.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public long count(){
        return bookingRepository.count();
    }

    public Booking findbyid(Long id)
    {
        return bookingRepository.findOne(id);
    }

    public void listOfDelete(String phone, String busNumber, int noOfBooking)
    {
        List<Booking> bookings = bookingRepository.findBookingsByPhoneAndBusNumber(phone,busNumber);
        List<Booking> bookingList = new ArrayList<>();
        for(int i = 1;i<=noOfBooking;i++)
        {
            bookingList.add(bookings.get(bookings.size()-i));
        }
        bookingRepository.deleteInBatch(bookingList);
    }

    public List<Booking> findBookingByphoneAndBusNumber(String phone, String busNumber){
        return bookingRepository.findBookingsByPhoneAndBusNumber(phone,busNumber);
    }

    public void addBusList(List<Booking> bookings)
    {
        bookingRepository.save(bookings);
    }
}
