import com.todolist.dao.UserDao;

/**
 * Created by askol on 6/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        UserDao userDao = UserDao.INSTANCE;
        System.out.println(userDao.getUserById(1));
    }
}
