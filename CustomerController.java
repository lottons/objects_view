package hello;

import lottons.resource.view.foundation.mapper.HibernateFilter;
import lottons.resource.view.foundation.model.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;
    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/customers")
    public List<Customer> getCustomerResource(@RequestBody Filter filter) {
        System.out.println(filter.getResourceName());
        HibernateFilter hf = new HibernateFilter();
        String queryStr = hf.getQeuryHql(filter);
        System.out.println(queryStr);
        Query q = em.createQuery(queryStr);
        return q.getResultList();
//        return (List<Customer>) repository.findAll();
    }
}
