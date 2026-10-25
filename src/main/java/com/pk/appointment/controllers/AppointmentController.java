package com.pk.appointment.controllers;

import com.pk.appointment.services.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String showAppointments(Model model){
        model.addAttribute("appointments",appointmentService.getAppointmentList());
        return "appointments";
    }
}
