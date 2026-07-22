/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversor {
    
    public static Date TextoToDate(String textoData){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // impede datas inválidas
        try{
            java.util.Date minhaData =  sdf.parse(textoData);
            return new Date(minhaData.getTime());
        } catch (ParseException ex) {
            return null;
        } 
        
    }
    
    
}
