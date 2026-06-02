public class Admin extends Person {
    private String adminId;
    private String role;

    public Admin(String personId, String name, int age, String mobileNumber, String email, String adminId, String role) {
        super(personId, name, age, mobileNumber, email);
        this.adminId = adminId;
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    public String getRole() {
        return role;
    }
}
