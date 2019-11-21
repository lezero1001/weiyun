package com.wy.controller;


import com.wy.pojo.CarSource;
import com.wy.pojo.PageResult;
import com.wy.service.CarSourceServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CarSourceController {
    @Autowired
    private CarSourceServicer carSourceServicer;


    /**
     * 车源添加
     * @param carSource
     */
    @PostMapping("/insert")
    public void  insertCarSource(@RequestBody CarSource carSource){
        System.out.println(carSource);
        carSourceServicer.insertCarSource(carSource);
    }

    @PostMapping("/delete")
    public void  insertCarSource(@RequestParam("id") int id){
        System.out.println(id);

    }


    @GetMapping("/carsource/page")
    public ResponseEntity<PageResult<CarSource>> querySpuByPage(
            @RequestParam(value="key", required = false) String key,
            @RequestParam(value="saleable", required = false) Boolean saleable,
            @RequestParam(value="page", required = false,defaultValue ="1") Integer page,
            @RequestParam(value="rows", required = false , defaultValue ="5") Integer rows
    ){


        PageResult<CarSource> result = carSourceServicer.queryCarSource(page, rows, key, saleable);

        return ResponseEntity.ok(result);
    }



}
