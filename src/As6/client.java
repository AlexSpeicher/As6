/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package As6;

import As6.model.Employee;
import As6.model.Schedule;
import As6.model.TimeSlot;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author csc190
 */
public class client {

    protected static Schedule buildSchedule() {
        ArrayList<String> arr_SkillsEmp1 = new ArrayList<>();
        arr_SkillsEmp1.add("Butcher");
        arr_SkillsEmp1.add("Saucier");
        arr_SkillsEmp1.add("Baker");
        ArrayList<String> arr_SkillsEmp2 = new ArrayList<>();
        arr_SkillsEmp1.add("Saucier");
        arr_SkillsEmp1.add("Baker");
        ArrayList<String> arr_SkillsEmp3 = new ArrayList<>();
        arr_SkillsEmp1.add("Butcher");
        arr_SkillsEmp1.add("Dishwasher");
        ArrayList<String> arr_SkillsEmp4 = new ArrayList<>();
        arr_SkillsEmp1.add("Butcher");
        arr_SkillsEmp1.add("Dishwasher");
        ArrayList<TimeSlot> TimeEmployee1 = new ArrayList<>();
        for(int i=0; i<3;i++ ){
            String Days = null;
            int hours;
            switch (i) {
                case 0:
                    {
                    Days = "M";
                    break;
                    }
                case 1:
                    {
                    Days = "W";
                    break;
                    }
                case 3:
                    Days = "F";
                    break;
            }
            for(int j=9; j<13;j++){
                hours=j;
                TimeEmployee1.add(new TimeSlot(Days, hours));
            }
            for(int j=19; j<21;j++){
                hours=j;
                TimeEmployee1.add(new TimeSlot(Days, hours));
            }
        }
        ArrayList<TimeSlot> TimeEmployee2 = new ArrayList<>();
        for(int i=0; i<3;i++ ){
            String Days = null;
            int hours;
            switch (i) {
                case 0:
                    {
                    Days = "T";
                    break;
                    }
                case 1:
                    {
                    Days = "W";
                    break;
                    }
                case 3:
                    Days = "F";
                    break;
            }
            for(int j=9; j<11;j++){
                hours=j;
                TimeEmployee2.add(new TimeSlot(Days, hours));
            }
            TimeEmployee2.add(new TimeSlot(Days, 12));
            for(int j=14; j<19;j++){
                hours=j;
                TimeEmployee2.add(new TimeSlot(Days, hours));
            }
        }
        ArrayList<TimeSlot> TimeEmployee3 = new ArrayList<>();
        for(int i=0; i<2;i++ ){
            String Days = null;
            int hours;
            switch (i) {
                case 0:
                    {
                    Days = "M";
                    break;
                    }
                case 1:
                    {
                    Days = "F";
                    break;
                    }
            }
            for(int j=12; j<19;j++){
                hours=j;
                TimeEmployee3.add(new TimeSlot(Days, hours));
            }
        }
        ArrayList<TimeSlot> TimeEmployee4 = new ArrayList<>();
        for(int i=0; i<2;i++ ){
            String Days = null;
            int hours;
            switch (i) {
                case 0:
                    {
                    Days = "T";
                    break;
                    }
                case 1:
                    {
                    Days = "R";
                    break;
                    }
            }
            for(int j=8; j<15;j++){
                hours=j;
                TimeEmployee4.add(new TimeSlot(Days, hours));
            }
        }
        Employee[] arr_Employees = new Employee[]{
            new Employee(101, "Dr.Evil", arr_SkillsEmp1,TimeEmployee1),
            new Employee(102, "Mini Me", arr_SkillsEmp2,TimeEmployee2),
            new Employee(103, "Number Two", arr_SkillsEmp3,TimeEmployee3),
            new Employee(104, "Austin Power", arr_SkillsEmp4,TimeEmployee4)
        };
        Schedule schedule = new Schedule(arr_Employees);
        
        return schedule;
    }

    /**
     * Serialization. Convert Menu to byte array, and then encode using base64
     *
     * @param schedule
     * @return
     */
    protected static String scheduleToStr(Schedule schedule) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(schedule);
            byte[] barrOut = bos.toByteArray();
            byte[] b64Out = Base64.getEncoder().encode(barrOut);
            int len1 = barrOut.length;
            int len2 = b64Out.length;
            String sRet = new String(b64Out);
            sRet = URLEncoder.encode(sRet, "UTF-8");
            return sRet;
        } catch (Exception exc) {
            System.out.println(exc);
            return null;
        }
    }


    public static void main(String[] args) {
        String op = args[0];
        Schedule schedule = buildSchedule();
        String url = "http://localhost/schedule.php";
        String scheduleContent = Utils.toStr(schedule);
        String datastr = op.equals("1")
                ? "op=uploadSchedule&val=" + scheduleContent
                : "op=getSchedule"+"&day="+args[1]+"&skill="+args[2]+"&hour="+args[3];
        try {
            String response = Utils.httpsPost(url, datastr);
            System.out.println(response);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        int k = 0;

    }

}
