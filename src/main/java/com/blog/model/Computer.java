package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "computer")
public class Computer {
	@Column(name = "computerid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;

    @Column(name = "model_name")
    private String modelName;

    private String ram;

    @Column(name = "hard_disk")
    private String hardDisk;

    @Column(name = "computer_status")
    @JsonIgnore
    private String computerStatus = "Free";

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getComputerStatus() {
        return computerStatus;
    }

    @JsonIgnore
    public void setComputerStatus(String computerStatus) {
        this.computerStatus = computerStatus;
    }

    public Long getComputerId() {
        return computerId;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Computer(Long computerId, String modelName, String ram, String hardDisk) {
        this.computerId = computerId;
        this.modelName = modelName;
        this.ram = ram;
        this.hardDisk = hardDisk;
    }

    public Computer() {
        this.computerStatus = "Free";
    }

    @Override
    public String toString() {
        return "Computer [computerId=" + computerId + ", modelName=" + modelName + ", ram=" + ram + ", hardDisk="
                + hardDisk + "]";
    }
}
