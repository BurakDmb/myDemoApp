
package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static ArrayList<Integer> calculateCommonElements(ArrayList<Integer> array1, ArrayList<Integer> array2, int minVal, int maxVal){
        ArrayList<Integer> tmpList=new ArrayList<>();
        if(array1==null || array2==null) return tmpList;    //returns empty arraylist if any of them is null
        for(int tmpVal1:array1){
            for(int tmpVal2:array2){
                if(tmpVal1==tmpVal2 && tmpVal1>=minVal && tmpVal1<=maxVal){
                    addElement(tmpList,tmpVal1);
                }
            }
        }
        return tmpList;
    }
    //Adds element if not exists in the arraylist, this prevents duplicate values
    private static void addElement(ArrayList<Integer> list, int val){
        boolean found=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==val) found=true;
        }
        if(!found) list.add(val);
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            res.redirect("/compute",301);
            return "";
        });

        post("/compute", (req, res) -> {
        //System.out.println(req.queryParams("input1"));
        //System.out.println(req.queryParams("input2"));

        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
        while (sc1.hasNext())
        {
            String tmp=sc1.next();
            if(tmp!=null && tmp.length()!=0){
                int value = Integer.parseInt(tmp.replaceAll("\\s",""));
                inputList1.add(value);
            }
        }
        //System.out.println(inputList1);


        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext())
        {
            String tmp=sc2.next();
            if(tmp!=null && tmp.length()!=0){
                int value = Integer.parseInt(tmp.replaceAll("\\s",""));
                inputList2.add(value);
            }

        }
        //System.out.println(inputList2);


        String input3 = req.queryParams("input3").replaceAll("\\s","");
        int input3AsInt = Integer.parseInt(input3);

        String input4 = req.queryParams("input4").replaceAll("\\s","");
        int input4AsInt = Integer.parseInt(input4);

        ArrayList<Integer> result = App.calculateCommonElements(inputList1, inputList2, input3AsInt, input4AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }


    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

