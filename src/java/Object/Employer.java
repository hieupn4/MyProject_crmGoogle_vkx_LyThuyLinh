/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

/**
 *
 * @author Administrator
 */
public class Employer {
    private String name;
    private String age;
    private String numberPhone;
    private String Adress;
    private String Crime;

    public Employer(String name, String age, String numberPhone, String Adress,String Crime) {
        this.name = name;
        this.age = age;
        this.numberPhone = numberPhone;
        this.Adress = Adress;
        this.Crime = Crime;
    }
    public Employer()
    {
        this.name=null;
        this.age =null;
        this.numberPhone=null;
        this.Adress=null;
        this.Crime = null;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getAdress() {
        return Adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setCrime(String Crime) {
        this.Crime = Crime;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getCrime() {
        return Crime;
    }

    @Override
    public String toString() {
        return "Employer{" + "name=" + name + ", age=" + age + ", numberPhone=" + numberPhone + ", Adress=" + Adress + ",Crime="+Crime+ '}';
    }
     
    
}
