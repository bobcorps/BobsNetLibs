package com.bobsgame.net;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

//===============================================================================================
public class BobsGameRoom
{//===============================================================================================


	public static Logger log = (Logger) LoggerFactory.getLogger(BobsGameRoom.class);


	public int currentNumPlayers = 0;
	public int maxPlayers = -1;
	public boolean privateRoom = false;
	public boolean tournamentRoom = false;
	public String uuid = "";
	public long hostUserID = -1;
	public boolean multiplayer_AllowDifferentDifficulties = true;
	public boolean multiplayer_AllowDifferentGameSequences = true;
	public boolean multiplayer_GameEndsWhenOnePlayerRemains = true;
	public boolean multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = true;
	public boolean multiplayer_DisableVSGarbage = false;
	public String gameSequenceOrTypeName = "";
	public String gameSequenceUUID = "";
	public String gameTypeUUID = "";
	public String multiplayer_SelectedDifficultyName = "Beginner";
	public boolean isGameSequence = false;
	public boolean isGameType = false;
	public long timeStarted = 0;
	public long timeLastGotUpdate = 0;


	//=========================================================================================================================
	public String encodeRoomData()
	{//=========================================================================================================================

	//hostUserID,roomUUID,`gameSequenceOrTypeName`,isGameSequenceOrType,gameSequenceOrTypeUUID,usersInRoom,maxUsers,private,tournament,multiplayerOptions,
		String s =
			hostUserID +
			"," + uuid;



			s += ",`" + gameSequenceOrTypeName + "`";

			if (isGameType)
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
			"," + (int)(privateRoom? 1 : 0) +
			"," + (int)(tournamentRoom? 1 : 0) +
			"," + multiplayer_SelectedDifficultyName +
			"," + (int)(multiplayer_AllowDifferentDifficulties? 1 : 0) +
			"," + (int)(multiplayer_AllowDifferentGameSequences? 1 : 0) +
			"," + (int)(multiplayer_GameEndsWhenOnePlayerRemains? 1 : 0) +
			"," + (int)(multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel? 1 : 0) +
			"," + (int)(multiplayer_DisableVSGarbage? 1 : 0) +
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
		String isGameSequenceOrType = s.substring(0, s.indexOf(","));
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
		String multiplayer_SelectedDifficultyNameString = s.substring(0, s.indexOf(","));
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



		BobsGameRoom newRoom = new BobsGameRoom();




		int hostUserID = -1;
		try
		{
			hostUserID = Integer.parseInt(hostUserIDString);
		}
		catch (Exception e)
		{
			log.error("hostUserID could not be parsed");
			return null;
		}
		newRoom.hostUserID = hostUserID;

		newRoom.uuid = roomUUID;

		newRoom.gameSequenceOrTypeName = gameSequenceOrTypeName;

		if (isGameSequenceOrType == "GameType")
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
			newRoom.privateRoom = 0 != Integer.parseInt(privateRoomString);
		}
		catch (Exception e)
		{
			log.error("Could not parse privateRoom");
			return null;
		}

		try
		{
			newRoom.tournamentRoom = 0 != Integer.parseInt(tournamentRoomString);
		}
		catch (Exception e)
		{
			log.error("Could not parse tournamentRoom");
			return null;
		}

		newRoom.multiplayer_SelectedDifficultyName = multiplayer_SelectedDifficultyNameString;

		try
		{
			newRoom.multiplayer_AllowDifferentDifficulties = 0 != Integer.parseInt(multiplayer_AllowDifferentDifficultiesString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_AllowDifferentDifficulties");
			return null;
		}

		try
		{
			newRoom.multiplayer_AllowDifferentGameSequences = 0 != Integer.parseInt(multiplayer_AllowDifferentGameSequencesString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_AllowDifferentGameSequences");
			return null;
		}

		try
		{
			newRoom.multiplayer_GameEndsWhenOnePlayerRemains = 0 != Integer.parseInt(multiplayer_GameEndsWhenAllOpponentsLoseString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GameEndsWhenAllOpponentsLose");
			return null;
		}

		try
		{
			newRoom.multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = 0 != Integer.parseInt(multiplayer_GameEndsWhenSomeoneCompletesCreditsLevelString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel");
			return null;
		}

		try
		{
			newRoom.multiplayer_DisableVSGarbage = 0 != Integer.parseInt(multiplayer_DisableVSGarbageString);
		}
		catch (Exception e)
		{
			log.error("Could not parse multiplayer_DisableVSGarbage");
			return null;
		}


		return newRoom;
	}


};


