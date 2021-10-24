package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "doggyclub")
@XmlAccessorType(XmlAccessType.FIELD)

public class DoggyClub {

    @XmlAttribute
    private boolean pedegree;

    @XmlAttribute
    private int numberAwards;

    @XmlAttribute
    private String breed;

    @XmlAttribute
    private String[] dogSize;

    private NickName nickName;




    public DoggyClub(boolean pedegree, int numberAwards, String breed,
                     String[] dogSize, NickName nickName) {
                this.pedegree = pedegree;
        this.numberAwards = numberAwards;
        this.breed = breed;
        this.dogSize = dogSize;
        this.nickName = nickName;
    }

    public DoggyClub() {
    }

    @Override
    public String toString() {
        return "DoggyClub{"
                + "pedegree=" + pedegree
                + ", numberAwards=" + numberAwards
                + ", breed='" + breed + '\''
                + ", dogNames=" + Arrays.toString(dogSize)
                + ", nickName=" + nickName
                + '}';
    }

    public static void main(String[] args) throws Exception {
       DoggyClub doggyClub = new DoggyClub(true, 3, "giant schnauzer",
                new String[]{"small", "medium", "large"}, new NickName("Star", 5));
        /**
         *получаем контекст для доступа к АПИ
         */

        JAXBContext context = JAXBContext.newInstance(DoggyClub.class);
        /**
         *Создаем сериализатор
          */

        Marshaller marshaller = context.createMarshaller();
        /**
         *Указываем что нам нужно форматирование
          */

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(doggyClub, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            DoggyClub doggyClub1 = (DoggyClub) unmarshaller.unmarshal(reader);
            System.out.println(doggyClub1);

        }
    }
}
