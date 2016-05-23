package com.chengchikeji_bannerdata;

public class Datum {

    private String ID;
    private String AID;
    private String TITLE;
    private String TYPE;
    private String CONTENT;
    private String URL;
    private String CHECKED;
    private String ADDTIME;
    private String ENDTIME;

    public Datum(String ID, String AID, String TITLE, String TYPE, String CONTENT, String URL, String CHECKED, String ADDTIME, String ENDTIME) {
        this.ID = ID;
        this.AID = AID;
        this.TITLE = TITLE;
        this.TYPE = TYPE;
        this.CONTENT = CONTENT;
        this.URL = URL;
        this.CHECKED = CHECKED;
        this.ADDTIME = ADDTIME;
        this.ENDTIME = ENDTIME;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "ID='" + ID + '\'' +
                ", AID='" + AID + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", CONTENT='" + CONTENT + '\'' +
                ", URL='" + URL + '\'' +
                ", CHECKED='" + CHECKED + '\'' +
                ", ADDTIME='" + ADDTIME + '\'' +
                ", ENDTIME='" + ENDTIME + '\'' +
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
     *     The AID
     */
    public String getAID() {
        return AID;
    }

    /**
     * 
     * @param AID
     *     The AID
     */
    public void setAID(String AID) {
        this.AID = AID;
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
     *     The TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * 
     * @param TYPE
     *     The TYPE
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * 
     * @return
     *     The CONTENT
     */
    public String getCONTENT() {
        return CONTENT;
    }

    /**
     * 
     * @param CONTENT
     *     The CONTENT
     */
    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    /**
     * 
     * @return
     *     The URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * 
     * @param URL
     *     The URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * 
     * @return
     *     The CHECKED
     */
    public String getCHECKED() {
        return CHECKED;
    }

    /**
     * 
     * @param CHECKED
     *     The CHECKED
     */
    public void setCHECKED(String CHECKED) {
        this.CHECKED = CHECKED;
    }

    /**
     * 
     * @return
     *     The ADDTIME
     */
    public String getADDTIME() {
        return ADDTIME;
    }

    /**
     * 
     * @param ADDTIME
     *     The ADDTIME
     */
    public void setADDTIME(String ADDTIME) {
        this.ADDTIME = ADDTIME;
    }

    /**
     * 
     * @return
     *     The ENDTIME
     */
    public String getENDTIME() {
        return ENDTIME;
    }

    /**
     * 
     * @param ENDTIME
     *     The ENDTIME
     */
    public void setENDTIME(String ENDTIME) {
        this.ENDTIME = ENDTIME;
    }

}
