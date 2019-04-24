package dao;

        import beans.User;

        import java.sql.*;
        import java.util.ArrayList;

        import static dao.DAOUtilitaire.*;

public class UserDao {

    private static final String SQL_INSERT = "INSERT INTO users (email, password, date_inscription) VALUES (?, ?, ?, NOW())";
    private static final String SQL_SELECT = "SELECT * from users where email = ?";
    private static final String SQL_SELECT_ALL = "SELECT * from users";


    public void save(User user){
        PreparedStatement preparedStatement = null;
        Connection con = null;
        try{
            con = ConnexionBDD.getInstance().getCnx();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee(con, SQL_INSERT, false,
                    user.getEmail(),
                    user.getPassword()
            );
            int status = preparedStatement.executeUpdate();

            if(status == 0){
                System.out.println("echec creation user");
            }

        }catch (SQLException e){
            e.getErrorCode();
        }finally {
            DAOUtilitaire.fermeturesSilencieuses(preparedStatement, con);
        }

    }

    public User findByMail(String mail){
        PreparedStatement preparedStatement = null;
        Connection conn = null;
        ResultSet result = null;
        User user = null;
        conn = ConnexionBDD.getInstance().getCnx();

        try{

            preparedStatement = initialisationRequetePreparee(conn, SQL_SELECT, false, mail);
            result = preparedStatement.executeQuery();

            if(result.next()){
                user = map(result);
            }

        }catch (SQLException e){
            e.getErrorCode();
        }finally {
            fermeturesSilencieuses(result, preparedStatement, conn);
        }

        return user;
    }


    public ArrayList<User> findAll() {
        Connection cnx = null;
        PreparedStatement ps = null;

        ArrayList<User> result = new ArrayList<User>();

        cnx = ConnexionBDD.getInstance().getCnx();
        try {
            //ps = cnx.prepareStatement(sql);
            //rs = ps.executeQuery();
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery( "SELECT * FROM users" );
            User u;
            while (rs.next()) {
                u = new User();
                u = map(rs);
                result.add(u);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //rs.close();
                //ps.close();
                ConnexionBDD.getInstance().closeCnx();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }// </find()>



    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des Users (un
     * ResultSet) et un bean User.
     */
    private static User map( ResultSet resultSet ) throws SQLException {
        User User = new User();
        User.setId( resultSet.getLong( "id" ) );
        User.setEmail( resultSet.getString( "email" ) );
        User.setPassword( resultSet.getString( "password" ) );
        User.setDateInscription( resultSet.getTimestamp( "date_inscription" ) );
        User.setRole( resultSet.getString( "role" ) );
        return User;
    }


}
