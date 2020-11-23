/**
 * 
 */
package com.MultiThreading.app.comparator;

import java.util.Comparator;

/**
 * @author Sanjeev
 *
 */
class Sortbyname implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll name 
    public int compare(Student a, Student b) 
    { 
        return a.name.compareTo(b.name); 
    } 
} 