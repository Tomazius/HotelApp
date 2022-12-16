package lt.dassault.hotelapp.service;

import lt.dassault.hotelapp.model.entity.Room;
import lt.dassault.hotelapp.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UnusedExtras {

/*
    @Autowired
    RoomRepository roomRepository;

    public boolean isRoom1Occupied(){
        Room room1 = roomRepository.findById(1);
        return room1.getGuestAtRoom() == null;
    }
    public boolean isRoom2Occupied(){
        Room room2 = roomRepository.findById(2);
        return room2.getGuestAtRoom() == null;
    }
    public boolean isRoom3Occupied(){
        Room room3 = roomRepository.findById(3);
        return room3.getGuestAtRoom() == null;
    }
    public boolean isRoom4Occupied(){
        Room room4 = roomRepository.findById(4);
        return room4.getGuestAtRoom() == null;
    }
    public boolean isRoom5Occupied(){
        Room room5 = roomRepository.findById(5);
        return room5.getGuestAtRoom() == null;
    }
*/

    /*List<Visit> visitList = visitRepository.findAll();
        visitRepository.findByVisitStatus("Active");

        Room room1 = roomRepository.findByRoomNumber("101");
        model.addAttribute("roomStatus", room1.getRoomStatus());
        if(room1.getGuestAtRoom() == null){
            room1.setRoomStatus("Vacant");
        }
        else{
            room1.setRoomStatus("Occupied");
        }
        roomRepository.save(room1);  //savina visus o ne 1

        Room room2 = roomRepository.findByRoomNumber("102");
        model.addAttribute("roomStatus", room2.getRoomStatus());
        if(room2.getGuestAtRoom() == null){
            room2.setRoomStatus("Vacant");
        }
        else{
            room2.setRoomStatus("Occupied");
        }

        Room room3 = roomRepository.findByRoomNumber("103");
        model.addAttribute("roomStatus", room3.getRoomStatus());
        if(room3.getGuestAtRoom() == null){
            room3.setRoomStatus("Vacant");
        }
        else{
            room3.setRoomStatus("Occupied");
        }

        Room room4 = roomRepository.findByRoomNumber("104");
        model.addAttribute("roomStatus", room4.getRoomStatus());
        if(room4.getGuestAtRoom() == null){
            room4.setRoomStatus("Vacant");
        }
        else{
            room4.setRoomStatus("Occupied");
        }


        Room room5 = roomRepository.findByRoomNumber("105");
        model.addAttribute("roomStatus", room5.getRoomStatus());
        if(room5.getGuestAtRoom() == null){
            room5.setRoomStatus("Vacant");
        }
        else{
            room5.setRoomStatus("Occupied");
        }*/

    /*
        Room room = roomRepository.findById(id);
        model.addAttribute("guestAtRoom", room.getGuestAtRoom());
        if(room.getGuestAtRoom() == null){
            System.out.println("if teigiamas");
        Guest newGuest = new Guest();
        model.addAttribute("newGuest", newGuest);
            System.out.println("daeina iki čia");;
            return "booking_form";
        }
        else{
            System.out.println("if eina else");
            return "room_occupied";
        }
*/


}
