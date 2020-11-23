/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class Vertex {
	
	final private String id;//This is a vertex id for recognizing it among vertices. Has no specific use in path calculation
    final public String name;//This is the name of the vertex. It may be city-name or friend-name or anything that you are using in your network graph i.e. connected graph


    public Vertex(String name,String id ) {
        this.id = id;
        this.name = name;
    }
    
	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
    //This hashCode() method is associated with every class. For every different object of the same class, hashCode value is different by default. It is a java
    //Implementation and you don't require to anything. But when you are implementing equals of your own logic keeping the default implementation in intact,
    //You need to override it. While overriding it, we introduce that particular field in hashCode that you are going to implement in equals.
    //In my example, we are saying that if two different objects have equal id value and they are not sharing the default equal method implementation, 
    //they should be still considered equal. In that case, if you call equal method keeping in mind that if they have equal id value, return equal hashcode.
    //Then you have to introduce id in hashcode value.
    
    @Override
    public int hashCode() {
        final int prime = 31;//Taking any no
        int result = 1;//
        //Here id.hashCode() will return hashCode() of java implementation of this field value. We are using it for creating hashCode for the object
        //in case of id==null, result will be 31*1+0=32
        //if two objects with id as null will return 32
        //But two objects with id as 4 and 5 will return 36 and 37
        //So, while comparing two objects using equals on the basis of id will internally check their hashcode 36 and 37 and report they are unequal.
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    //Each class has this equals method. Two objects of the same class are compared with the default logic. But, if you want to impart your own logic for 
    //comparison through equals, you can override it.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)//This will compare reference value which is default one
            return true;
        if (obj == null)//If the object to be compared is null, 
            return false;
        if (getClass() != obj.getClass())//If the object to be compared is of different classes
            return false;
        
        //Additional comparison logic is being added in addition to above ones. We are assuming that if two objects of the same class have equal id, 
        //then they are also considered equal.
        
        Vertex other = (Vertex) obj;//Cast this into Vertex
        if (id == null) {//If id==null, the comparing object id is not null, the result of equality comparison is also false.
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;//If both object's id are equal, return equal as true.
    }

    //It is used to take out string value of the object i.e. how you want to have the result of an object when you are calling toString() on the object.
    //System.out.println(object) internally calls toString. You can directly call object.toString()
    @Override
    public String toString() {
        return name;
    }

}
