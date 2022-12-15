package lt.dassault.hotelapp.controller;

import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    @Autowired
    RoomRepository roomRepository;


}
