package Modele;

import Modele.Customers;

public class MemberCustomers extends Customers {

    // ATTRIBUTS ET CONSTRUCTEUR xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public enum MemberType{
        SENIOR,REGULAR,CHILDREN
    }

    private MemberType type;

    public MemberCustomers(MemberType type){
        this.type = type;
    }


    // METHODES xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx



    public void book(){

    }


    // GETTER ET SETTER xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx




    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }


}
