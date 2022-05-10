package carRegistration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;


@Component
@Scope("singleton")

public class Service {

   private HashMap<Owner,ICar> registeredVehicles = new HashMap<>();


   void registerCar(Owner owner, ICar vehicle){
      registeredVehicles.put(owner,vehicle);
   }

   public HashMap<Owner, ICar> getRegisteredVehicles() {
      return registeredVehicles;
   }

   @PostConstruct
   private void postConstruct() {
      System.out.println("Service-Launched");
   }

   @PreDestroy
   public void preDestroy() {
      System.out.println("Service Destroyed");
   }

   @Override
   public String toString() {
      return
              "registeredVehicles= \n" + registeredVehicles +
              '}';
   }

}
