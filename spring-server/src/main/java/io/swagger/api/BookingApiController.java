package io.swagger.api;

import io.swagger.Service.BookingService;
import io.swagger.model.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-30T00:10:05.092Z")

@Controller
public class BookingApiController implements BookingApi {

    private static final Logger log = LoggerFactory.getLogger(BookingApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private BookingService bookingService;

    @org.springframework.beans.factory.annotation.Autowired
    public BookingApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBooking(@ApiParam(value = "Booking object that needs to be add" ,required=true )  @Valid @RequestBody Booking body) {
        bookingService.saveBooking(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteBooking(@ApiParam(value = "Booking object that needs to be deleted" ,required=true )  @Valid @RequestBody Booking body) {
        try {
            bookingService.deleteBooking(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Booking>> findAllBooking() {
        List<Booking> bookings = bookingService.findAll();
        if(bookings.size()==0){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(bookings);
        }
    }

    public ResponseEntity<List<Booking>> findBookingByBusNumber(@ApiParam(value = " Bus Number that need to be considered for filter",required=true) @PathVariable("busNumber") String busNumber) {
        List<Booking> bookings = bookingService.findByBusNumber(busNumber);
        if(bookings.size()==0)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(bookings);
        }

    }

    public ResponseEntity<List<Booking>> findBookingByphone(@ApiParam(value = " phone Number that need to be considered for filter",required=true) @PathVariable("phone") String phone) {

        List<Booking> bookings = bookingService.findByPhone(phone);
        if(bookings.size()==0)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(bookings);
        }
    }

    public ResponseEntity<Void> updateBooking(@ApiParam(value = "Booking object that needs to be added" ,required=true )  @Valid @RequestBody Booking body) {
        try {
            bookingService.updateBooking(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Void> deleteListOfBooking(@ApiParam(value = " Phone required for find list of list of booking",required=true) @PathVariable("phone") String phone,@ApiParam(value = " noOfbooking is required for deleteing the number of booking",required=true) @PathVariable("noOfBooking") Integer noOfBooking) {

        List<Booking> bookings = bookingService.findByPhone(phone);
        if(bookings.size()<noOfBooking)
        {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else {
            bookingService.listOfDelete(phone,noOfBooking);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

}
