package controller;

import model.Contact;
import model.ReaderWriterCSV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    List<Contact> contactList = new ArrayList<Contact>();
    public final  String FILE_PATH = "src/storage/contacts.csv";

    public void showAllContact() {
        if (contactList.isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        for (Contact c : contactList) {
            System.out.println(c.getPhoneNumber() + "\t" + c.getGroup() + "\t" + c.getName() + "\t" + c.getGender() + "\t" + c.getAddress());
        }
    }

    public void addNewContact(Contact contact) {
        if (contactList.isEmpty()) {
            contactList.add(contact);
            System.out.println("Success!");
            return;
        }
        for (Contact c : contactList) {
            if (c.getPhoneNumber() == contact.getPhoneNumber()) {
                System.out.println("Phone number already exist!");
                return;
            }
        }
        contactList.add(contact);
        System.out.println("Success!");

    }


    public void editContact(Contact contact) {
        if (contactList.isEmpty()) {
            System.out.println("Empty!");
            return;
        }

        for (int i = 0; i < contactList.size(); i++) {
            if (contact.getPhoneNumber() == contactList.get(i).getPhoneNumber()) {
                contactList.set(i, contact);
                System.out.println("Success!");
                return;
            }
        }
        System.out.println("Phone number not found!");
    }

    public void deleteContact(int phoneNumber) {

        if (contactList.isEmpty()) {
            System.out.println("Empty!");
            return;
        }

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber() == phoneNumber) {
                contactList.remove(i);
                System.out.println("Success!");
                return;
            }
        }
        System.out.println("Phone number not found!");

    }

    public void findContact(int phoneNumber){
        for (Contact c : contactList){
            if (c.getPhoneNumber()==phoneNumber){
                System.out.println(c);
                return;
            }
        }
        System.out.println("Number not found!");
    }

    public void writeToFile(){
        ReaderWriterCSV.writeFile(contactList);

    }
    public void readToFile(){
        contactList = ReaderWriterCSV.readFile();
    }


}
