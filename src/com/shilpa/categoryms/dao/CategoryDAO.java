/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shilpa.categoryms.dao;

import com.shilpa.categoryms.entity.Category;


public interface CategoryDAO {
     boolean insert(Category c);
    boolean delete(int id);
    Category getById(int id);
    Category[] getAll();
}
