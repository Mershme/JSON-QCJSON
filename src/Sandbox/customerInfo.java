package Sandbox;

import java.io.Serializable;

//Implements Serializable
public class customerInfo implements Serializable {

 // Private attributes
 private String firstName;
 private String lastName;
 private String phoneNumber;
 private String email;

 public customerInfo(){}


 // Constructor
 public customerInfo(String firstName, String lastName, String phoneNumber, String email)
 {
     this.firstName = firstName;
     this.lastName = lastName;
     this.phoneNumber = phoneNumber;
     this.email = email;
 }

 // All getters and setters
 public String getFirstName() {
     return firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }
}
