/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatamovie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datamovieimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Win 10
 */
public class datamovieDAO implements datamovieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie;";
    final String insert = "INSERT INTO movie (judul,alur,penokohan,akting,nilai) VALUES (?,?,?,?,?);";
    final String update = "update movie set alur=?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "delete from movie where judul=?";
    public datamovieDAO(){
        connection  = connector.connection();
    }

    @Override
    public void insert(datamovie p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            double nilai = (p.getAlur() + p.getAkting() + p.getPenokohan()) / 3;
            p.setNilai(nilai);
            statement.setDouble(5, p.getNilai()); 
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    }
    @Override
    public void update(datamovie p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            double nilai = (p.getAlur() + p.getAkting() + p.getPenokohan()) / 3;
            p.setNilai(nilai);
            statement.setDouble(4, p.getNilai());
            statement.setString(5, p.getJudul()); 
            statement.executeUpdate();
            //ResultSet rs = statement.getGeneratedKeys();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    }

    @Override
    public List<datamovie> getAll() {
        List<datamovie> dp = null;
        try {
             dp = new ArrayList<datamovie>();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(select);
             while(rs.next()){
                 datamovie movie = new datamovie();
                 movie.setJudul(rs.getString("judul"));
                 movie.setAlur(rs.getDouble("alur"));
                 movie.setPenokohan(rs.getDouble("penokohan"));
                 movie.setAkting(rs.getDouble("akting"));
                 movie.setNilai(rs.getDouble("nilai"));
                 dp.add(movie);
             }
        }catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dp;
    }
}
