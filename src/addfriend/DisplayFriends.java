/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addfriend;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DisplayFriends {

    public static void displayContacts() {
        try {
            String nameNumberString;
            String name;
            long number;

            File file = new File("C:\\Users\\jorge\\OneDrive\\Escritorio\\POO\\friendsContact.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Mueve el puntero al inicio del archivo
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                if (nameNumberString == null) break; // Manejo de EOF
                String[] lineSplit = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // En lugar de imprimir en la consola, llamamos al método para actualizar la lista en la GUI
                VentanaPrincipal.updateContactList("Friend Name: " + name + "\n" + "Contact Number: " + number);
            }

            raf.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
