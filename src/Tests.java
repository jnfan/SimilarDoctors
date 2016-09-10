import java.util.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
@SuppressWarnings("unused")

public class Tests extends TestCase {
	
	public void testDoctorListEmpty() {
		Doctor doc = new Doctor("aaaa", "Cardiology", 94040, 5);
		List<Doctor> doctorsList = new ArrayList<>();
		List<Doctor> resultList = new ArrayList<>();
		resultList.add(doc);
		assertEquals(resultList, DoctorFinder.findSimilarDoctors(doc, doctorsList));
	} 
	
	public void testNoDoctorInput() {
		List<Doctor> doctorsList = new ArrayList<>();
		assertEquals(null, DoctorFinder.findSimilarDoctors(null, doctorsList));
	}
	
	public void testOnlyOneDoctor() {
		Doctor doc = new Doctor("aaaa", "Cardiology", 94040, 5);
		List<Doctor> doctorsList = new ArrayList<>();
		doctorsList.add(doc);
		
		List<Doctor> resultList = new ArrayList<>();
		resultList.add(doc);
		
		assertEquals(resultList, DoctorFinder.findSimilarDoctors(doc, doctorsList));
	}
	
	public void testNormalCase() {
		Doctor doc = new Doctor("aaaa", "Cardiology", 94040, 5);
		Doctor doc1 = new Doctor("bbbb", "Dentistry", 94048, 3);
		Doctor doc2 = new Doctor("cccc", "Cardiology", 94538, 2);
		Doctor doc3 = new Doctor("dddd", "Neurology", 95051, 1);
		
		List<Doctor> doctorsList = new ArrayList<>();
		doctorsList.add(doc);
		doctorsList.add(doc1);
		doctorsList.add(doc2);
		doctorsList.add(doc3);
		
		List<Doctor> resultList = new ArrayList<>();
		resultList.add(doc);
		resultList.add(doc1);
		resultList.add(doc2);
		resultList.add(doc3);
		
		assertEquals(resultList, DoctorFinder.findSimilarDoctors(doc, doctorsList));	
	}
}
