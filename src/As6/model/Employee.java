/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package As6.model;

import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class Employee implements java.io.Serializable{
    int id;
    public String name;
    ArrayList <String> arr_Skills;
    ArrayList <TimeSlot> arr_TimeSlots;
    public Employee(int inpID, String inpName, ArrayList inparr_Skills, ArrayList inparr_TimeSlots){
        this.id = inpID;
        this.name=inpName;
        this.arr_Skills=inparr_Skills;
        this.arr_TimeSlots=inparr_TimeSlots;
    }
    public boolean has_Skill(String skill){
        for(int i=0; i<arr_Skills.size(); i++){
            if(arr_Skills.get(i).equals(skill)){
                return true;
            }    
        }
        return false;
    }
    public boolean is_Available(String day, int time){
        return this.arr_TimeSlots.stream().anyMatch((tmst) -> (tmst.day.equals(day) && tmst.hour==time));
    }
    
}
