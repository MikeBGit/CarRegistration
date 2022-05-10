package carRegistration;

import carRegistration.vehicleTypes.Diesel;
import carRegistration.vehicleTypes.SUV;
import carRegistration.vehicleTypes.Truck;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarRegistrationConfig.class);
        Service service = context.getBean(Service.class);
//        ------------------------------------------------------
//        Owner
        Owner mike = context.getBean(Owner.class);
        mike.setfName("Mike");
        mike.setlName("Baldessari");
        mike.setAddress("123 Fake Street");


//       Vehicle
        ICar dieselCar = context.getBean(Diesel.class);
//        Register the Car
       service.registerCar(mike,dieselCar);
//       Print Report
       service.getRegisteredVehicles().get(mike).printReport();
        System.out.println();
//        ------------------------------------------------------
//        Owner
        Owner tatiana = context.getBean(Owner.class);
        tatiana.setfName("Tatiana");
        tatiana.setlName("Marks");
        tatiana.setAddress("321 No Street");
//       Vehicle
        ICar miniSUV = context.getBean(SUV.class);
//        Register the Car
        service.registerCar(tatiana,miniSUV);
//       Print Report
        service.getRegisteredVehicles().get(tatiana).printReport();
        System.out.println();
//        ------------------------------------------------------
        //        Owner
        Owner luc = context.getBean(Owner.class);
        luc.setfName("Luc");
        luc.setlName("Phan");
        luc.setAddress("753 This Street");
//       Vehicle
        ICar bigTruck = context.getBean(Truck.class);
//        Register the Car
        service.registerCar(luc,bigTruck);



//       Print Report
        service.getRegisteredVehicles().get(luc).printReport();
        System.out.println();
        System.out.println(service);

        context.close();


    }
}
