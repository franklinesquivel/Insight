/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middle.earth.generic;

import java.util.Date;

/**
 *
 * @authors = [new Programmer("Franklin Esquivel"), new Programmer("Leonardo López")];
 */
public class Person {
    private String name; //Propiedad: + Nombre
    private Date birthdate; //Propiedad: + Fecha de Nacimiento

    //Encapsulamiento de propiedad: Nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Encapsulamiento de propiedad: Fecha de Nacimiento
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    //Método Constructor de la Clase
    public Person(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
}
