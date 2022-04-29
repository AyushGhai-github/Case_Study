package com.carDetails.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carDetails.model.WashPack;




public interface washPackService {
	public List<WashPack> getAllWashPack();
	public WashPack addNewWashPack(WashPack pack);

    public WashPack findByName(String name);

    public WashPack updateWashPackByName(WashPack pack);
    
    public void deleteById(int id);
    
//    public WashPack updateById(WashPack pack);
    
    public WashPack getWashPackByid(int id);
    public WashPack updateWashPack(WashPack washpacks);
    
    
 

}
