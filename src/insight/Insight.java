/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insight;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import middle.earth.Main;
import middle.earth.academic.Student;
import middle.earth.academic.Subject;
import middle.earth.validation.Validation;

/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Insight {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        String opc = "A";
        
        switch(opc){
            case "A":
                String auxId = Validation.valStr("Ingrese el carnet del estudiante: ", "Carnet");
                String auxName = Validation.valStr("Ingrese el nombre del estudiante: ", "Nombre");
                Date birthdate = Validation.valDate("Ingrese la fecha de nacimiento de alumno (dd-mm-yyyy): ", "Fecha de nacimiento");
                List<Subject> subjects = new ArrayList<>();
                
                //if(Validation.valBool("Deseas ingresar las materias del estudiante?", "Ingresar materias")){
                    
                //}
                
                Main.addStudent(new Student(auxId, subjects, auxName, birthdate));
                JOptionPane.showMessageDialog(null, "El estudiante ha sido registrado éxitosamente!", "Registro completo", JOptionPane.INFORMATION_MESSAGE);
                Main.showStudents();
                break;
        }
    }
    
}
