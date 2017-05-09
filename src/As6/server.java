/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package As6;

import As6.model.Employee;
import As6.model.Schedule;
import As6.model.TimeSlot;

/**
 *
 * @author csc190
 */
public class server {
    protected static void updateSchedule(String val){
        String qry = "UPDATE objects SET val='" + val +"' WHERE name='schedule'";
        Utils.execNonQuery(qry);
    }
    protected static String getSchedule(String day, String skill, int hour){
        //1. retrieve all menu
        String qry = "SELECT val FROM objects WHERE name='schedule'";
        String scheduleObjStr = Utils.execQuery(qry);
        String output;
        output = "";
        Schedule schedule = (Schedule) Utils.toObj(scheduleObjStr);
        for(Employee e: schedule.getEmployee()){
            if(e.has_Skill(skill) && e.is_Available(day, hour)){
                output += "" + e.name;
            }
        }
        return output;
    }
    public static void main(String [] args){
        String op = args[0];
        if(op.equals("uploadSchedule")){
            updateSchedule(args[1]);
        }else{
            String Str = getSchedule(args[2],args[3], Integer.parseInt(args[4]));
            System.out.println(Str);
        }
    }
}
