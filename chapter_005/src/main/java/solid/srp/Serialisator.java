package solid.srp;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface Serialisator {

    String serialisat(List<Employee> list) throws JAXBException;
    List<Employee> deserialisat() throws JAXBException;

}
