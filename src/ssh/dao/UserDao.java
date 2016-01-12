package ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ssh.dao.base.BaseDao;
import ssh.model.User;

@Repository
public class UserDao  extends BaseDao{
    public void add(User user){
    	this.getHibernateTemplate().save(user);
    }
    
    @SuppressWarnings("unchecked")
	public List<User> queryAllUser(){
        
    	List<User> users = new ArrayList<User>();
    	HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
    	
    	hibernateTemplate.setCacheQueries(true);
        users = (List<User>) hibernateTemplate.find("from User");
        hibernateTemplate.setCacheQueries(false);

        return users;
    }

}
