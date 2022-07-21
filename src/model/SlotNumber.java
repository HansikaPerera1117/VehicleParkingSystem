package model;

public class SlotNumber {
     private String slotNumber;
     private String vehicleType;
     private String slotStatus;

    public SlotNumber() {
    }

    public SlotNumber(String slotNumber, String vehicleType, String slotStatus) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.slotStatus = slotStatus;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    @Override
    public String toString() {
        return "SlotNumber{" +
                "slotNumber='" + slotNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", slotStatus='" + slotStatus + '\'' +
                '}';
    }
}
