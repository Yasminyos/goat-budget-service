package by.yanodincov.goat.budget.db.repository;

import by.yanodincov.goat.budget.db.entity.Operation;
import by.yanodincov.goat.budget.db.filter.GetOperationFilter;
import com.github.f4b6a3.uuid.UuidCreator;
import jakarta.persistence.EntityManager;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class GetOperationRepository {
    private EntityManager em;

    public List<Operation> getOperationsByFilter(GetOperationFilter filter) {
        if (filter.getUserUUID() == null) {
            throw new InvalidPropertyException(GetOperationFilter.class, "userUUID", "required");
        }

        var criteriaBuilder = this.em.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Operation.class);
        var operation = query.from(Operation.class);

        query.where(criteriaBuilder.equal(operation.get("user_uuid"), filter.getUserUUID()));
        if (filter.getCategoryUUID() != null) {
            query.where(criteriaBuilder.equal(operation.get("category_uuid"), filter.getCategoryUUID()));
        }
        if (filter.getAfterInstant() != null) {
            var afterUUID = UuidCreator.getTimeOrdered(filter.getAfterInstant(), null, null);
            query.where(criteriaBuilder.greaterThan(operation.get("uuid"), afterUUID));
        }
        if (filter.getBeforeInstant() != null) {
            var beforeUUID = UuidCreator.getTimeOrdered(filter.getBeforeInstant(), null, null);
            query.where(criteriaBuilder.lessThan(operation.get("uuid"), beforeUUID));
        }
        if (filter.getLastUUID() != null) {
            query.where(criteriaBuilder.lessThan(operation.get("uuid"), filter.getLastUUID()));
        }

        query.orderBy(criteriaBuilder.desc(operation.get("uuid")));

        return this.em.createQuery(query).getResultList();
    }
}
