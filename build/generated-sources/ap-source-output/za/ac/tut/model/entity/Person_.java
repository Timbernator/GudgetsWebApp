package za.ac.tut.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.model.entity.Address;
import za.ac.tut.model.entity.Login;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-23T12:20:09")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> cellNo;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile SingularAttribute<Person, String> gender;
    public static volatile SingularAttribute<Person, String> surname;
    public static volatile SingularAttribute<Person, String> dob;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, String> title;
    public static volatile SingularAttribute<Person, Login> login;
    public static volatile SingularAttribute<Person, String> email;

}