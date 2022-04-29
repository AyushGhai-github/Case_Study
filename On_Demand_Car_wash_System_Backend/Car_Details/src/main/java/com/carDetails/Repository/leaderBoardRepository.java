package com.carDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carDetails.model.Leaderboard;



public interface leaderBoardRepository   extends  MongoRepository<Leaderboard,Long>{
	public Leaderboard findByrank(long rank);

}
