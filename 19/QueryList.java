import java.util.ArrayList;

public class QueryList<T extends Student> extends ArrayList<T> {

    // filter elements whose field matches value
    public QueryList<T> getStudentsByValue(String field, String value) {
        QueryList<T> result = new QueryList<>();
        for (T student : this) {
            if (student.matchFieldValue(field, value)) {
                result.add(student);
            }
        }
        return result;
    }
}
