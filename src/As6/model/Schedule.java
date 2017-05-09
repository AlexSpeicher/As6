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
public class Schedule implements java.io.Serializable{
    Employee [] arr_Employee;
    public Schedule(Employee [] inpArr){
        this.arr_Employee = inpArr;
    }
    public Employee[] getEmployee(){
        return this.arr_Employee;
    }
}
