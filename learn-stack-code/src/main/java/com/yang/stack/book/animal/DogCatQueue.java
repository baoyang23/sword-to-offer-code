package com.yang.stack.book.animal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 16:41
 * @Version 1.0
 * @qq: 1411091515
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public Pet pollAll(){
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
            if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        } else if(!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("The Queue data has error.");
        }
    }

    public void add(Pet pet){
        if(pet.getType().equalsIgnoreCase("dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        } else if(pet.getType().equalsIgnoreCase("cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        } else {
            throw new RuntimeException("This is type has error.Not car and dog.");
        }
    }

    public Dog pooDog(){
        if(!this.isDogEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty.");
        }
    }

    public Cat pollCat(){
        if(!this.isCatEmpty()){
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty.");
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty(){
        return this.catQ.isEmpty();
    }

}
