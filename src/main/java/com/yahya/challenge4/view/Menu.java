package com.yahya.challenge4.view;

import com.yahya.challenge4.controller.FilmsController;

import java.util.Scanner;

public class Menu {

    private FilmsController filmController;

    public void Menu(){
        String nameFilm = "", tayang="";
        Scanner scan = new Scanner(System.in);
        System.out.println("masukan nama film :"+ scan.nextLine());
        System.out.println("tayang atau tidak :"+ scan.nextLine());
        scan.close();
        filmController.addFilms(nameFilm, tayang);

    }
}
