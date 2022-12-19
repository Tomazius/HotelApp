package lt.dassault.hotelapp.model.repository;

import lt.dassault.hotelapp.model.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findAll();
}
