package com.bofa.crq.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Column(name = "release_name")
    private String release_name;

    @Id
    @Column(name = "crq")
    private String CRQ;

    private String status;

    public String getRelease_name() {
        return release_name;
    }

    public void setRelease_name(String release_name) {
        this.release_name = release_name;
    }

    public String getCRQ() {
        return CRQ;
    }

    public void setCRQ(String CRQ) {
        this.CRQ = CRQ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRating() {
        return rating;
    }

    private Long rating;

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
