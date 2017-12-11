package za.ac.tut.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-23T12:20:08")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> password;
    public static volatile SingularAttribute<Login, String> securityQuestion;
    public static volatile SingularAttribute<Login, String> securityAnswer;
    public static volatile SingularAttribute<Login, Long> id;
    public static volatile SingularAttribute<Login, String> username;

}