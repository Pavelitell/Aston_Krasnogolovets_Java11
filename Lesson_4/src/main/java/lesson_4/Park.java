package lesson_4;

public class Park {
     public static class Attrections {

         private double attractionCost;
         private int  attractionTime;
         private String attractionName;



         public Attrections(double attractionCost, int attractionTime, String attractionName) {
             this.attractionCost = attractionCost;
             this.attractionTime = attractionTime;
             this.attractionName = attractionName;
         }

         public double getAttractionCost() {
             return attractionCost;
         }

         public void setAttractionCost(double attractionCost) {
             this.attractionCost = attractionCost;
         }

         public int getAttractionTime() {
             return attractionTime;
         }

         public void setAttractionTime(int attractionTime) {
             this.attractionTime = attractionTime;
         }

         public String getAttractionName() {
             return attractionName;
         }

         public void setAttractionName(String attractionName) {
             this.attractionName = attractionName;
         }
         @Override
         public String toString() {
             return "Attrections{" +
                     "attractionCost=" + attractionCost +
                     ", attractionTime=" + attractionTime +
                     ", attractionName='" + attractionName + '\'' +
                     '}';
         }
     }

}
