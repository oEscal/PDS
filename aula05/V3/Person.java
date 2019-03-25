package aula05.V3;

public class Person
{
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String salutation;
    private final String suffix;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomeOwner;

    private Person(
            final String newLastName,
            final String newFirstName,
            final String newMiddleName,
            final String newSalutation,
            final String newSuffix,
            final String newStreetAddress,
            final String newCity,
            final String newState,
            final boolean newIsFemale,
            final boolean newIsEmployed,
            final boolean newIsHomeOwner) {

        this.lastName = newLastName;
        this.firstName = newFirstName;
        this.middleName = newMiddleName;
        this.salutation = newSalutation;
        this.suffix = newSuffix;
        this.streetAddress = newStreetAddress;
        this.city = newCity;
        this.state = newState;
        this.isFemale = newIsFemale;
        this.isEmployed = newIsEmployed;
        this.isHomeOwner = newIsHomeOwner;
    }

    public static class Builder{

        private final String lastName;
        private final String firstName;
        private String middleName;
        private String salutation;
        private String suffix;
        private String streetAddress;
        private String city;
        private String state;
        private boolean isFemale;
        private boolean isEmployed;
        private boolean isHomeOwner;

        public Builder(String newFirstName, String newLastName) {

            this.firstName = newFirstName;
            this.lastName = newLastName;
        }

        public Builder middleName (String newMiddleName) {

            this.middleName = newMiddleName;
            return this;
        }

        public Builder salutation (String newSalutation) {

            this.salutation = newSalutation;
            return this;
        }

        public Builder suffix (String newSuffix) {

            this.suffix = newSuffix;
            return this;
        }

        public Builder streetAddress (String newStreetAddress) {

            this.streetAddress = newStreetAddress;
            return this;
        }

        public Builder city (String newCity) {

            this.city = newCity;
            return this;
        }

        public Builder state (String newState) {

            this.state = newState;
            return this;
        }

        public Builder isFemale (boolean newIsFemale) {

            this.isFemale = newIsFemale;
            return this;
        }

        public Builder isEmployed (boolean newIsEmployed) {

            this.isEmployed = newIsEmployed;
            return this;
        }

        public Builder isHomewOwner (boolean newIsHomewOwner) {

            this.isHomeOwner = newIsHomewOwner;
            return this;
        }

        public Person getPerson () {

            return new Person(
                    lastName,
                    firstName,
                    middleName,
                    salutation,
                    suffix,
                    streetAddress,
                    city,
                    state,
                    isFemale,
                    isEmployed,
                    isHomeOwner
            );
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salutation='" + salutation + '\'' +
                ", suffix='" + suffix + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomeOwner=" + isHomeOwner +
                '}';
    }
}
