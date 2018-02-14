package middle.earth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import middle.earth.academic.Student;
import middle.earth.validation.Validation;
import java.util.List;
import javax.swing.JOptionPane;
import middle.earth.academic.Subject;
/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Main {
    private static final List<Student> STUDENTS = new ArrayList(); //Propiedad: + Lista de Estudiantes
    
    //Método para añadir un estudiante
    public static void addStudent(Student _s){
        Main.STUDENTS.add(_s);
    }
    
    public static void addStudentDefault(){
        List<Subject> subjects = new ArrayList();
        subjects.add(new Subject("Quimica", 8, 4));
        subjects.add(new Subject("Algebra", 7, 3));
        subjects.add(new Subject("Matemática 2", 9, 4));
        STUDENTS.add(new Student("EG171989",subjects , "Franklin Esquivel", new Date(1998, 9, 23)));
        STUDENTS.add(new Student("LC171998", subjects, "Leonardo López", new Date(1999, 4, 9)));
        STUDENTS.add(new Student("LT171979", subjects, "Diego Lemus", new Date(1999, 4, 7)));
    }
    
    //Método para mostrar a todos los estudiantes registrados
    public static void showStudents(){
        System.out.println("|------------------------------------------");
        Main.STUDENTS.forEach((_s) -> {
            System.out.println("\n|\t* Carnet: " + _s.getId() + "\n|\t* Nombre: " + _s.getName() + "\n|\t* Fecha de nacimiento: " + new SimpleDateFormat("yyyy-MM-dd").format(_s.getBirthdate()) + "\n\n > ");
        });
    }
    
    public static List<Student> getStudents(){//Método que devuele la list de los estudiantesa agregadas por el momento
        return STUDENTS;
    }
    
    public static void addSubject(Student student){
        //Obtenemos los datos de la materia a ingresar
        String name = Validation.valStr("Ingrese nombre de la materia", "Nombre");
        Double grade;
        do{
            grade = Validation.valDbl("Ingrese la nota obtenida", "Nota");
        }while(grade < 0 || grade >10);
        int uv = Validation.valInt("Ingrese las unidades valorativas", "UV");
        student.addSubject(new Subject(name, grade, uv));
    }
    
    public static void showSubjectsApproved(Student student){
        student.showApprovedSubjects();
    }
    
    public static Student selectStudent(){ //Mostramos un control para seleccionar el alumno y regresamos un elemento de la lista
        int c = 0;
        String[] dropList = new String[STUDENTS.size()];
                        
        for(Student student : STUDENTS){ //Agregamos los carnets al dropList
            dropList[c++] = student.getId();
        }
                        
        String idStudent = (String) JOptionPane.showInputDialog(null, "Escoger Estudiante", "Insight",
            JOptionPane.QUESTION_MESSAGE,
            null,
            dropList,
            dropList[0]
        ); //Seleccionamos el Alumno
           
        for(Student student : STUDENTS){
            if(student.getId().equals(idStudent)){
                return student;
            }
        }
        return null;
    }
    
    public static boolean isStudentEmpty(){ //Verificamos que la lista no este vacía
        return !STUDENTS.isEmpty();
    }
    
    public static void showCum(Student student){ //Mostramos el CUM de un elemento de la lista
        System.out.println("\n\t\t\t * El CUM de " + student.getName() + " [" + student.getId() + "] es de: " + Validation.round(student.getCum(), 2));
    }
    
    public static void showSubjects(Student student){ //Mostramos las materias de un estudiante
        student.showSubjects();
    }
    
    public static void showInfo(Student student){
        System.out.println("\n\t INFORMACIÓN ESTUDIANTE");
        System.out.println(" - Código: "+student.getId());
        System.out.println(" - Nombre: "+student.getName());
        System.out.println(" - Fecha de nacimiento: "+student.getBirthdate());
    }
}
