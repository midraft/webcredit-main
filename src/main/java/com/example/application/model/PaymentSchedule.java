package com.example.application.model;

import org.apache.commons.codec.language.DaitchMokotoffSoundex;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Модель данных для взаимодействия приложение с базой данных.
 */
@Entity
@Table(name = "PAYMENTSCHEDULE")

public class PaymentSchedule {
   /* @NotNull
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "paymentId", unique = true)*/
    @Id
    private String paymentId;

    @JoinColumn(name = "number")
    private int number;
    private Date date;
    private Double monthlyPaymentFormat;
    private Double percentFormat;
    private Double mainDebtFormat;
    private Double remainder;
    @Column(name = "personId",nullable=false)
    private UUID personId = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clients_clientid")
    private Clients clients;

    public PaymentSchedule() {

    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    /**
     * Внешний ключь для зависимости график платежей к клиенту
     */


    public PaymentSchedule(String paymentId, int number, Date date, double monthlyPaymentFormat, double percentFormat, double mainDebtFormat, double remainder) {
        this.paymentId = paymentId;
        this.number = number;
        this.date = date;
        this.monthlyPaymentFormat = monthlyPaymentFormat;
        this.percentFormat = percentFormat;
        this.mainDebtFormat = mainDebtFormat;
        this.remainder = remainder;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void  setPaymentId(String paymentId){ this.paymentId = paymentId;}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMonthlyPaymentFormat() {
        return monthlyPaymentFormat;
    }

    public void setMonthlyPaymentFormat(Double monthlyPaymentFormat) {
        this.monthlyPaymentFormat = monthlyPaymentFormat;
    }

    public Double getPercentFormat() {
        return percentFormat;
    }

    public void setPercentFormat(Double percentFormat) {
        this.percentFormat = percentFormat;
    }

    public Double getMainDebtFormat() {
        return mainDebtFormat;
    }

    public void setMainDebtFormat(Double mainDebtFormat) {
        this.mainDebtFormat = mainDebtFormat;
    }

    public Double getRemainder() {
        return remainder;
    }

    public void setRemainder(Double remainder) {
        this.remainder = remainder;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    @Override
    public String toString(){

        return"models.Client{" +
                "paymentId=" + paymentId +
                ", number='" + number + '\'' +
                ", date=" + date + '\'' +
                ", monthlyPaymentFormat=" + monthlyPaymentFormat + '\'' +
                ", percentFormat=" + percentFormat + '\'' +
                ", mainDebtFormat=" + mainDebtFormat + '\'' +
                ", remainder=" + remainder +
                '}';
    }



}
