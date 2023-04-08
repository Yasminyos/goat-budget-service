package by.yanodincov.goat.budget.db.type.annotation;

import by.yanodincov.goat.budget.db.type.generator.UUIDV7Generator;
import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IdGeneratorType(UUIDV7Generator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME )
public @interface GeneratedUUIDV7 {

}
