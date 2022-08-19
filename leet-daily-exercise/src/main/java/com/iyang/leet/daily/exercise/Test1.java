package com.iyang.leet.daily.exercise;

/***
 * @author: baoyang
 * @data: 2022/7/26
 * @desc:
 ***/
public class Test1 {

    public static void main(String[] args) {

        String url = "http://172.21.129.78:8090/qualitis/api/v1/redirect?redirect=http%3A%2F%2F172.21.129.78%3A8090%2F%23%2Fprojects%2Frules%3FworkflowProject%3Dtrue%26tpl%3DnewSingleTableRule%26projectId%3Dnull%26ruleGroupId%3D%24%7BruleGroupId%7D%26nodeId%3D%24%7BnodeId%7D%26contextID%3D%24%7BcontextID%7D%26nodeName%3D%24%7BnodeName%7D%26env%3Ddev&dssurl=${dssurl}&cookies=${cookies}";
        System.out.println(url.contains("qualitis/api/v1/redirect"));
        url = url.replace("qualitis/api/v1/redirect","");

        System.out.println(url);
    }

}
