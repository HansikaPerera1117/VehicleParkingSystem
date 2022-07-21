package view.tm;

public class InParkTM {
     private String vehicleNum;
     private String vehicleType;
     private int parkingSlot;
     private String parkedTime;

    public InParkTM() {
    }

    public InParkTM(String vehicleNum, String vehicleType, int parkingSlot, String parkedTime) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.parkedTime = parkedTime;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    @Override
    public String toString() {
        return "InParkTM{" +
                "vehicleNum='" + vehicleNum + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingSlot=" + parkingSlot +
                ", parkedTime='" + parkedTime + '\'' +
                '}';
    }
}
