/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package As6.model;

/**
 *
 * @author csc190
 */
public class TimeSlot implements java.io.Serializable {
    protected String day;
    protected int hour;
    public TimeSlot(String empday,int emphour){
        this.day=empday;
        this.hour=emphour;
    }
    
    
}
