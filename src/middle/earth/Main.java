/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth;

import middle.earth.academic.Student;
import java.util.List;
/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López"];
 */
public class Main {
    public List<Student> students; //Propiedad: + Lista de Estudiantes
    
    //Método para añadir un estudiante
    public void addStudent(Student _s){
        this.students.add(_s);
    }
    
    //Método para mostrar a todos los estudiantes registrados
    public void showStudents(){
        System.out.println("|------------------------------------------");
        for(Student _s : this.students){
            System.out.println("\n|\t* Carnet: " + _s.getId() + "\n|\t* Nombre: " + _s.getName() + "\n| * Fecha de nacimiento: " + _s.getBirthdate().toString() + "\n\n > ");
        }
    }
}
