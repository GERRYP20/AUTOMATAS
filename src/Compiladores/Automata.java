/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compiladores;

/**
 *
 * @author gabup
 */
public class Automata
{
    static final int s0 = 0;
    static final int s2 = 2;
    static final int s3 = 3;
    static final int s4 = 4;
    static final int s5 = 5;
    static final int s6 = 6;
    static final int s7 = 7;
    static final int s8 = 8;
    static final int s9 = 9;
    static final int s10 = 10;
    int etiqueta=0;
    public String etiquetar(String cadena)
    {
        etiqueta=0;
        int estado = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            switch (estado) {
                case s0:
                    if (caracter == '\"') {
                        estado = s2;
                    } else if (caracter == '\'') {
                        estado = s5;
                    } else if (verificaCaracteres(caracter)) {
                        estado = s10;
                    } else if (verificaDigitos(caracter)) {
                        estado = s7;
                    }
                    else{
                        return error2(estado);
                    }
                    break;
                case s2:
                    if (verificaCaracteres(caracter) || verificaDigitos(caracter)) {
                        estado = s3;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s3:
                    if (verificaCaracteres(caracter) || verificaDigitos(caracter)) {
                        estado = s3;
                    } else if (caracter == '\"') {
                        estado = s4;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s4:

                    break;
                case s5:
                    if (verificaCaracteres(caracter) || verificaDigitos(caracter)) {
                        estado = s6;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s6:
                    if (verificaCaracteres(caracter) || verificaDigitos(caracter)) {
                        estado = s6;
                    } else if (caracter == '\'') {
                        estado = s4;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s7:
                    if (verificaDigitos(caracter)) {
                        estado = s7;
                    } else if (caracter == '.') {
                        estado = s8;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s8:
                    if (verificaDigitos(caracter)) {
                        estado = s9;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s9:
                    if (verificaDigitos(caracter)) {
                        estado = s9;
                    }else{
                        return error2(estado);
                    }
                    break;
                case s10:
                    if (verificaCaracteres(caracter) || verificaDigitos(caracter)) {
                        estado = s10;
                    }else{
                        return error2(estado);
                    }
                    break;
            }
        }
        switch (estado) {
            case s4:
                etiqueta=53;
                return 53+ " Cadena";
            case s7:
                etiqueta=50;
                return 50+ " Numero";
            case s9:
                etiqueta=51;
                return 51+ " Decimal";
            case s10:
                etiqueta=52;
                return 52+ " Identificador";
            default:
                return error(estado);
        }

    }

    public boolean verificaCaracteres(char caracter)
    {
        if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z') || caracter==' ') {
            return true;
        }
        return false;
    }
    
   

    public boolean verificaDigitos(char caracter)
    {
        
        if ((caracter >= '0' && caracter <= '9')) {
            return true;
        }
        return false;
    }

    public String error(int caso)
    {
        switch (caso) {
            case s0:
                etiqueta=100;
                return "Error "+100;
            case s2:
                etiqueta=101;
                return "Error "+101;
            case s3:
                etiqueta=102;
                return "Error "+102;
            case s5:
                etiqueta=104;
                return "Error "+104;
            case s6:
                etiqueta=105;
                return "Error "+105;
            case s8:
                etiqueta=107;
                return "Error "+107;
        }
        return "Error "+0;
    }
    
        public String error2(int caso)
    {
        switch (caso) {
            case s0:
                etiqueta=100;
                return "Error "+100;
            case s2:
                etiqueta=101;
                return "Error "+101;
            case s3:
                etiqueta=102;
                return "Error "+102;
            case s4:
                etiqueta=103;
                return "Error "+103;
            case s5:
                etiqueta=104;
                return "Error "+104;
            case s6:
                etiqueta=105;
                return "Error "+105;
            case s7:
                etiqueta=106;
                return "Error "+106;
            case s8:
                etiqueta=107;
                return "Error "+107;
            case s9:
                etiqueta=108;
                return "Error "+108;
            case s10:
                etiqueta=109;
                return "Error "+109;
        }
        return "Error "+0;
    }
}
