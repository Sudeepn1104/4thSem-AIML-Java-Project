public abstract class Person {
    private String personId;
    private String name;
    private int age;
    private String mobileNumber;
    private String email;

    public Person(String personId, String name, int age, String mobileNumber, String email) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public abstract String getRole();

    public void displayBasicDetails() {
        System.out.println("ID     : " + personId);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Mobile : " + mobileNumber);
        System.out.println("Email  : " + email);
        System.out.println("Role   : " + getRole());
    }
}
