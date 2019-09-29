package com.ap.app.repository;
import com.ap.app.entity.TicketBooking;
import com.ap.app.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long>{
    List<TicketBooking> findByCustomer(Customer customer);
    TicketBooking findById(long id);
}

