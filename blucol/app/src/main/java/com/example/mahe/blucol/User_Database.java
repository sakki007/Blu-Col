package com.example.mahe.blucol;

/**
 * Created by mahe on 3/26/2017.
 */
import com.google.firebase.database.IgnoreExtraProperties;

public class User_Database {
    public String name;
    public String address;
    public String cn1;
    public String cn2;
    public String sex;
    public String imageId;
    public String description;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User_Database() {
    }

    public User_Database(String name, String address,String cn1,String cn2,String sex) {
        this.name = name;
        this.address=address;
        this.cn1=cn1;
        this.cn2=cn2;
        this.sex=sex;
        this.imageId = "591b4e44-483b-48aa-ade7-6417ca6fe64s4";
        this.description = "";
    }
}
