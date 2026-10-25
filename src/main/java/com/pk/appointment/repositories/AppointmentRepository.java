package com.pk.appointment.repositories;

import com.pk.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    boolean existsByReserveStartLessThanAndReserveFinishGreaterThan(LocalDateTime newFinish, LocalDateTime newStart);
    List<Appointment> findAllByOrderByReserveStartAsc();

}
