package com.example.demo;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class Controller {

    @Autowired
    private ExempleRepo repo1;

    @GetMapping("/tester/")
    public String tester(){
        System.out.println("hey it's me again");
        return "hey spring boot";
    }

    @PostMapping("/tester11/")
    public String tester1(@RequestBody @Valid userFormat user){
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "une demande Post";
    }

    @PostMapping("/tester11/{nb}")
    public String tester111(@PathVariable int nb){
        if(true)
          throw new RuntimeException("hey");



        if(nb%2==0) return "le nombre saisie est pair";
        else return "le nombre saisie est impair";
    }




    @PostMapping("/tester888/")
    public String tester77(@RequestBody String param11){
        if(true){
            throw new RuntimeException("erreur 1111");
        }
        return "saisie valide";
    }


    @PostMapping("/recupererUsers/")
    public List<User> tester888(){
        List<User> liste1=new LinkedList<>();

        for(int i=1;i<=10;i++){
            liste1.add(new User("USER"+i,"password"));
        }

        return liste1;
    }

    @PostMapping("/Ajouter/")
    public String Ajouter1(@RequestBody ExempleFormat element){
        Exemple e1=new Exemple();
        e1.setName1(element.getName1());
        e1.setName2(element.getName2());


        var saved=repo1.save(e1);

        if(saved.getId()==null){
            return "une erreur s'est produite";
        }

        return "avec Succes";


    }


    @GetMapping("/recuperer1/")
    public List<ExempleFormat1> get1(){
        var elements=repo1.findAll();

        List<ExempleFormat1> list1=elements.stream().map((element)->{
            ExempleFormat1 forme1=new ExempleFormat1();
            forme1.setId(element.getId());
            forme1.setName1(element.getName1());
            forme1.setName2(element.getName2());
            return forme1;
        }).collect(Collectors.toList());


        return list1;
    }


    @DeleteMapping("/supprimer1/{id}")
    public String Supprimer(@PathVariable int id){
        if(!repo1.existsById(id)){
           return "element introuvable";
        }

        repo1.deleteById(id);
        return "suppression avec succes";
    }







}
