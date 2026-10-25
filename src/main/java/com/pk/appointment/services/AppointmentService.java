package com.pk.appointment.services;

import com.pk.appointment.model.Appointment;
import com.pk.appointment.model.Treatment;
import com.pk.appointment.repositories.AppointmentRepository;
import com.pk.appointment.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    private final TreatmentRepository treatmentRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(TreatmentRepository treatmentRepository, AppointmentRepository appointmentRepository) {
        this.treatmentRepository = treatmentRepository;
        this.appointmentRepository = appointmentRepository;
    }
    @Transactional
    public Appointment bookAppointment(String customerName,String phoneNumber, Long treatmentId , LocalDateTime startAppointment){
        Treatment treatment =treatmentRepository.findById(treatmentId).orElseThrow(() -> new IllegalArgumentException("Treatment not Found")) ;
        Appointment newAppointment= new Appointment(customerName,phoneNumber, treatment,startAppointment);
        if(appointmentRepository.existsByReserveStartLessThanAndReserveFinishGreaterThan(newAppointment.getReserveFinish(),newAppointment.getReserveStart())){
            throw new RuntimeException("Time is not Available");
        }
        return appointmentRepository.save(newAppointment);

    }
    public List<Appointment> getAppointmentList(){
        return appointmentRepository.findAllByOrderByReserveStartAsc();
    }
}
