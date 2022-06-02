public class Airport {
    private int bizId;
    private String bizName;
    private String address;
    private String city;

    // constructor for editing an entry:
    public Airport(int bizId, String bizName, String address, String city) {
        this.bizId = bizId;
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    // constructor for a new entry:
    public Airport(String bizName, String address, String city) {
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public Airport() {
    }

    public int getBizId() {
        return bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBizId(int bizId) {
        this.bizId = bizId;


    }
}
