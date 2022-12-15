package lt.dassault.hotelapp.controller;

import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RoomBuilding {

    @Autowired
    RoomRepository roomRepository;


}
