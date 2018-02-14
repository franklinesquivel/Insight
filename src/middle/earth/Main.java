/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import middle.earth.academic.Student;
import java.util.List;
import javax.swing.JOptionPane;
import middle.earth.academic.Subject;
/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Main {
    public static List<Student> students = new ArrayList(); //Propiedad: + Lista de Estudiantes
    
    //Método para añadir un estudiante
    public static void addStudent(Student _s){
        Main.students.add(_s);
    }
    
    public static void addStudentDefault(){
        List<Subject> subjects = new ArrayList();
        subjects.add(new Subject("Quimica", 8, 4));
        subjects.add(new Subject("Algebra", 7, 3));
        subjects.add(new Subject("Matemática 2", 9, 4));
        students.add(new Student("EG171989",subjects , "Franklin Esquivel", new Date(1998, 9, 23)));
        students.add(new Student("LC171998", subjects, "Leonardo López", new Date(1999, 4, 9)));
        students.add(new Student("LT171979", subjects, "Diego Lemus", new Date(1999, 4, 7)));
    }
    
    //Método para mostrar a todos los estudiantes registrados
    public static void showStudents(){
        System.out.println("|------------------------------------------");
        Main.students.forEach((_s) -> {
            System.out.println("\n|\t* Carnet: " + _s.getId() + "\n|\t* Nombre: " + _s.getName() + "\n|\t* Fecha de nacimiento: " + new SimpleDateFormat("yyyy-MM-dd").format(_s.getBirthdate()) + "\n\n > ");
        });
    }
    
    public static List<Student> getStudents(){//Método que devuele la list de los estudiantesa agregadas por el momento
        return students;
    }
    
    public static void addSubject(Student student, Subject subject){
        student.addSubject(subject);
    }
    
    public static void showSubjectsAproved(Student student){
        student.showApproved();
    }
    
    public static Student selectStudent(){ //Mostramos un control para seleccionar el alumno y regresamos un elemento de la lista
        int c = 0;
        String[] dropList = new String[students.size()];
                        
        for(Student student : students){ //Agregamos los carnets al dropList
            dropList[c++] = student.getId();
        }
                        
        String idStudent = (String) JOptionPane.showInputDialog(null, "Escoger Estudiante", "Insight",
            JOptionPane.QUESTION_MESSAGE,
            null,
            dropList,
            dropList[0]
        ); //Seleccionamos el Alumno
           
        for(Student student : students){
            if(student.getId().equals(idStudent)){
                return student;
            }
        }
        return null;
    }
    
    public static boolean isStudentEmpty(){ //Verificamos que la lista no este vacía
        return !students.isEmpty();
    }
    
    public static void showCum(Student student){ //Mostramos el CUM de un elemento de la lista
        System.out.println("CUM de "+student.getId()+": "+student.getCum());
    }
    
    public static void showSubjects(Student student){ //Mostramos las materias de un estudiante
        System.out.println("|------------------------------------------");
        student.getSubjects().forEach((subject) ->{
            String state = subject.isApproved() ? "Si" : "No";
            System.out.println("- Nombre: "+subject.getName());
            System.out.println("- Nota: "+subject.getGrade());
            System.out.println("- UV: "+subject.getVu());
            System.out.println("- Aprobada: "+ state);
        });
        System.out.println("|------------------------------------------");
    }
}
