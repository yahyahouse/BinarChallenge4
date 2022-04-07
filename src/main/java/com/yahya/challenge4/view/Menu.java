package com.yahya.challenge4.view;

import com.yahya.challenge4.controller.FilmsController;

import java.util.Scanner;

public class Menu {

    private FilmsController filmController;

    public void Menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("masukan nama film :");
        String nameFilm = scan.nextLine();
        System.out.println("tayang atau tidak :");
        String tayang = scan.nextLine();
        scan.close();
        filmController.addFilms(nameFilm, tayang);

    }
}
