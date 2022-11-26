package entities;

import javax.swing.text.View;

public class VehicleDataB{

    private Vehicle[] database;
    private int count;
    
    //creates initially empty database
    
     public void addCarro(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo)
    {
        if(count == database.length)
        increasesize();
        database[count] = new Carro (modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
        count++;
    }
     public void addFurgao(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo)
    {
        if(count == database.length)
        increasesize();
        database[count] = new Furgao (modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
        count++;
    }
     public void addVan(String modelo, String placa, Integer capacidadeTanque, Double valorVenda, Double kilometragem, Double consumo)
    {
        if(count == database.length)
        increasesize();
        database[count] = new Van (modelo, placa, capacidadeTanque, valorVenda, kilometragem, consumo);
        count++;
    }
    

    public String toString()
    {
    String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    report +="Number of Vechicles: "+count+"\n\n";
    report+= "Vehicle list:\n\n";
    for (int i = 0; i< count; i++)
        {
        report+= database[i]+"\n\n";
        }
    return report;
    }
    
    
    
    private void increasesize()
    {
    Vehicle[] temp = new Vehicle[database.length *2];
    for (int car = 0; car<database.length; car++)
      temp[car] = database[car];
      database = temp;
    }

}