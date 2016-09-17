/* This project is to find similar doctors.
 * Given a doctor, provides a list of similar doctors, in a prioritized order. 
 * 
 */

import java.util.*;
import java.util.Map.Entry;

public class DoctorFinder {
	 // fields
	List<Doctor> doctorsList;
	
	//constructor	
	public DoctorFinder() {
		doctorsList = new ArrayList<Doctor>();
	}
	
	//method to find similar doctors
	public static List<Doctor> findSimilarDoctors(Doctor doctorX, List<Doctor> docList) {
		List<Doctor> similarDoctors = new ArrayList<>();
		Map<Doctor, Double> overThresholdEntries = new HashMap<>();
		double threshold = 0.4999; //only doctors with similar scores over this threshold will be printed out
		PriorityQueue<Double> overThreshold = new PriorityQueue<Double>(1, new Comparator<Double>() {		
			public int compare(Double x, Double y) {
				if (x < y) return 1;
				if(x > y) return -1;
				else return 0;
			}
		}); // built a reversed-order priority queue which is a max heap
	
		/*
		 * for each doctor in the doctors database, calculate his similar score between him and the argument doctor
		 * using the two doctor's zip codes, specialties and review scores
		 */
		for(Doctor d : docList) {
			double distance = getDistance(doctorX.getZipCode(), d.getZipCode());		
			double specialtySimilarity = getSpecialtySimilarity(doctorX.getSpecialty(), d.getSpecialty());		
			double similarScore = getsimilarScore(distance, specialtySimilarity, doctorX.getReviewScore(), d.getReviewScore());
			
			//only keep those doctors with similar scores over the threshold
			if(similarScore > threshold) {
				overThreshold.offer(similarScore);
				overThresholdEntries.put(d, similarScore);
			}
			
			//use the max heap to sort similar scores and save the corresponding doctor to the result list
			for(int i = 0; i < overThreshold.size(); i++) {
				Double score = overThreshold.poll();
				for (Entry<Doctor, Double> entry : overThresholdEntries.entrySet()) {
			        if (Objects.equals(score, entry.getValue())) {
			        	similarDoctors.add(entry.getKey());
			        }
			    }
			}
		}
		return similarDoctors;		
	}
	
	//assume this method can calculate distance between two zip codes
	//here just uses an example algorithm to calculate it, it should use a more complicated algorithm
	private static double getDistance(int zip1, int zip2) {
		double distance = 10 * Math.abs(zip1 - zip2);
		return distance;
	}
	
	//assume this method can calculate similarity between two strings for doctors' specific specialty
	//here just uses an example algorithm to calculate it
	private static double getSpecialtySimilarity(String s1, String s2) {
		double specialtySimilarity = 1.0 * (s1.compareTo(s2)); //here should use medical categories to calculate this similarity
		return specialtySimilarity;
	}
	
	//assume this method can calculate similar score using two doctors' distance, specialty similarity, review scores
	//here just uses an example algorithm to calculate it, it should use a more complicated algorithm
	private static double getsimilarScore(double distance, double specialtySimilarity, int mainReviewSocre, int reviewScore) {
		double similarScore = 0.5 * distance + 0.4 * specialtySimilarity + 0.1 * Math.abs(mainReviewSocre - reviewScore);
		return similarScore;
	}
	
	public static void main(String[] args) {
		//the doctor who you want to find similar doctors as
		Doctor doctorX = new Doctor("Alex", "Cardiology", 94040, 5); 
		
		//create a sample doctor list, to simplify only use few case
		Doctor doc1 = new Doctor("Brad", "Neurology", 95051, 1);
		Doctor doc2 = new Doctor("Chris", "Dentistry", 94043, 3);
		DoctorFinder example = new DoctorFinder();
		example.doctorsList.add(doctorX);
		example.doctorsList.add(doc1);
		example.doctorsList.add(doc2);
		
		//print out similar doctors
		List<Doctor> result = new ArrayList<>(findSimilarDoctors(doctorX, example.doctorsList));
		System.out.println(result.get(0).getName());
		System.out.println(result.get(1).getName());
	}
}
