package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

//    @Bean
//    public CommandLineRunner demo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
////			repository.save(new Customer("Jack", "Bauer"));
////			repository.save(new Customer("Chloe", "O'Brian"));
////			repository.save(new Customer("Kim", "Bauer"));
////			repository.save(new Customer("David", "Palmer"));
////			repository.save(new Customer("Michelle", "Dessler"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            repository.findById(1L)
//                    .ifPresent(customer -> {
//                        log.info("Customer found with findById(1L):");
//                        log.info("--------------------------------");
//                        log.info(customer.toString());
//                        log.info("");
//                    });
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//
//            repository.findAll(new Specification<Customer>() {
//                public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                    Path<String> namePath = root.get("firstName");
////                    Path<String> nicknamePath = root.get("Jack");    /**         * 连接查询条件, 不定参数，可以连接0..N个查询条件         */
//                    query.where(cb.like(namePath, "%Jack%")); //这里可以设置任意条查询条件        return null;   }     });
//                    // for (Customer bauer : repository.findByLastName("Bauer")) {
//                    // 	log.info(bauer.toString());
//                    // }
//                    log.info("");
//                    return null;
//                }
//            }).forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//        };
//    }
}
