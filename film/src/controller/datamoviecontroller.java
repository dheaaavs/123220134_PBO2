/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Win 10
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> dp;
    
    public datamoviecontroller(MainView frame){
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        dp = impldatamovie.getAll();
    }
    
    public void isitabel(){
        dp = impldatamovie.getAll();
        modeltabeldatamovie mp = new modeltabeldatamovie(dp);
        frame.getTabelDatamovie().setModel(mp);
    }
    
    public void insert(){
        datamovie dp = new datamovie();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.insert(dp);
    }

    public void update(){
        datamovie dp = new datamovie();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.update(dp);
    }
    
    public void delete(){
        String judul = frame.getJTxtjudul().getText();
        impldatamovie.delete(judul);
    }
}

