package ssh.dao.base;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


public class BaseDao extends HibernateDaoSupport{
	@Resource  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        this.setSessionFactory(sessionFactory);  
    }
}
