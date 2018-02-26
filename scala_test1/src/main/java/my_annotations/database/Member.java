package my_annotations.database;

/**
 * Created by chenteng on 2017/3/24.
 */

@DBTable(tableName = "MEMBER")
public class Member {
    @Constraints
    @SQLString(30)
    String firstName;

    @Constraints
    @SQLString(50)
    String lastName;

    @Constraints(primaryKey = true)
    @SQLString(30)
    String handle;
}
