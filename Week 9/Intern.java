class Intern extends Candidate {
    private String majors, semester, universityName;
    
    public Intern(String candidateId, String firstName, String lastName, String birthDate, String address, String phone, String email, String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
}
