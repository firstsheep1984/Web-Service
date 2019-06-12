package ca.masoud.jaxb.Jaxb_xml_to_java;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.mydomain.patient.Patient;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		try {
			
			// Create an object ......................
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Masoud");
			//........................................

			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			Unmarshaller unMarshaller = context.createUnmarshaller();

			StringWriter writer = new StringWriter();
			
			
			// Java object to xml ....................
			marshaller.marshal(patient, writer);
			System.out.println("marshaller (Java object to xml): \n" + writer.toString());
			//........................................

			
			// xml to Java object ....................
			Patient patientResult = (Patient) unMarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.print("\nunmarshaller (xml to Java object): \n" + patientResult.getId() + ", " + patientResult.getName());
			//........................................

		} catch (JAXBException e) {
			System.out.println(e.toString());
		}
	}
}
