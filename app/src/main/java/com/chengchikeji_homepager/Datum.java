package com.chengchikeji_homepager;

public class Datum {

    private String ID;
    private String SID;
    private String TITLE;
    private Object DESCR;
    private String IMGURL;
    private String ZRS;
    private String SYRS;
    private String JINDU;
    private String NAME;
    private String CATEID;

    public Datum(String ID, String SID, String TITLE, Object DESCR, String IMGURL, String ZRS, String SYRS, String JINDU, String NAME, String CATEID) {
        this.ID = ID;
        this.SID = SID;
        this.TITLE = TITLE;
        this.DESCR = DESCR;
        this.IMGURL = IMGURL;
        this.ZRS = ZRS;
        this.SYRS = SYRS;
        this.JINDU = JINDU;
        this.NAME = NAME;
        this.CATEID = CATEID;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "ID='" + ID + '\'' +
                ", SID='" + SID + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", DESCR=" + DESCR +
                ", IMGURL='" + IMGURL + '\'' +
                ", ZRS='" + ZRS + '\'' +
                ", SYRS='" + SYRS + '\'' +
                ", JINDU='" + JINDU + '\'' +
                ", NAME='" + NAME + '\'' +
                ", CATEID='" + CATEID + '\'' +
                '}';
    }

    /**
     * 
     * @return
     *     The ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 
     * @param ID
     *     The ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return
     *     The SID
     */
    public String getSID() {
        return SID;
    }

    /**
     * 
     * @param SID
     *     The SID
     */
    public void setSID(String SID) {
        this.SID = SID;
    }

    /**
     * 
     * @return
     *     The TITLE
     */
    public String getTITLE() {
        return TITLE;
    }

    /**
     * 
     * @param TITLE
     *     The TITLE
     */
    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    /**
     * 
     * @return
     *     The DESCR
     */
    public Object getDESCR() {
        return DESCR;
    }

    /**
     * 
     * @param DESCR
     *     The DESCR
     */
    public void setDESCR(Object DESCR) {
        this.DESCR = DESCR;
    }

    /**
     * 
     * @return
     *     The IMGURL
     */
    public String getIMGURL() {
        return IMGURL;
    }

    /**
     * 
     * @param IMGURL
     *     The IMGURL
     */
    public void setIMGURL(String IMGURL) {
        this.IMGURL = IMGURL;
    }

    /**
     * 
     * @return
     *     The ZRS
     */
    public String getZRS() {
        return ZRS;
    }

    /**
     * 
     * @param ZRS
     *     The ZRS
     */
    public void setZRS(String ZRS) {
        this.ZRS = ZRS;
    }

    /**
     * 
     * @return
     *     The SYRS
     */
    public String getSYRS() {
        return SYRS;
    }

    /**
     * 
     * @param SYRS
     *     The SYRS
     */
    public void setSYRS(String SYRS) {
        this.SYRS = SYRS;
    }

    /**
     * 
     * @return
     *     The JINDU
     */
    public String getJINDU() {
        return JINDU;
    }

    /**
     * 
     * @param JINDU
     *     The JINDU
     */
    public void setJINDU(String JINDU) {
        this.JINDU = JINDU;
    }

    /**
     * 
     * @return
     *     The NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * 
     * @param NAME
     *     The NAME
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * 
     * @return
     *     The CATEID
     */
    public String getCATEID() {
        return CATEID;
    }

    /**
     * 
     * @param CATEID
     *     The CATEID
     */
    public void setCATEID(String CATEID) {
        this.CATEID = CATEID;
    }

}
