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
    
    public static void main(String[] args) throws ParseException {
        boolean replay = true;
        Main.addStudentDefault(); //Agregamos los alumnos por defecto
        while(replay){
            String opc = JOptionPane.showInputDialog("Menú \n A. Agregar Alumno \n B. Registrar Materia \n C. Mostrar CUM \n D. Mostrar Materias Aprobadas \n E. Mostrar todas las materias \n F. Ver Información \n G. Salir");
        
            switch(opc.toUpperCase()){
                case "A": //Ingresar Alumno
                    String auxId = Validation.valStr("Ingrese el carnet del estudiante: ", "Carnet");
                    String auxName = Validation.valStr("Ingrese el nombre del estudiante: ", "Nombre");
                    Date birthdate = Validation.valDate("Ingrese la fecha de nacimiento de alumno (dd-mm-yyyy): ", "Fecha de nacimiento");
                    List<Subject> subjects = new ArrayList<>();
                    
                    Main.addStudent(new Student(auxId, subjects, auxName, birthdate));
                    JOptionPane.showMessageDialog(null, "El estudiante ha sido registrado éxitosamente!", "Registro completo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "B": //Ingresar materia
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        Main.addSubject(Main.selectStudent());
                        JOptionPane.showMessageDialog(null, "Materia registrada éxitosamente!", "Insight", JOptionPane.INFORMATION_MESSAGE);
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
                        Main.showSubjectsApproved(Main.selectStudent());
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
                case "F": //Ver información estudiante
                    if(Main.isStudentEmpty()){ //Mostramos un JOptionPane con la lista de estudiantes
                        Main.showInfo(Main.selectStudent());
                    }else{
                        System.out.println("|-------------------------------------------------------------");
                        System.out.println("|                Favor agregar estudiantes                   |");
                        System.out.println("|-------------------------------------------------------------");
                    }
                    break;
                case "G":
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
