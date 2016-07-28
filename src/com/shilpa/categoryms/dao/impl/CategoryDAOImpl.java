/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shilpa.categoryms.dao.impl;

import com.shilpa.categoryms.dao.CategoryDAO;
import com.shilpa.categoryms.entity.Category;


public class CategoryDAOImpl implements CategoryDAO {
    private int counter = 0;
    private Category[] categoryList = new Category[10];
    

    @Override
    public boolean insert(Category c) {
        if (categoryList.length== counter){
            return false;
        }
            categoryList[counter]= c;
            counter++;
            return true;
        
    }

    

    @Override
    public boolean delete(int id) {
        for (int i =0; i<categoryList.length;i++){
            Category c= categoryList[i];
            if(c!= null && c.getId()== id){
            categoryList[i]=null;
            return true;
        }
            
        }
        return false;
    }

    @Override
    public Category getById(int id) {
        for (int i =0; i<categoryList.length;i++){
            Category c= categoryList[i];
            if(c!= null && c.getId()== id){
            return c;
        }
            
        }
        return null;
    }

    @Override
    public Category[] getAll() {
        return categoryList;
    }
    
}
