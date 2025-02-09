package repository;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import repository.School;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-08T21:58:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(University.class)
public class University_ { 

    public static volatile CollectionAttribute<University, School> schoolCollection;
    public static volatile SingularAttribute<University, String> name;
    public static volatile SingularAttribute<University, String> description;
    public static volatile SingularAttribute<University, Integer> counter;
    public static volatile SingularAttribute<University, String> info;

}