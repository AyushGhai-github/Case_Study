package com.carDetails.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carDetails.Repository.WashPackRepository;
import com.carDetails.model.WashPack;

@Service
public class washPackServiceImpl implements washPackService {
	@Autowired
    private WashPackRepository washPackRepository;

    @Override
    public WashPack addNewWashPack(WashPack pack) {
        WashPack washpacks = new WashPack() ;
        washpacks.setId(pack.getId());
        washpacks.setPackName(pack.getPackName());
        washpacks.setAmount(pack.getAmount());
        washPackRepository.save(washpacks);
        return washpacks;
    }

    @Override
    public WashPack findByName(String name) {
        return washPackRepository.findAll().stream().filter(p -> p.getPackName()
                .contains(name)).findAny().orElse(null);
    }

	@Override
	public WashPack updateWashPackByName(WashPack pack) {
	
		return washPackRepository.save(pack);
	}

	@Override
	public List<WashPack> getAllWashPack() {
		return  washPackRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		WashPack washPack=new WashPack();
		washPackRepository.deleteById(id);
		
		
	}

//	@Override
//	public WashPack updateById(WashPack pack) {
//		
//		return washPackRepository.save(pack);
//	}

	@Override
	public WashPack getWashPackByid(int id) {
		// TODO Auto-generated method stub
		return washPackRepository.findByid(id);	
	}

	@Override
    public WashPack updateWashPack(WashPack washpacks) {
        return washPackRepository.save(washpacks);
    }
	


}

