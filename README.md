# CyberShield - Cyber Crime Reporting & Tracking System

## Team Members

| Name | USN |
|------|-----|
| Anvith | 4MT24AI004 |
| Shukanth Kullampady | 4MT24AI019 |
| Lloyd Dsouza | 4MT24AI024 |
| Prajwal R Shenoy | 4MT24AI033 |
| Rashmitha Kundar | 4MT24AI040 |
| Sudeep U Nayak | 4MT24AI054 |
| Shivatmi D | 4MT24AI060 |

## Problem Statement

CyberShield is a comprehensive cyber crime reporting and tracking system that enables citizens to report cyber crimes (phishing, OTP fraud, fake websites) through a dedicated citizen portal. The system allows authorized cyber crime department officers to view, track, and update the status of complaints. The application provides cyber safety tips to educate users about common cyber threats and prevention measures.

## Technologies Used

- Java JDK 8 or above
- OOP Concepts
- Console Based Application

## OOP Concepts Used

- **Inheritance** - CyberCrime parent class with child classes (Phishing, OTPFraud, FakeWebsite)
- **Polymorphism** - Method overriding in crime reporting classes (reportCrime() method)
- **Interface** - Notification interface for sending notifications with EmailNotification implementation
- **Encapsulation** - Data hiding using access modifiers in User, Complaint, and CyberCrime classes
- **Static** - SafetyTips class with static methods, OFFICER_ID and OFFICER_PASSWORD static variables
- **Composition/Association** - User, Complaint, and CyberCrime objects used within main class
- **Abstraction** - Abstract behavior through interfaces and parent class methods

## Key Features

- **Citizen Portal**
  - Register cyber crime complaints
  - View personal complaints
  - Access cyber safety tips
  - View user profile

- **Cyber Crime Department Portal**
  - Secure login with Officer ID and Password
  - View all complaints
  - Update complaint status (Pending, Under Investigation, Resolved)

- **Crime Types Supported**
  - Phishing
  - OTP Fraud
  - Fake Website

## How To Run

**Compile:**
```
javac CyberShield.java
```

**Run:**
```
java CyberShield
```

**Default Department Login Credentials:**
- Officer ID: CYB101
- Password: admin123

## Submission Type

- Presented in Class
- YouTube Video

## YouTube Link 

https://youtube.com/your-video-link

---

**Course:** Object Oriented Concepts With Java Programming  
**Department:** Artificial Intelligence & Machine Learning  
**Semester:** IV  
**Institution:** Mangalore Institute of Technology & Engineering
