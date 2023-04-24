package baseball;

public class DTO {
   
   private int ba;
   private String name;
   private String group;
   private String roll;
   
   public DTO(String name, int ba, String group, String roll) {
      super();
      this.name = name;
      this.ba = ba;
      this.group = group;
      this.roll = roll;
   }
   public String getRoll() {
      return roll;
   }
   public void setRoll(String roll) {
      this.roll = roll;
   }
   public int getBa() {
      return ba;
   }
   public void setBa(int ba) {
      this.ba = ba;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGroup() {
      return group;
   }
   public void setGroup(String group) {
      this.group = group;
   }
   
}