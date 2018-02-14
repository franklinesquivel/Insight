package middle.earth.academic;

import java.util.Date;
import middle.earth.generic.Person;
import java.util.List;
import middle.earth.validation.Validation;

/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Student extends Person {
    private String id; //Propiedad: + Carnet
    private List<Subject> subjects; //Propiedad: + Materias que cursa

    //Encapsulamiento de propiedad: Carnet
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Encapsulamiento de propiedad: Materias que cursa
    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    //Método Constructor de la Clase
    public Student(String id, List<Subject> subjects, String name, Date birthdate) {
        super(name, birthdate); //Método Constructor del Padre
        this.id = id;
        this.subjects = subjects;
    }
    
    //Método para agregar materias que el estudiante cursa.
    public void addSubject(Subject _s){
        this.subjects.add(_s);
    }
    
    //Método para obtener el CUM actual del estudiante, en base a las materias y sus resultados académicos
    public double getCum(){
        int sigmaVus = 0; //Total unidades Valorativas (ΣUV)
        double sigmaGrades = 0; //Unidades de Mérito (ΣM)
        
        //CUM = ΣM / ΣUV; Sin contar las materias reprobadas...
        
        for(Subject _s : this.subjects){
            if(_s.isApproved()){ //Sí la materia fue aprobada.
                sigmaVus += _s.getVu();
                sigmaGrades += _s.getGrade() * _s.getVu();
            }
        }
        
        return sigmaGrades / sigmaVus;
    }
    
    //Método para mostrar las materias que el estudiante aprobó
    public void showApprovedSubjects(){
        if(this.subjects.size() > 0){
            int c = 0;
            System.out.println("\n|------------------------------------------------------");
            System.out.println("|              MATERIAS APROBADAS de " + this.getName() + ":");
            for(Subject _s : this.subjects){
                if(_s.isApproved()){ //Sí la materia fue aprobada
                    System.out.println("| \t * Nombre: " + _s.getName());
                    System.out.println("| \t * UV's: " + _s.getVu());
                    System.out.println("| \t * Nota: " + Validation.round(_s.getGrade(), 2));
                    System.out.println("|");
                }else{
                    c++;
                }
                //Mensaje a mostrar sí todas las materias que el estudiante cursa fueron desaprobadas
                System.out.print(c == this.subjects.size() ? "\t\t > El estudiante no posee ninguna materia aprobada!" : "");   
            }
            System.out.println("|------------------------------------------------------");
        }else{
            //Mensaje a mostrar sí el estudiante no posee materias registradas
            System.out.println("\t\t > El estudiante no cuenta con registros de materias!");
        }
    }
    
    //Método para mostrar las materias que el estudiante aprobó
    public void showSubjects(){
        if(this.subjects.size() > 0){
            System.out.println("\n|------------------------------------------------------");
            System.out.println("|              MATERIAS de " + this.getName() + ":");
            this.subjects.forEach((_s) -> {
                System.out.println("| \t * Nombre: " + _s.getName());
                System.out.println("| \t * UV's: " + _s.getVu());
                System.out.println("| \t * Nota: " + Validation.round(_s.getGrade(), 2));
                System.out.println("| \t * Aprobada: " + (_s.isApproved() ? "Si" : "No"));
                System.out.println("|");
            });
            System.out.println("|----------------------------------------------------");
        }else{
            //Mensaje a mostrar sí el estudiante no posee materias registradas
            System.out.println("\t\t > El estudiante no cuenta con registros de materias!");
        }
    }
}
