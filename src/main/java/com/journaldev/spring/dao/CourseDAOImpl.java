package com.journaldev.spring.dao;

import com.journaldev.spring.model.Course;
import com.journaldev.spring.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

//	@Autowired
//	public CourseDAOImpl(SessionFactory sessionFactory) {
//		super();
//		this.sessionFactory = sessionFactory;
//	}

    @SuppressWarnings("unchecked")
    @Override
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Course> personsList = session.createQuery("from Course").list();
        for(Course p : personsList){
            logger.info("Course List::"+p);
        }
        return personsList;
    }

    @Override
    public Course getCourseById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course p = (Course) session.load(Course.class, new Integer(id));
        logger.info("Course loaded successfully, Course details="+p);
        return p;
    }
}
