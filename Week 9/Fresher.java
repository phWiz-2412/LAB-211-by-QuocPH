class Fresher extends Candidate {
    private String graduationDate, graduationRank, education;
    
    public Fresher(String candidateId, String firstName, String lastName, String birthDate, String address, String phone, String email, String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
}
