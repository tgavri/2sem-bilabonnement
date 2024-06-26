package dk.kea.bilabonnement.model;

import java.sql.Time;
import java.util.Date;

public class Lejeaftale {
    // lavet af Jannick
    private String licensePlate;
    private int Lejeaftale_id;
    private String chassisNumber;
    private Date dato;
    private String Udlejnings_Type;
    private Time Afhentningstidspunkt;
    private String Afhentningssted;
    private int Kunde_id;
    private int udlejningsperiode;
    private String brand;
    private String carModel;
    private String status;


    public Lejeaftale() {
    }

    public Lejeaftale(int lejeaftale_id, String chassisNumber, Date dato, String udlejnings_Type, Time afhentningstidspunkt, String afhentningssted, int kunde_id) {
        Lejeaftale_id = lejeaftale_id;
        this.chassisNumber = chassisNumber;
        this.dato = dato;
        Udlejnings_Type = udlejnings_Type;
        Afhentningstidspunkt = afhentningstidspunkt;
        Afhentningssted = afhentningssted;
        Kunde_id = kunde_id;
    }
    public Lejeaftale(int lejeaftale_id, String chassisNumber, Date dato, String udlejnings_Type, Time afhentningstidspunkt, String afhentningssted, int kunde_id, String licensePlate) {

        Lejeaftale_id = lejeaftale_id;
        this.chassisNumber = chassisNumber;
        this.dato = dato;
        Udlejnings_Type = udlejnings_Type;
        Afhentningstidspunkt = afhentningstidspunkt;
        Afhentningssted = afhentningssted;
        Kunde_id = kunde_id;
        this.licensePlate = licensePlate;
    }
    public Lejeaftale(String chassisNumber, Date dato, String udlejnings_Type, Time afhentningstidspunkt, String afhentningssted, int kunde_id, String licensePlate, String status, int udlejningsperiode) {
        this.chassisNumber = chassisNumber;
        this.dato = dato;
        Udlejnings_Type = udlejnings_Type;
        Afhentningstidspunkt = afhentningstidspunkt;
        Afhentningssted = afhentningssted;
        Kunde_id = kunde_id;
        this.licensePlate = licensePlate;
        this.status = status;
        this.udlejningsperiode = udlejningsperiode;
    }

    public int getLejeaftale_id() {
        return Lejeaftale_id;
    }

    public void setLejeaftale_id(int lejeaftale_id) {
        Lejeaftale_id = lejeaftale_id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getUdlejnings_Type() {
        return Udlejnings_Type;
    }

    public void setUdlejnings_Type(String udlejnings_Type) {
        Udlejnings_Type = udlejnings_Type;
    }

    public Time getAfhentningstidspunkt() {
        return Afhentningstidspunkt;
    }

    public void setAfhentningstidspunkt(Time afhentningstidspunkt) {
        Afhentningstidspunkt = afhentningstidspunkt;
    }

    public String getAfhentningssted() {
        return Afhentningssted;
    }

    public void setAfhentningssted(String afhentningssted) {
        Afhentningssted = afhentningssted;
    }

    public int getKunde_id() {
        return Kunde_id;
    }

    public void setKunde_id(int kunde_id) {
        Kunde_id = kunde_id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate () {
        return this.licensePlate;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand () {
        return this.brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getStatus() {return this.status;}
    public void setStatus(String status) {this.status = status;}

    public int getUdlejningsperiode() {
        return udlejningsperiode;
    }
    public void setUdlejningsperiode(int udlejningsperiode) {
        this.udlejningsperiode = udlejningsperiode;
    }
}