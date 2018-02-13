/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import middle.earth.academic.Student;
import java.util.List;
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
    
    //Método para mostrar a todos los estudiantes registrados
    public static void showStudents(){
        System.out.println("|------------------------------------------");
        Main.students.forEach((_s) -> {
            System.out.println("\n|\t* Carnet: " + _s.getId() + "\n|\t* Nombre: " + _s.getName() + "\n|\t* Fecha de nacimiento: " + new SimpleDateFormat("yyyy-MM-dd").format(_s.getBirthdate()) + "\n\n > ");
        });
    }
}
