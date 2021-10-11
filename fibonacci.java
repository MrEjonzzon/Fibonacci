import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Main {

    public static void main(String[] args) {

    //set credentials and initialize values
        String url = "jdbc:mysql://localhost:3306/arbetsprov";
        String username = "arbetsprov";
        String password = "mittarbetsprov2021";
        Connection connection = null;
        PreparedStatement statement = null;
        int i = 1, n = 10, firstTerm = 0, secondTerm = 1, id = 1;

        try {
        //connect to db
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection successful \n");

            //delete previous result to not overfill db
            statement = connection.prepareStatement("DELETE FROM fibonacci order by fibonacci_id limit 10");
            statement.executeUpdate();

        //print result
            System.out.println("First 10 fibonacci numbers are:\n");
            while (i <= n) {
                System.out.print(firstTerm + "\n");

            //insert into db
                statement = connection.prepareStatement("INSERT INTO fibonacci (fibonacci_id, fibonacci_nr) VALUES ('"+id+"', '"+firstTerm+"')");
                statement.executeUpdate();

            //calculate next term
                int nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm;
                secondTerm = nextTerm;
                id++;
                i++;
            }
        //end connection
            statement.close();
            connection.close();
            if (connection.isClosed())
                System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
