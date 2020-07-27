package com.nd.abs.ui.module.main.bean;

public class MyCertificateBean {

    /**
     * certificateId : 10000
     * certificatePath : aaa.jpg
     * createUser : 10010
     * createdStamp : 2020-06-12 03:59:18
     * createdTxStamp : 2020-06-12 03:59:18
     * lastUpdatedStamp : 2020-06-12 03:59:18
     * lastUpdatedTxStamp : 2020-06-12 03:59:18
     */

    private String certificateId;
    private String certificatePath;
    private String createUser;
    private String createdStamp;
    private String createdTxStamp;
    private String lastUpdatedStamp;
    private String lastUpdatedTxStamp;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(String createdStamp) {
        this.createdStamp = createdStamp;
    }

    public String getCreatedTxStamp() {
        return createdTxStamp;
    }

    public void setCreatedTxStamp(String createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    public String getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(String lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public String getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(String lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }
}
