package com.wy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wy.mapper.*;


import com.wy.pojo.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.List;


@Service
public class CarSourceServicer {

    @Autowired
    private CarSourceMapper carSourceMapper;

    @Autowired
    private CarTypeMapper carTypeMapper;

    @Autowired
    private AreasMapper areasMapper;

    @Autowired
    private CitiesMapper citiesMapper;
    @Autowired
    private ProvincesMapper provincesMapper;
    @Autowired
    private CarSprcifsMapper carSprcifsMapper;
    @Autowired
    private LineTypeMapper lineTypeMapper;


    public void insertCarSource(CarSource carSource) {
        carSourceMapper.insert(carSource);


    }

    public PageResult<CarSource> queryCarSource(Integer page, Integer rows, String key, Boolean saleable) {
        PageHelper.startPage(page,rows);
        Example example = new Example(CarSource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("title", "%" + key + "%");
        }

        List<CarSource> carSources = carSourceMapper.selectByExample(example);


        PageInfo<CarSource> pageInfo = new PageInfo<>(carSources);
        for (CarSource carSource : carSources) {
            //添加车辆类型字段
            CarType ct = carTypeMapper.selectByPrimaryKey(carSource.getTypeId());
            System.out.println(ct);
            carSource.setType(ct.getName());
            //添加起始地字段
            carSource.setStartPlace(getPlace(carSource.getStartAreaId(),carSource.getStartCityId(),carSource.getStartProvinceId()));
            //添加结束地字段
            carSource.setEndPlace(getPlace(carSource.getEndAreaId(),carSource.getEndCityId(),carSource.getEndProvinceId()));
            //添加装载货物类型字段
            carSource.setCarSpecifs((carSprcifsMapper.selectByPrimaryKey(carSource.getCarSpecifsId()).getName()));
            //添加行车类型
            carSource.setLineType((lineTypeMapper.selectByPrimaryKey(carSource.getLineTypeId()).getLineType()));
        }

        return new PageResult<>(pageInfo.getTotal(),carSources);


    }


    public String getPlace(long areasId, long citiesId,long provincesId){
        String place = new String();

        Areas areas = areasMapper.selectByPrimaryKey(areasId);
        Cities cities = citiesMapper.selectByPrimaryKey(citiesId);
        Provinces provinces = provincesMapper.selectByPrimaryKey(provincesId);
        place=provinces.getProvince()+"-"+cities.getCity()+"-"+areas.getArea();
        return place;
    }

}
