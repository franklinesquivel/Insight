/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Validation {
    
    public static String valStr(String msg, String title) {
        String aux = "";
        boolean flag = true;
        
        while(flag) {
            aux = JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
            
            if(aux.trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                flag = false;
            }
        }
        
        return aux;
    }
    
    public static String valStr(String msg, String title, String prevData) {
        String aux = "";
        boolean flag = true;
        
        while(flag) {
            aux = JOptionPane.showInputDialog(null, msg, prevData);
            
            if(aux.trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE, null);
            }else{
                flag = false;
            }
            
            if(flag){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return aux;
    }
    
    public static double valDbl(String msg, String title){
        String aux;
        double auxDbl = 0;
        boolean flag = true;
        
        while(flag) {
            aux = JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
            
            if(aux.trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    flag = false;
                    auxDbl = Double.parseDouble(aux);
                }catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                    flag = true;
                }
                
                if(flag){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return auxDbl;
    }
    
    public static int valInt(String msg, String title){
        String aux;
        int auxInt = 0;
        boolean flag = true;
        
        while(flag) {
            aux = JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
            
            if(aux.trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    flag = false;
                    auxInt = Integer.parseInt(aux);
                }catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                    flag = true;
                }
                
                if(flag){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return auxInt;
    }
    
    public static Date valDate(String msg, String title) throws ParseException{
        String aux;
        Date auxDate = null;
        boolean flag = true;
        Calendar cal = Calendar.getInstance();
        
        
        while(flag) {
            aux = JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
            
            if(aux.trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                    flag = false;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    sdf.setLenient(false);
                try{
                    auxDate = sdf.parse(aux);
                }catch(ParseException e){
                    System.out.println(e.getMessage());
                    flag = true;
                }
                
                if(flag){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return auxDate;
    }
    
    public static boolean valBool(String msg, String title){
        int r = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        return r == JOptionPane.YES_OPTION;
    }
    
}
