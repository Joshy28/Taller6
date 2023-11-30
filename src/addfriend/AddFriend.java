/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addfriend;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddFriend {

    public static void addContact(String newName, long newNumber) {
        try {
            String nameNumberString = newName + "!" + String.valueOf(newNumber);

            File file = new File("C:\\Users\\jorge\\OneDrive\\Escritorio\\POO\\friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Set the file pointer at the end of the file
            raf.seek(raf.length());

            // Add the contact in a new line
            raf.writeBytes(nameNumberString);
            raf.writeBytes(System.lineSeparator());

            System.out.println("Contact added.");

            raf.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
