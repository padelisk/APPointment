package com.pk.appointment.repositories;

import com.pk.appointment.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
