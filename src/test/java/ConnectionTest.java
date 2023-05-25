import lombok.SneakyThrows;
import org.example.Config;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Connection;
public class ConnectionTest {
    @Test
    @SneakyThrows
    public void testConnection(){
        Connection connection = Config.getConnection();
        System.out.println(connection.isValid(1)); //
        Assert.assertTrue(connection.isValid(1)); //
        Assert.assertFalse(connection.isClosed()); // Соединение открыто Yes/No
    }
}
