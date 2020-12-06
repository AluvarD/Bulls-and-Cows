class User {
    private String firstName;
    private String lastName;
    private String fullName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (this.firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (this.lastName != null) {
            this.lastName = lastName;
        }
    }


    public String getFullName() {
        if (firstName != null && !"".equals(firstName)) {
            if (lastName != null && !"".equals(lastName)) {
                return firstName + " " + lastName;
            } else {
                return firstName;
            }
        } else if (lastName != null && !"".equals(lastName)) {
            return lastName;
        } else {
            return "Unknown";
        }
    }
}