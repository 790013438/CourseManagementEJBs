package snippets.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import snippets.dto.CourseDTO;
import snippets.jpa.Course;

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

    public List<Course> getCourseEntities() {
        //Use named query created in Course entity using @NameQuery annotation.
        TypedQuery<Course> courseTypedQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
        return courseTypedQuery.getResultList();
    }

    @Override
    public List<CourseDTO> getCourses() {
        //get course entities first
        List<Course> courseEntities = getCourseEntities();

        //Create list of course DTOs. This is the result we will return
        List<CourseDTO> courses = new ArrayList<CourseDTO>();

        for (Course courseEntity : courseEntities) {
            //Create CourseDTO from Course entity
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(courseEntity.getId());
            courseDTO.setName(courseEntity.getName());
            courseDTO.setCredits(courseEntity.getCredits());
            courses.add(courseDTO);
        }
        return courses;
    }

}
