package pl.sda.model;



public enum Gender {
    M("male"), F("female");

    private String gender;

    Gender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
