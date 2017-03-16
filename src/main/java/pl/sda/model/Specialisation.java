package pl.sda.model;

public enum Specialisation {
    MED("Medicine"), IT("IT"), MGMT("Management"), LAW("Law");

    private String specialisation;

    Specialisation(String specialisation){
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }

}
