package com.carDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carDetails.Repository.leaderBoardRepository;
import com.carDetails.model.Leaderboard;

@Service
public class leaderBoardImpl implements leaderBoardService {
	
	@Autowired 
	private leaderBoardRepository leaderboardRepository;

	@Override
	public Leaderboard addNewWasherToLeaderboard(Leaderboard leaderboard) {
		
		Leaderboard Leaderboard1 = new Leaderboard();
        Leaderboard1.setRank(leaderboard.getRank());
        Leaderboard1.setWasherName(leaderboard.getWasherName());
        Leaderboard1.setWaterSavedInLiters(leaderboard.getWaterSavedInLiters());
        Leaderboard1.setWorkingHrs(leaderboard.getWorkingHrs());
        return leaderboardRepository.save(Leaderboard1);
	}

	@Override
	public List<Leaderboard> getWasherLeaderboard() {
		
		return  leaderboardRepository.findAll();
	}

	@Override
	public Leaderboard updateLeaderboard(Leaderboard leaderboard) {
		// TODO Auto-generated method stub
		return leaderboardRepository.save(leaderboard);
	}

	@Override
	public Leaderboard findByrank(long rank) {
		// TODO Auto-generated method stub
		return leaderboardRepository.findByrank(rank);
	}

	
	
	
	

	

}
