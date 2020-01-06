package com.yang.stack.book.animal;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 16:39
 * @Version 1.0
 * @qq: 1411091515
 */
public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue() {
    }

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getEnterPetType(){
        return this.pet.getType();
    }
}
