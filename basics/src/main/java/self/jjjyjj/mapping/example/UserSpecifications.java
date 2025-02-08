package self.jjjyjj.mapping.example;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {
    public static Specification<UserEntity> withCriteria(UserSearchCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getUsername() != null) {
                predicates.add(cb.like(
                        cb.lower(root.get("username")),
                        "%" + criteria.getUsername().toLowerCase() + "%"
                ));
            }

            if (criteria.getEmail() != null) {
                predicates.add(cb.like(
                        cb.lower(root.get("email")),
                        "%" + criteria.getEmail().toLowerCase() + "%"
                ));
            }

            if (criteria.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), criteria.getStatus()));
            }

            if (criteria.getCreatedAfter() != null) {
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("createdAt"),
                        criteria.getCreatedAfter()
                ));
            }

            if (criteria.getCreatedBefore() != null) {
                predicates.add(cb.lessThanOrEqualTo(
                        root.get("createdAt"),
                        criteria.getCreatedBefore()
                ));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}