
package com.shilpa.categoryms;

import com.shilpa.categoryms.dao.CategoryDAO;
import com.shilpa.categoryms.dao.impl.CategoryDAOImpl;
import com.shilpa.categoryms.entity.Category;
import java.util.Scanner;

public class MainProgram {

   
    public static void main(String[] args) {
         CategoryDAO categoryDAO= new CategoryDAOImpl();
        Scanner input= new Scanner(System.in);
        while(true){
        System.out.println("Enter your choice:");
        System.out.println("1. Add Category:");
        System.out.println("2. Delete Category:");
        System.out.println("3. Show all Categories:");
        System.out.println("4. Search by Id:");
        System.out.println("5. Exit.");
        
        switch(input.nextInt()){
            case 1:
                System.out.println("Add the category:");
                Category c = new Category();
                System.out.println("Enter id:");
                c.setId(input.nextInt());
                System.out.println("Enter name:");
                c.setName(input.next());
                System.out.println("Enter description:");
                c.setDescription(input.next());
                System.out.println("Enter status:");
                c.setStatus(input.nextBoolean());
                if(categoryDAO.insert(c)){
                    System.out.println("Successfully inserted!");
                }
                else{
                    System.out.println("Data exceeded the limit!!");
                }
            break;
            case 2:
              
                System.out.println("Enter the id of the Category to be deleted:");
                 int id= input.nextInt();
                
                if( categoryDAO.delete(id)){
                    System.out.println("Course deleted successfully!");
                    
                }
                else{
                    System.out.println("Id not found!");}
                    break;
            case 3 :
                System.out.println("Show all categories!");
                Category[] categories= categoryDAO.getAll();
                for(int i= 0; i<categories.length;i++){
                    Category category= categories[i];
                    if(category!=null){
                        System.out.println("Id"+category.getId());
                        System.out.println("Name"+category.getName());
                        System.out.println("Description"+ category.getDescription());
                        System.out.println("Status"+category.isStatus());
                        
                    }
                
                }
            break;
            case 4:
               
        System.out.println("Enter the course's id:");
         int result= input.nextInt();
          Category c1 = categoryDAO.getById(result);
      
        if(c1!=null)
        {
             System.out.println("Category's details:");
            System.out.println("Category name: "+ c1.getName());           
            System.out.println("Categorys status: "+c1.isStatus());
            System.out.println("Category's description: "+ c1.getDescription());
        }
        
        else{
            System.out.println("Category doesn't exist!");}
                break;
            case 5:
                System.out.println("Do you want to exit(y/n)?");
                if(input.next().equalsIgnoreCase("y")){
                    System.exit(0);
                }
            break;
                 }
        
        
        }
    }
    
}
