package lt.dassault.hotelapp.model.repository;

import lt.dassault.hotelapp.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    List<Visit> findByVisitStatus(String status);
    Visit findByRoomVisit(int id);
    Visit findById(int id);
}
