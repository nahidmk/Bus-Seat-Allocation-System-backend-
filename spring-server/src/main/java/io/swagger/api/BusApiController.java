package io.swagger.api;

import io.swagger.Service.BusService;
import io.swagger.model.Bus;
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
public class BusApiController implements BusApi {

    private static final Logger log = LoggerFactory.getLogger(BusApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private BusService busService;

    @org.springframework.beans.factory.annotation.Autowired
    public BusApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBus(@ApiParam(value = "Bus object that needs to be add" ,required=true )  @Valid @RequestBody Bus body) {
        busService.saveBus(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteBus(@ApiParam(value = "Bus object that needs to be deleted" ,required=true )  @Valid @RequestBody Bus body) {
        try {
            busService.deleteBus(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Bus>> findAll() {
        List<Bus> buses = busService.findAll();
        if(buses.size()==0)
        {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(buses);
        }
    }

    public ResponseEntity<Bus> findBusByBusNumber(@ApiParam(value = " Bus Number that need to be considered for filter",required=true) @PathVariable("busNumber") String busNumber) {
        Bus bus = busService.findByBusNumber(busNumber);
        if(bus!=null)
        {
            return ResponseEntity.ok(bus);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> updateBus(@ApiParam(value = "Bus object that needs to be added" ,required=true )  @Valid @RequestBody Bus body) {
        try {
            busService.updateBus(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
