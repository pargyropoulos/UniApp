package repository;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import repository.School;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-09T21:46:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, School> schoolId;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile SingularAttribute<Department, Integer> id;

}