
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RALC
 */
public class Reina extends Piezas{
    String figura;
    public Reina() {
    }

    public Reina(boolean color) {
        super(color);
        if (color) {
            figura = "♔";
        }else{
            figura = "♚";
        }
    }

    @Override
    public String toString() {
        return figura ;
    }

    @Override
    public int[][] movimiento(int x, int y, Piezas[][] tablero) {
        int cont = 0;
        int cont_e = 0;
        int [][] pos = new int [8][16];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                pos[i][j] = -1;
            }
        }
        for (int i = x-1; i >=0 ; i--) {
            if (tablero[i][y]== null || (tablero[i][y].getColor() != this.color && cont_e == 0)) {
                if (cont_e==0) {
                    pos[0][cont] = i;
                    pos[0][cont+1] = y;
                    cont += 2;
                }
                if (tablero[i][y] != null) {
                    if (tablero[i][y].getColor() != this.color) {
                    cont_e = 1;
                }
                }
                
            }else{
                break;
            }
        }
        cont =0;
        cont_e = 0;
        for (int i = x+1; i < 8; i++) {
            if (tablero[i][y]== null || (tablero[i][y].getColor() != this.color && cont_e == 0)) {
                if (cont_e==0) {
                    pos[1][cont] = i;
                    pos[1][cont+1] = y;
                    cont += 2;
                }
                if (tablero[i][y] != null) {
                    if (tablero[i][y].getColor() != this.color) {
                    cont_e = 1;
                }
                }
            }else{
                break;
            }
        }
        cont =0;
        cont_e = 0;
        for (int i = y-1; i >= 0; i--) {
            if (tablero[x][i]== null || (tablero[x][i].getColor() != this.color && cont_e == 0)) {
                if (cont_e==0) {
                    pos[2][cont] = x;
                    pos[2][cont+1] = i;
                    cont += 2;
                }
                if (tablero[x][i] != null) {
                    if (tablero[x][i].getColor() != this.color) {
                    cont_e = 1;
                }
                }
            }else{
                break;
            }
        }
        cont = 0;
        cont_e = 0;
        for (int i = y+1; i < 8; i++) {
            if (tablero[x][i]== null || (tablero[x][i].getColor() != this.color && cont_e == 0)) {
                if (cont_e==0) {
                    pos[3][cont] = x;
                    pos[3][cont+1] = i;
                    cont += 2;
                }
                if (tablero[x][i] != null) {
                    if (tablero[x][i].getColor() != this.color) {
                    cont_e = 1;
                }
                }
            }else{
                break;
            }
        }
        //alfin
        int j = y;
        cont = 0;
        cont_e = 0;
        //diagonal superior derecha
        for (int i = x; i >= 0; i--) {
            if ((i - 1 >= 0) && (j + 1 < 8)) {
                if (tablero[i - 1][j + 1] == null) {
                    if (cont_e==0) {
                        pos[4][cont] = i-1;
                        pos[4][cont+1] = j+1;
                        cont+=2;
                    }
                    
                }else if (tablero[i-1][j+1].getColor() != this.color){
                    if (cont_e ==0) {
                        pos[4][cont] = i-1;
                        pos[4][cont+1] = j+1;
                        cont+=2;
                        cont_e = 1;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            } else {
                break;
            }
            j++;
        }
        j = y;
        cont = 0;
        cont_e = 0;
        //Diagonal superior izquierda
        for (int i = x; i >= 0; i--) {
            if ((i - 1 >= 0) && (j - 1 >= 0)) {
                if (tablero[i - 1][j - 1] == null) {
                    if (cont_e==0) {
                        pos[5][cont] = i-1;
                        pos[5][cont+1] = j-1;
                        cont+=2;
                    }
                }else if (tablero[i-1][j-1].getColor() != this.color){
                    if (cont_e ==0) {
                        pos[5][cont] = i-1;
                        pos[5][cont+1] = j-1;
                        cont+=2;
                        cont_e = 1;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            } else {
                break;
            }
            j--;
        }
        //diagonlas inferior derecha
        j = y;
        cont = 0;
        cont_e = 0;
        for (int i = x; i <8 ; i++) {
            if ((i + 1 <8) && (j + 1 < 8)) {
                if (tablero[i + 1][j + 1] == null) {
                    if (cont_e==0) {
                        pos[6][cont] = i+1;
                        pos[6][cont+1] = j+1;
                        cont+=2;
                    }
                }else if (tablero[i+1][j+1].getColor() != this.color){
                    if (cont_e ==0) {
                        pos[6][cont] = i+1;
                        pos[6][cont+1] = j+1;
                        cont+=2;
                        cont_e = 1;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            } else {
                break;
            }
            j++;
        }
        
        //diagonasl inferior izquierda
        j = y;
        cont = 0;
        cont_e = 0;
        for (int i = x; i < 7; i++) {
            if ((i + 1 >= 0) && (j - 1 >= 0)) {
                if (tablero[i + 1][j - 1] == null) {
                    if (cont_e==0) {
                        pos[7][cont] = i+1;
                        pos[7][cont+1] = j-1;
                        cont+=2;
                    }
                }else if (tablero[i+1][j-1].getColor() != this.color){
                    if (cont_e ==0) {
                        pos[7][cont] = i+1;
                        pos[7][cont+1] = j-1;
                        cont+=2;
                        cont_e = 1;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            } else {
                break;
            }
            j--;
        }
        
        return pos;
    }
        
        
    }

