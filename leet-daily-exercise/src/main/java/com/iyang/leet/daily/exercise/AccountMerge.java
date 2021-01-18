package com.iyang.leet.daily.exercise;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 账户合并问题
 * leetCode :   721
 *
 * @author Yang
 */
public class AccountMerge {

    public static void main(String[] args) {

        List<List<String>> values = new ArrayList<>();
        List<String> v1 = new ArrayList<>();
        v1.add("John");
        v1.add("johnsmith@mail.com");
        v1.add("john00@mail.com");

        List<String> v2 = new ArrayList<>();
        v2.add("John");
        v2.add("johnnybravo@mail.com");

        List<String> v3 = new ArrayList<>();
        v3.add("John");
        v3.add("johnsmith@mail.com");
        v3.add("john_newyork@mail.com");

        List<String> v4 = new ArrayList<>();
        v4.add("Mary");
        v4.add("mary@mail.com");

        values.add(v1);
        values.add(v2);
        values.add(v3);
        values.add(v4);
        accountMerge(values);
    }

    public static void accountMergeByLeetCode(List<List<String>> accounts){

        // 找到 email 对应的下标  和  email 对应的名字
        Map<String,Integer> emailToIndex =  new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                // 获取 email 值
                String nextEmail = account.get(i);
                // 获取下标 ; emailToIndex 就相当于全部初始化一遍了 email 对应的下标,如果有重复的,前者优先.
                // 这里
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();

        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }


        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        System.out.println(merged);

    }

    /**
     * 自己做的.
     * 暴力 + 不可读, 然后再加上各种问题.
     * 比如 allCacheIndex 这种,如果是重复的数据的话,这里会叠加,肯定是存在问题的.
     *
     * @param accounts
     */
    public static void accountMerge(List<List<String>> accounts){
        Map<String,List<Integer>> emailIndexListMap = new HashMap<>();

        int index = 0;
        String allCacheIndex = "";
        for(List<String> arrays : accounts){


            for(int i=1,j=arrays.size();i<j;i++){
                String s = arrays.get(i);
                List<Integer> indexList =
                        emailIndexListMap.getOrDefault(s,new ArrayList<Integer>());
                indexList.add(index);
                if(indexList.size() >=2 ){
                    allCacheIndex += Arrays.asList(indexList);
                }
                emailIndexListMap.put(s,indexList);
            }

            index ++;
        }

        System.out.println(emailIndexListMap);

        List<Set<String>> result = new ArrayList<>();
        List<String> indexCache = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry : emailIndexListMap.entrySet()){
            List<Integer> value = entry.getValue();
            Set<String> values = new HashSet<>();
            String indexStr = "";
            if(value.size() == 1 && allCacheIndex.contains(value.get(0)+"")){
                continue;
            }

            for(Integer i : value){
                if(indexCache.contains(i+"")){
                    continue;
                }
                indexStr += i;
                values.addAll(accounts.get(i));
            }
            indexCache.add(indexStr);
            if(!"".equals(indexStr)){
                result.add(values);
            }
        }

        System.out.println(result);
    }

}


class UnionFind {

    int [] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int index){
        if(parent[index] != index){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    public void union(int index1,int index2){

        parent[find(index2)]  = find(index1);

    }

}