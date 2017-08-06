package com.bobsgame.net;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

//===============================================================================================
public class BobsGameRoom
{//===============================================================================================


	public static Logger log = (Logger) LoggerFactory.getLogger(BobsGameRoom.class);


	public int currentNumPlayers = 0;
	public int maxPlayers = 0;
	public int privateRoom = 0;
	public int tournamentRoom = 0;
	public String uuid = "";
	public long hostUserID = 0;
	public int multiplayer_AllowDifferentDifficulties = 1;
	public int multiplayer_AllowDifferentGameSequences = 1;
	public int multiplayer_GameEndsWhenOnePlayerRemains = 1;
	public int multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = 1;
	public int multiplayer_DisableVSGarbage = 0;
	public String gameSequenceOrTypeName = "";
	public String gameSequenceUUID = "";
	public String gameTypeUUID = "";
	public String difficultyName = "Beginner";
	public int endlessMode = 0;
	//public boolean isGameSequence = false;
	//public boolean isGameType = false;
	public long timeStarted = 0;
	public long timeLastGotUpdate = 0;

	public String isGameSequenceOrType = "";



	public float gameSpeedStart = 0.01f;
	public float gameSpeedIncreaseRate = 0.02f;
	public float gameSpeedMaximum = 1.0f;//can be 0.1 to 10.0 although that won't make sense
	public float levelUpMultiplier = 1.0f;//can be negative
	public float levelUpCompoundMultiplier = 1.0f;//can be negative
	public int multiplayer_AllowNewPlayersDuringGame = 0;
	public int multiplayer_UseTeams = 0;
	public float multiplayer_GarbageMultiplier = 1.0f;
	public int multiplayer_GarbageLimit = 0;
	public int multiplayer_GarbageScaleByDifficulty = 1;//scale garbage by difficulty, beginner->insane 2x, insane->beginner 0.5x, etc.
	public int multiplayer_SendGarbageTo = (int)0;
	public int floorSpinLimit = 0;
	public float lockDelayDecreaseMultiplier = 0;
	public int lockDelayLimit = 0;
	public int lockDelayMinimum = 0;
	public int stackWaitLimit = 0;
	//public int multiplayer_DropDelayLimit = 0;
	public int spawnDelayLimit = 0;
	public float spawnDelayDecreaseRate = 0;
	public int spawnDelayMinimum = 0;
	public int dropDelayMinimum = 0;

	//=========================================================================================================================
	public String encodeRoomData()
	{//=========================================================================================================================

	//hostUserID,roomUUID,`gameSequenceOrTypeName`,isGameSequenceOrType,gameSequenceOrTypeUUID,usersInRoom,maxUsers,private,tournament,multiplayerOptions,
		String s =
			hostUserID +
			"," + uuid;



			s += ",`" + gameSequenceOrTypeName + "`";

			if (isGameSequenceOrType.equals("GameType"))
			{
				s += ",GameType," + gameTypeUUID;
			}
			else
			{
				s += ",GameSequence," + gameSequenceUUID;
			}



		s+=

			"," + currentNumPlayers +
			"," + maxPlayers +
			"," + privateRoom +
			"," + tournamentRoom +
			"," + difficultyName +
			"," + endlessMode +
			"," + multiplayer_AllowDifferentDifficulties +
			"," + multiplayer_AllowDifferentGameSequences +
			"," + multiplayer_GameEndsWhenOnePlayerRemains +
			"," + multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel +
			"," + multiplayer_DisableVSGarbage +

			"," + (gameSpeedStart) +
			"," + (gameSpeedIncreaseRate) +
			"," + (gameSpeedMaximum) +
			"," + (levelUpMultiplier) +
			"," + (levelUpCompoundMultiplier) +
			"," + (multiplayer_AllowNewPlayersDuringGame) +
			"," + (multiplayer_UseTeams) +
			"," + (multiplayer_GarbageMultiplier) +
			"," + (multiplayer_GarbageLimit) +
			"," + (multiplayer_GarbageScaleByDifficulty) +
			"," + (multiplayer_SendGarbageTo) +
			"," + (floorSpinLimit) +
			"," + (lockDelayLimit) +
			"," + (lockDelayDecreaseMultiplier) +
			"," + (lockDelayMinimum) +
			"," + (stackWaitLimit) +

			"," + (spawnDelayLimit) +
			"," + (spawnDelayDecreaseRate) +
			"," + (spawnDelayMinimum) +
			"," + (dropDelayMinimum) +


			",";


		return s;
	}


	//=========================================================================================================================
	public BobsGameRoom decodeRoomData(String s)
	{//=========================================================================================================================


		String hostUserIDString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String roomUUID = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		s = s.substring(s.indexOf("`") + 1);
		String gameSequenceOrTypeName = s.substring(0, s.indexOf("`"));
		s = s.substring(s.indexOf("`") + 1);
		s = s.substring(s.indexOf(",") + 1);
		isGameSequenceOrType = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String gameSequenceOrTypeUUID = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String playersString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String maxPlayersString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String privateRoomString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String tournamentRoomString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);




		String difficultyNameString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);

		String endlessModeString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);


		String multiplayer_AllowDifferentDifficultiesString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_AllowDifferentGameSequencesString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_GameEndsWhenAllOpponentsLoseString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_GameEndsWhenSomeoneCompletesCreditsLevelString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_DisableVSGarbageString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);




		String gameSpeedStartString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String gameSpeedIncreaseRateString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String gameSpeedMaximumString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String levelUpMultiplierString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String levelUpCompoundMultiplierString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_AllowNewPlayersDuringGameString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_UseTeamsString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_GarbageMultiplierString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_GarbageLimitString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_GarbageScaleByDifficultyString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_SendGarbageToString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_FloorSpinLimitString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		
		String multiplayer_LockDelayLimitString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		
		String multiplayer_LockDelayDecreaseMultiplierString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);

		String multiplayer_LockDelayMinimumString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);
		String multiplayer_StackWaitLimitString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);


		String multiplayer_SpawnDelayLimitString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);



		String multiplayer_SpawnDelayDecreaseRateString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);

		String multiplayer_SpawnDelayMinimumString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);

		String multiplayer_DropDelayMinimumString = s.substring(0, s.indexOf(","));
		s = s.substring(s.indexOf(",") + 1);


		BobsGameRoom newRoom = new BobsGameRoom();




		int hostUserID = -1;
		try
		{
			hostUserID = Integer.parseInt(hostUserIDString);
		}
		catch (Exception e)
		{
			log.error("hostUserID could not be parsed");
			e.printStackTrace();
			return null;
		}
		newRoom.hostUserID = hostUserID;

		newRoom.uuid = roomUUID;

		newRoom.gameSequenceOrTypeName = gameSequenceOrTypeName;

		if (isGameSequenceOrType.equals("GameType"))
		{
			//newRoom.isSingleGameType = true;
			newRoom.gameTypeUUID = gameSequenceOrTypeUUID;
		}
		else
		{
			//newRoom.isGameSequence = true;
			newRoom.gameSequenceUUID = gameSequenceOrTypeUUID;
		}

		int numPlayers = -1;
		try
		{
			numPlayers = Integer.parseInt(playersString);
		}
		catch (Exception e)
		{
			log.error("numPlayers could not be parsed");
			return null;
		}
		newRoom.currentNumPlayers = numPlayers;

		try
		{
			newRoom.maxPlayers = Integer.parseInt(maxPlayersString);
		}
		catch (Exception e)
		{
			log.error("Could not parse maxPlayers");
			return null;
		}

		try
		{
			newRoom.privateRoom = Integer.parseInt(privateRoomString);
		}
		catch (Exception e)
		{
			log.error("Could not parse privateRoom");
			return null;
		}

		try
		{
			newRoom.tournamentRoom = Integer.parseInt(tournamentRoomString);
		}
		catch (Exception e)
		{
			log.error("Could not parse tournamentRoom");
			return null;
		}

		newRoom.difficultyName = difficultyNameString;


		try
		{
			newRoom.endlessMode = Integer.parseInt(endlessModeString);
		}
		catch (Exception e)
		{
			log.error("Could not parse endlessMode");
			//return null;
		}


		try
		{
			newRoom.multiplayer_AllowDifferentDifficulties = Integer.parseInt(multiplayer_AllowDifferentDifficultiesString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_AllowDifferentDifficulties");
			//return null;
		}



		try
		{
			newRoom.multiplayer_AllowDifferentGameSequences = Integer.parseInt(multiplayer_AllowDifferentGameSequencesString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_AllowDifferentGameSequences");
			//return null;
		}

		try
		{
			newRoom.multiplayer_GameEndsWhenOnePlayerRemains = Integer.parseInt(multiplayer_GameEndsWhenAllOpponentsLoseString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GameEndsWhenAllOpponentsLose");
			//return null;
		}

		try
		{
			newRoom.multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = Integer.parseInt(multiplayer_GameEndsWhenSomeoneCompletesCreditsLevelString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel");
			//return null;
		}

		try
		{
			newRoom.multiplayer_DisableVSGarbage = Integer.parseInt(multiplayer_DisableVSGarbageString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_DisableVSGarbage");
			//return null;
		}

		
		try
		{
			newRoom.gameSpeedStart							 = Float.parseFloat(gameSpeedStartString);
		}
		catch (Exception e)
		{
			log.error("Could not parse gameSpeedStart");
			//return null;
		}
		
		try
		{
			newRoom.gameSpeedIncreaseRate					 = Float.parseFloat(gameSpeedIncreaseRateString);
		}
		catch (Exception e)
		{
			log.error("Could not parse gameSpeedIncreaseRate");
			//return null;
		}
		
		try
		{
			newRoom.gameSpeedMaximum						 = Float.parseFloat(gameSpeedMaximumString);
		}
		catch (Exception e)
		{
			log.error("Could not parse gameSpeedMaximum");
			//return null;
		}
		
		try
		{
			newRoom.levelUpMultiplier						 = Float.parseFloat(levelUpMultiplierString);
		}
		catch (Exception e)
		{
			log.error("Could not parse levelUpMultiplier");
			//return null;
		}
		
		try
		{
			newRoom.levelUpCompoundMultiplier				 = Float.parseFloat(levelUpCompoundMultiplierString);
		}
		catch (Exception e)
		{
			log.error("Could not parse levelUpCompoundMultiplier");
			//return null;
		}

		try
		{
			newRoom.multiplayer_AllowNewPlayersDuringGame	 = Integer.parseInt(multiplayer_AllowNewPlayersDuringGameString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_AllowNewPlayersDuringGame");
			//return null;
		}

		try
		{
			newRoom.multiplayer_UseTeams					 = Integer.parseInt(multiplayer_UseTeamsString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_UseTeams");
			//return null;
		}

		try
		{
			newRoom.multiplayer_GarbageMultiplier			 = Float.parseFloat(multiplayer_GarbageMultiplierString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GarbageMultiplier");
			//return null;
		}
		
		try
		{
			newRoom.multiplayer_GarbageLimit				 = Integer.parseInt(multiplayer_GarbageLimitString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GarbageLimit");
			//return null;
		}
		
		try
		{
			newRoom.multiplayer_GarbageScaleByDifficulty	 = Integer.parseInt(multiplayer_GarbageScaleByDifficultyString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GarbageScaleByDifficulty");
			//return null;
		}
		
		try
		{
			newRoom.multiplayer_SendGarbageTo				 = Integer.parseInt(multiplayer_SendGarbageToString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_SendGarbageTo");
			//return null;
		}
		
		try
		{
			newRoom.floorSpinLimit				 = Integer.parseInt(multiplayer_FloorSpinLimitString);
		}
		catch (Exception e)
		{
			log.error("Could not parse floorSpinLimit");
			//return null;
		}
		
		try
		{
			//if(multiplayer_LockDelayLimitString.equals("-1")) {newRoom.lockDelayLimit=-1;}
			//else
			newRoom.lockDelayLimit				 = Integer.parseInt(multiplayer_LockDelayLimitString);
		}
		catch (Exception e)
		{
			log.error("Could not parse lockDelayLimit");
			//return null;
		}
		
		
		try
		{
			newRoom.lockDelayDecreaseMultiplier	 = Float.parseFloat(multiplayer_LockDelayDecreaseMultiplierString);
		}
		catch (Exception e)
		{
			log.error("Could not parse lockDelayDecreaseMultiplier");
			//return null;
		}
		

		try
		{
			newRoom.lockDelayMinimum			 = Integer.parseInt(multiplayer_LockDelayMinimumString);
		}
		catch (Exception e)
		{
			log.error("Could not parse lockDelayMinimum");
			//return null;
		}
		
		
		try
		{
			newRoom.stackWaitLimit				 = Integer.parseInt(multiplayer_StackWaitLimitString);
		}
		catch (Exception e)
		{
			log.error("Could not parse stackWaitLimit");
			//return null;
		}
		
		
		try
		{
			newRoom.spawnDelayLimit			 	 = Integer.parseInt(multiplayer_SpawnDelayLimitString);
		}
		catch (Exception e)
		{
			log.error("Could not parse spawnDelayLimit");
			//return null;
		}
		
		try
		{
			newRoom.spawnDelayDecreaseRate		 = Float.parseFloat(multiplayer_SpawnDelayDecreaseRateString);
		}
		catch (Exception e)
		{
			log.error("Could not parse spawnDelayDecreaseRate");
			//return null;
		}
		
		try
		{
			newRoom.spawnDelayMinimum			 = Integer.parseInt(multiplayer_SpawnDelayMinimumString);
		}
		catch (Exception e)
		{
			log.error("Could not parse spawnDelayMinimum");
			//return null;
		}
		
		
		try
		{
			//if(multiplayer_DropDelayMinimumString.equals("-1")) {newRoom.dropDelayMinimum=-1;}
			//else
			newRoom.dropDelayMinimum			 = Integer.parseInt(multiplayer_DropDelayMinimumString);
		}
		catch (Exception e)
		{
			log.error("Could not parse dropDelayMinimum");
			//return null;
		}
		
		
		
		return newRoom;
	}


};


