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
        Boolean replay = true;
        Main.addStudentDefault(); //Agregamos los alumnos por defecto
        while(replay){
            String opc = JOptionPane.showInputDialog("Menú \n A. Agregar Alumno \n B. Registrar Materia \n C. Mostrar CUM \n D. Mostrar Materias Aprobadas \n E. Mostrar todas las materias \n F. Salir");
        
            switch(opc.toUpperCase()){
                case "A": //Ingresar Alumno
                    String auxId = Validation.valStr("Ingrese el carnet del estudiante: ", "Carnet");
                    String auxName = Validation.valStr("Ingrese el nombre del estudiante: ", "Nombre");
                    Date birthdate = Validation.valDate("Ingrese la fecha de nacimiento de alumno (dd-mm-yyyy): ", "Fecha de nacimiento");
                    List<Subject> subjects = new ArrayList<>();
                    
                    Main.addStudent(new Student(auxId, subjects, auxName, birthdate));
                    JOptionPane.showMessageDialog(null, "El estudiante ha sido registrado éxitosamente!", "Registro completo", JOptionPane.INFORMATION_MESSAGE);
                    Main.showStudents();
                    break;
                case "B": //Ingresar materia
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        
                        //Obtenemos los datos de la materia a ingresar
                        String name = Validation.valStr("Ingrese nombre de la materia", "Nombre");
                        Double grade;
                        do{
                            grade = Validation.valDbl("Ingrese la nota obtenida", "Nota");
                        }while(grade < 0 || grade >10);
                        int uv = Validation.valInt("Ingrese las unidades valorativas", "UV");
                        Main.addSubject(Main.selectStudent(),  new Subject(name, grade, uv));
                    }else{
                        System.out.println("|-------------------------------------------------------------");
                        System.out.println("|                Favor agregar estudiantes                   |");
                        System.out.println("|-------------------------------------------------------------");
                    }
                    break;
                case "C": //Mostrar CUM según alumno
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        Main.showCum(Main.selectStudent());
                    }else{
                        System.out.println("|-------------------------------------------------------------");
                        System.out.println("|                Favor agregar estudiantes                   |");
                        System.out.println("|-------------------------------------------------------------");
                    }
                    break;
                case "D": //Mostrar Materias aprobadas según alumno
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        Main.showSubjectsAproved(Main.selectStudent());
                    }else{
                        System.out.println("|-------------------------------------------------------------");
                        System.out.println("|                Favor agregar estudiantes                    |");
                        System.out.println("|-------------------------------------------------------------");
                    }
                    break;
                case "E": //Mostrar todas las materias según alumno
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        Main.showSubjects(Main.selectStudent());
                    }else{
                        System.out.println("|-------------------------------------------------------------");
                        System.out.println("|                Favor agregar estudiantes                   |");
                        System.out.println("|-------------------------------------------------------------");
                    }
                    break;
                case "F":
                    replay = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Incorrecta!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        System.exit(0);
    }
}
