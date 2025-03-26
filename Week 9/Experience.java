class Experience extends Candidate {
    private int expInYear;
    private String proSkill;
    
    public Experience(String candidateId, String firstName, String lastName, String birthDate, String address, String phone, String email, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
}
