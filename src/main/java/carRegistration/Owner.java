package carRegistration;// POJO Class

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Owner {

    private String fName;
    private String lName;
    private String address;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Owner-Constructed");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Owner-Destroy");
    }

    @Override
    public String toString() {
        return  fName + '\'' +
                lName + '\'' +
                address + '\'' +
                '}';
    }
}
