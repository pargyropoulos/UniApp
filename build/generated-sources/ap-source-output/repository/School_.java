package repository;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import repository.Department;
import repository.University;

<<<<<<< OURS
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-09T22:33:18", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-09T21:46:09", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> THEIRS
@StaticMetamodel(School.class)
public class School_ { 

    public static volatile SingularAttribute<School, University> universityName;
    public static volatile SingularAttribute<School, String> name;
    public static volatile SingularAttribute<School, Integer> id;
    public static volatile CollectionAttribute<School, Department> departmentCollection;

}