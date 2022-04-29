package com.carDetails.Service;

import java.util.List;

import com.carDetails.model.Leaderboard;

public interface leaderBoardService {
	
	public Leaderboard addNewWasherToLeaderboard(Leaderboard leaderboard);
	
	 public List<Leaderboard> getWasherLeaderboard();
	 
	 public Leaderboard updateLeaderboard(Leaderboard leaderboard);
	 
   public Leaderboard findByrank(long rank);
	 
	 

}
