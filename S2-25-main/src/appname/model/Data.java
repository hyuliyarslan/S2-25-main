package appname.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Data {


    private static final String url = "jdbc:postgresql://10.134.187.25:5432/game";
    private static final String user = "game";
    private static final String password = "7sur7";

    /*
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


 /*   public void saveMove(int move) {
        String sql = "INSERT INTO moves (game_id, player_name, move_number, points, timestamp) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connect().getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, move.getGameId());
            pstmt.setString(2, move.getPlayerName());
            pstmt.setInt(3, move.getMoveNumber());
            pstmt.setInt(4,0;
            pstmt.setString(5, move.getTimestamp().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
 public void printGameStatistics(int gameId) throws SQLException {
 Preparedst st = connection.preparest(
              "SELECT * FROM moves WHERE game_id = ? ORDER BY move_number");



 st.setInt(1, gameId);



 ResultSet result;
     result = st.executeQuery();


     List<Integer> moveDurations = new ArrayList<>();
 int totalPoints = 0;



 while (result.next()) {
 int points = result.getInt("points");
 totalPoints += points;



 if (points > 0) {
 int moveDuration = calculateMoveDuration(result);
 moveDurations.add(moveDuration);
 }
 }



 if (moveDurations.size() > 0) {
 int averageDuration = calculateAverageMoveDuration(moveDurations);
 System.out.println("Average Move Duration: " + averageDuration + " milliseconds");



 List<Integer> outliers = findOutlierMoves(moveDurations);
 System.out.println("Outlier Moves: " + outliers.toString());



 printMoveDurationGraph(moveDurations);
 }



 System.out.println("Total Points: " + totalPoints);
 }



         private int calculateMoveDuration(ResultSet result) throws SQLException {
 Timestamp timestamp = result.getTimestamp("timestamp");
 Timestamp previousTimestamp = result.previous() ? result.getTimestamp("timestamp") : null;
 result.next();



 if (previousTimestamp == null) {
 return 0;
 } else {
 return (int) (timestamp.getTime() - previousTimestamp.getTime());
 }
 }



         private int calculateAverageMoveDuration(List<Integer> moveDurations) {
 int sum = 0;



 for (int duration : moveDurations) {
 sum += duration;
 }



 return sum / moveDurations.size();}



*/
}


