package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        if (id !=0) {
            return (UsersDataSet) session.get(UsersDataSet.class, id);
        } else
            return null;
    }

    public long getUserId(String name) throws HibernateException {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UsersDataSet> criteriaQuery = builder.createQuery(UsersDataSet.class); //создаем критерий
            Root<UsersDataSet> root = criteriaQuery.from(UsersDataSet.class); //определяем переменную диапазона для FROM
            criteriaQuery.select(root); //какой тип результата запроса будет (можно поля задавать
            criteriaQuery.where(builder.equal(root.get("name"), name)); //задаем where
            Query<UsersDataSet> q = session.createQuery(criteriaQuery); //собственно сам запрос
            UsersDataSet result = q.getSingleResult(); //получаем результат
            return result.getId();
        } catch (NoResultException | NullPointerException e){
           //e.printStackTrace();
           return 0;
        }
    }

    public long insertUser(String name) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name));
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
