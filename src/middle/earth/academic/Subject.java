/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth.academic;

/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Subject {
    private String name; //Propiedad: + Nombre
    private double grade; // Propiedad: + Nota
    private int vu; // Propiedad: + UnidadesValorativas [Value Units]
    private boolean approved; // Propiedad: + Aprobada

    //Encapsulamiento de propiedad: Nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Encapsulamiento de propiedad: Nota
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    //Encapsulamiento de propiedad: UnidadesValorativas
    public int getVu() {
        return vu;
    }

    public void setVu(int vu) {
        this.vu = vu;
    }

    //Encapsulamiento de propiedad: Aprobada
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    //Método Constructor de la Clase
    public Subject(String name, double grade, int vu) {
        this.name = name;
        this.grade = grade;
        this.vu = vu;
        this.approved = (grade >= 6.00 && grade <= 10.00); // La materia es aprobada sí la nota se encuentra entre 6 y 10.
    }
}
