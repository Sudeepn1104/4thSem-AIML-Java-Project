import java.util.*;

class Engineer {
    String Name, USN, Branch, ID;
    int Semester;
    double Marks;
}

class admin extends Engineer {

    void create(int count, String a, Scanner sc) {
        System.out.println("Enter " + a + " Name :");
        Name = sc.next();

        System.out.println("Enter " + a + " USN :");
        USN = sc.next();

        System.out.println("Enter " + a + " Branch :");
        Branch = sc.next();

        System.out.println("Enter " + a + " Semester :");
        Semester = sc.nextInt();

        System.out.println("Enter " + a + " Marks :");
        Marks = sc.nextDouble();

        System.out.println(a + " " + (count + 1) + " Details Entered...");
        System.out.println("----------------------------------------");
    }

    void create_td(int count, String a, Scanner sc) {
        System.out.print("Enter " + a + " Name :");
        Name = sc.next();

        System.out.print("Enter " + a + " ID : ");
        ID = sc.next();

        System.out.println("Enter " + a + " Branch :");
        Branch = sc.next();

        System.out.println(a + " " + (count + 1) + " Details Entered...");
        System.out.println("----------------------------------------");
    }
}

class teacher extends admin {
    void teacherDetails() {
        System.out.println("Name : " + Name);
        System.out.println("ID : " + ID);
        System.out.println("Branch : " + Branch);
    }
}

class student extends admin {

    void StudentDetails() {
        System.out.println("Name : " + Name);
        System.out.println("USN : " + USN);
        System.out.println("Branch : " + Branch);
        System.out.println("Marks : " + Marks);
        System.out.println("Semester : " + Semester);
    }

    void EditStudentDetails(double m) {
        Marks = m;
    }
}

public class EducationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("-------- EDUCATION SYSTEM --------");

        System.out.println("Enter Total Student Strength :");
        int size = sc.nextInt();
        student[] ad = new student[size];

        System.out.println("Enter Total Teacher Strength :");
        int size_td = sc.nextInt();
        teacher[] adtd = new teacher[size_td];

        int exiter = 1;

        do {

            System.out.println("\nEnter Your Role:");
            System.out.println("1.Student");
            System.out.println("2.Teacher");
            System.out.println("3.Admin");
            System.out.println("4.Exit");

            int role = sc.nextInt();

            switch (role) {

                case 1:

                    System.out.println("Student Login...");
                    System.out.print("Enter Name : ");
                    String username_st = sc.next();

                    System.out.print("Enter Password (USN) : ");
                    String pass_st = sc.next();

                    int count = 0;

                    for (int j = 0; j < ad.length; j++) {

                        if (ad[j] == null)
                            continue;

                        if (username_st.equalsIgnoreCase(ad[j].Name)) {

                            count++;

                            if (pass_st.equals(ad[j].USN)) {

                                System.out.println("\nLogin Successful...");
                                ad[j].StudentDetails();

                            } else {
                                System.out.println("Invalid Password...");
                            }
                        }
                    }

                    if (count == 0) {
                        System.out.println("Username Not Found...");
                    }

                    break;

                case 2:

                    System.out.println("Faculty Login...");
                    System.out.print("Enter Name : ");
                    String username = sc.next();

                    System.out.print("Enter Password : ");
                    String password = sc.next();

                    int flag = 0;

                    for (int j = 0; j < adtd.length; j++) {

                        if (adtd[j] == null)
                            continue;

                        if (username.equalsIgnoreCase(adtd[j].Name)) {

                            flag++;

                            if (password.equals(adtd[j].ID)) {

                                System.out.println("Login Successful...");

                                int emit = 1;

                                while (emit == 1) {

                                    System.out.println("\n1.Faculty Profile");
                                    System.out.println("2.Edit Student Marks");
                                    System.out.println("3.Back");

                                    int ch = sc.nextInt();

                                    switch (ch) {

                                        case 1:
                                            adtd[j].teacherDetails();
                                            break;

                                        case 2:

                                            System.out.print("Enter Student USN : ");
                                            String edit_usn = sc.next();

                                            int ct = 0;

                                            for (int k = 0; k < ad.length; k++) {

                                                if (ad[k] == null)
                                                    continue;

                                                if (edit_usn.equals(ad[k].USN)) {

                                                    ct++;

                                                    System.out.println("Editing "+ ad[k].Name);

                                                    System.out.print("Enter New CGPA : ");

                                                    double M = sc.nextDouble();

                                                    ad[k].EditStudentDetails(M);

                                                    System.out.println("Marks Updated Successfully.");

                                                    break;
                                                }
                                            }

                                            if (ct == 0) {
                                                System.out.println("USN Not Found...");
                                            }

                                            break;

                                        case 3:
                                            emit = 0;
                                            break;

                                        default:
                                            System.out.println("Invalid Option...");
                                    }
                                }

                            } else {
                                System.out.println("Invalid Password...");
                            }
                        }
                    }

                    if (flag == 0) {
                        System.out.println("Username Not Found...");
                    }

                    break;

                case 3:

                    System.out.println("Admin Login...");
                    System.out.print("Enter Password (123): ");

                    int pass = sc.nextInt();

                    if (pass == 123) {

                        System.out.println("Admin Login Successful...");

                        System.out.println("1.Student Entry");
                        System.out.println("2.Teacher Entry");

                        int key = sc.nextInt();

                        if (key == 1) {

                            System.out.print("How many students to add? ");
                            int n1 = sc.nextInt();

                            n1 = Math.min(n1, ad.length);

                            for (int i = 0; i < n1; i++) {

                                ad[i] = new student();
                                ad[i].create(i, "Student", sc);
                            }

                        } else if (key == 2) {

                            System.out.print("How many teachers to add? ");
                            int n2 = sc.nextInt();

                            n2 = Math.min(n2, adtd.length);

                            for (int i = 0; i < n2; i++) {

                                adtd[i] = new teacher();
                                adtd[i].create_td(i, "Faculty", sc);
                            }

                        } else {
                            System.out.println("Invalid Option...");
                        }

                    } else {
                        System.out.println("Wrong Password...");
                    }

                    break;

                case 4:
                    exiter = 0;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Role...");
            }

        } while (exiter == 1);

        sc.close();
    }
}