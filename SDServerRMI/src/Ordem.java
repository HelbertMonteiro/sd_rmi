

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Helbert Monteiro
 */
public class Ordem {

    private String            listaDesordem[], listaOrdem, sql, listaIndividual;
    private int               listaNumero[];
    private PreparedStatement pstatement;
    private List<String>      listaBanco;
    
    public String ordenar(String desordem){
        try{
            listaDesordem = desordem.split(" ");
            listaNumero   = new int[listaDesordem.length];
            listaOrdem    = "";
            
            for(int i = 0; i < listaDesordem.length; i++){
                listaNumero[i] = Integer.parseInt(listaDesordem[i]);
            }
            
            Arrays.sort(listaNumero);
            
            for(int i = 0; i < listaNumero.length; i++){
                listaOrdem += "  " + String.valueOf(listaNumero[i]);
            }
            
            if(insereBD()){
                return listaOrdem;
            }else{
                return null;
            }
        }catch(NumberFormatException erro){
            System.out.println("Erro em ordenar: " + erro.getMessage());
            return null;
        }
    }
    
    private boolean insereBD(){
        sql        = "insert into ListaNumero (lista) values (?)";
        pstatement = Conexao.getPreparedStatement(sql);
        try{
            pstatement.setString(1, listaOrdem);
            return pstatement.executeUpdate() > 0;
        }catch(SQLException erro){
            System.out.println("Erro em inserir: " + erro.getMessage());
            return false;
        }
    }
    
    public List<String> listaBanco(){
        sql = "select * from ListaNumero";
        listaBanco = new ArrayList<>();
        pstatement = Conexao.getPreparedStatement(sql);
        try{
            ResultSet resultSet = pstatement.executeQuery();
            while(resultSet.next()){
                listaIndividual = resultSet.getString("lista");
                listaBanco.add(listaIndividual);
            }
        }catch(Exception erro){
            System.out.println("Erro em listar banco: " + erro.getMessage());
        }
        return listaBanco;
    }
    
    
    
}