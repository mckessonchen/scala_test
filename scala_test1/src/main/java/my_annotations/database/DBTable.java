package my_annotations.database;

import java.lang.annotation.*;

/**
 * Created by chenteng on 2017/3/24.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String tableName() default "";

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
    public boolean primaryKey() default false;
    public boolean allowNull() default true;
    public boolean unique() default false;
}

@interface SQLInterger{
    public String name() default "";
}
@interface SQLString{
    public String name() default "";
    public int value() default 0;
}
