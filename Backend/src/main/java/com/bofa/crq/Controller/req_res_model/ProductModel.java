package com.bofa.crq.Controller.req_res_model;

import lombok.Data;

@Data
public class ProductModel {
    private String release_name;
    private String CRQ;
    private String status;
    private Long rating;

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

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getRating() {
        return this.rating;
    }
}
