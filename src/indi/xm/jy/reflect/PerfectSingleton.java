package indi.xm.jy.reflect;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class PerfectSingleton implements Serializable {
   public static class Inner{
     private static final PerfectSingleton INSTANCE = new PerfectSingleton();
   }
   private PerfectSingleton(){
     if(Inner.INSTANCE != null){
       throw new Error("denied access.");
     }
   }
   public static PerfectSingleton getInstance(){
     return Inner.INSTANCE;
   }
   private Object readResolve() throws ObjectStreamException {
     return Inner.INSTANCE;
   }
 }