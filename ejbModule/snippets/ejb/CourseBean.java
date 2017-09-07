package snippets.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CourseBean
 */
@Stateless
@LocalBean
public class CourseBean implements CourseBeanRemote {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public CourseBean() {
        // TODO Auto-generated constructor stub
    }

}
