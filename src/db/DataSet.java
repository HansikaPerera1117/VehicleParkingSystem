package db;

import model.*;

import java.util.ArrayList;

public class DataSet {
        public static ArrayList<Vehicle> vehicleDetails = new ArrayList();
        public static ArrayList<Driver> driverDetails = new ArrayList();
        public static ArrayList<InPark> inParkDetails = new ArrayList();
        public static ArrayList<OnDelivery> OnDeliveryDetails = new ArrayList();
        public static ArrayList<SlotNumber> slotNumbers = new ArrayList();

        static {

        //======================vehicles=================================================================================
                vehicleDetails.add(
                        new Vehicle("NA-3434","Bus",3500,60)
                );
                vehicleDetails.add(
                        new Vehicle("KA-4563","Van",1000,7)
                );
                vehicleDetails.add(
                        new Vehicle("58-3567","Van",1500,4)
                );
                vehicleDetails.add(
                        new Vehicle("GF-4358","Van",800,4)
                );
                vehicleDetails.add(
                        new Vehicle("CCB-3568","Van",1800,8)
                );
                vehicleDetails.add(
                        new Vehicle("LM-6679","Van",1500,4)
                );
                vehicleDetails.add(
                        new Vehicle("KB-3668","Cargo Lorry",2500,2)
                );
                vehicleDetails.add(
                        new Vehicle("JJ-9878","Cargo Lorry",3000,2)
                );
                vehicleDetails.add(
                        new Vehicle("GH-5772","Cargo Lorry",4000,3)
                );
                vehicleDetails.add(
                        new Vehicle("XY-4456","Cargo Lorry",3500,2)
                );
                vehicleDetails.add(
                        new Vehicle("YQ-3536","Cargo Lorry",2000,2)
                );
                vehicleDetails.add(
                        new Vehicle("CBB-3566","Cargo Lorry",2500,2)
                );


                //============================================Drivers======================================================
                driverDetails.add(
                        new Driver("Sumith Kumara","7835348345V","B6474845","Panadura",0725637456)
                );
                driverDetails.add(
                        new Driver("Amila Pathirana","8826253734V","B3354674","Galle",717573583)
                );
                driverDetails.add(
                        new Driver("Jithmal Perera","9283289272V","B3674589","Horana",0772452457)
                );
                driverDetails.add(
                        new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara",782686390)
                );
                driverDetails.add(
                        new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala",0772534436)
                );
                driverDetails.add(
                        new Driver("Awantha Fernando","9173537839V","B3554789","Colombo 5",0714534356)
                );
                driverDetails.add(
                        new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla",0771536662)
                );
                driverDetails.add(
                        new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa",0715353434)
                );
                driverDetails.add(
                        new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura",0772436737)
                );
                driverDetails.add(
                        new Driver("Dushantha Perera","9255556343V","B3334435","Matara",0777245343)
                );
                driverDetails.add(
                        new Driver("Sumith Udayanga","8735354355V","B3573783","Galle",0703635442)
                );
                driverDetails.add(
                        new Driver("Dinesh Udara","9026344373V","B5343783","Hettimulla",713456878)
                );
                driverDetails.add(
                        new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa",0772442444)
                );
                driverDetails.add(
                        new Driver("Mohommad Riaz","9124537733V","B3638537","Kaluthara",0777544222)
                );
                driverDetails.add(
                        new Driver("Sandun Kumara","9563524267V","B2263333","Panadura",0772325544)
                );


                //============================================Slot numbers======================================================

                slotNumbers.add(
                        new SlotNumber("1","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("2","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("3","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("4","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("5","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("6","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("7","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("8","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("9","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("10","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("11","Cargo Lorry","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("12","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("13","Van","Not Use")
                );
                slotNumbers.add(
                        new SlotNumber("14","Bus","Not Use")
                );

        }


}
