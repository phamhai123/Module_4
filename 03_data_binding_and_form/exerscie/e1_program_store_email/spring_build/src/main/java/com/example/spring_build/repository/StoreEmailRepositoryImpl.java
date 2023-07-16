package com.example.spring_build.repository;

import com.example.spring_build.model.StoreEmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StoreEmailRepositoryImpl implements StoreEmailRepository{
    private static List<StoreEmail> emailList = new ArrayList<>();
    static {
        emailList.add(new StoreEmail("English",5,true,"Hai"));
        emailList.add(new StoreEmail("Vietnamese",10,false,"Ba"));
        emailList.add(new StoreEmail("English",25,true,"Bốn"));
    }
    @Override
    public List<StoreEmail> findAll() {
        return emailList;
    }

    @Override
    public boolean add(StoreEmail storeEmail) {
        return emailList.add(storeEmail);
    }
}
