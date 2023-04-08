package by.yanodincov.goat.budget.db.type.generator;

import com.github.f4b6a3.uuid.UuidCreator;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@NoArgsConstructor
public class UUIDV7Generator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return UuidCreator.getTimeBased();
    }
}
