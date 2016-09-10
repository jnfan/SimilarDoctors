public class Doctor {
	//fields
	private String name;
	private String specialty;
	private int reviewScore;
	private int zipCode;
	
	//Constructor
	public Doctor(String doctorName, String doctorSpecialty, int doctorReviewScore, int doctorZipCode) {
		name = doctorName;
		specialty = doctorSpecialty;
		reviewScore = doctorReviewScore;
		zipCode = doctorZipCode;
	}
	
	public void setName(String doctorName) {
		name = doctorName;
	}
	public String getName() {
		return name;
	}
	
	public void setSpecialty(String doctorSpecialty) {
		specialty = doctorSpecialty;
	}
	public String getSpecialty() {
		return specialty;
	}
	
	public void setReviewScore(int doctorReviewScore) {
		reviewScore = doctorReviewScore;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	
	public void setZipCode(int doctorZipCode) {
		zipCode = doctorZipCode;
	}
	public int getZipCode() {
		return zipCode;
	}
}
