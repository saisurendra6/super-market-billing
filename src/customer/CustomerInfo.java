package customer;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
    public String name;
    private String phNo;
    public int points;

    public CustomerInfo(String name, String phNo, int points) {
        this.name = name;
        this.phNo = phNo;
        this.points = points;
    }

    public static CustomerInfo createFromString(String string) {
        String arr[] = string.split(",");
        return new CustomerInfo(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim()));
    }

    public String getName() {
        return name;
    }

    public String getPhNo() {
        return phNo;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "name= " + name + ", phNo= " + phNo + ", points= " + points;
    }
}
