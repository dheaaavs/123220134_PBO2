/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Win 10
 */
public interface datamovieimplement {
    public void insert(datamovie p);
    public void update(datamovie p);
    public void delete(String judul);
    public List<datamovie> getAll();
}   
