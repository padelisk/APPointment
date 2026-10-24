package com.pk.appointment.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;
    private LocalDateTime reserveStart;
    private LocalDateTime reserveFinish;


    public  Appointment(String name, String phoneNumber, Treatment treatment, LocalDateTime date){
        this.customerName =name;
        this.phoneNumber=phoneNumber;
        this.treatment=treatment;
        this.reserveStart =date;
        computeReserveFinish();
    }
    public Appointment(){

    }
    private void computeReserveFinish(){
        if (treatment!=null && reserveStart!=null){
            reserveFinish=reserveStart.plusMinutes(treatment.getDurationInMinutes());
        }

    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
        computeReserveFinish();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReserveStart() {
        return reserveStart;
    }

    public void setReserveStart(LocalDateTime date) {
        this.reserveStart=date;
        computeReserveFinish();
    }

    public LocalDateTime getReserveFinish() {
        return reserveFinish;
    }


}
