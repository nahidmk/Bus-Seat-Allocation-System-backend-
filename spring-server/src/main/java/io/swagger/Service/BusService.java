package io.swagger.Service;

import io.swagger.Repository.BusRepository;
import io.swagger.api.NotFoundException;
import io.swagger.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> findAll()
    {
        return busRepository.findAll();
    }

    public void saveBus( Bus bus)
    {
        busRepository.save(bus);
    }

    public void updateBus(Bus bus) throws NotFoundException {
        if(busRepository.exists(bus.getBusNumber()))
        {
            busRepository.save(bus);
        }else
        {
            throw new NotFoundException(404,"not found");
        }
    }

    public void deleteBus(String busNumber) throws NotFoundException {
        if(busRepository.exists(busNumber))
        {
            busRepository.delete(busNumber);
        }else
        {
            throw new NotFoundException(404,"not found");
        }
    }

    public Bus findByBusNumber(String busNumber){
        return busRepository.findOne(busNumber);
    }


}
