/**
 * 
 */
package com.MultiThreading.app.comparator;

import java.util.Comparator;

/**
 * @author Sanjeev
 *
 */
class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return a.rollno - b.rollno; 
    } 
} 
  