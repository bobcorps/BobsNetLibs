package com.bobsgame.net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;


//===============================================================================================
//game stats logs stats for every single game that every user plays
public class BobsGameGameStats
{//===============================================================================================



	public static Logger log = (Logger) LoggerFactory.getLogger(BobsGameGameStats.class);


	public String userName = "";
	public long userID = 0;

	public String isGameSequenceOrType = "";
	public String gameTypeName = "";
	public String gameTypeUUID = "";
	public String gameSequenceName = "";
	public String gameSequenceUUID = "";
	public String difficultyName = "";
	
	public String gameTypeEndedOnName = "";
	public String gameTypeEndedOnUUID = "";
	

	public int won = 0;
	public int died = 0;
	public int lost = 0;
	public int complete = 0;
	public int isLocalMultiplayer = 0;
	public int isNetworkMultiplayer = 0;
	public int numPlayers = 1;


	public int level = 0;
	public long timeLasted = 0;
	public long timeStarted = 0;
	public long timeEnded = 0;
	public int blocksMade = 0;
	public int piecesMade = 0;
	public int blocksCleared = 0;
	public int piecesPlaced = 0;
	public int combosMade = 0;
	public int biggestCombo = 0;

	//public String room_DifficultyName = "";
	//public int singlePlayer_randomizeSequence = 0;
	//public int endlessMode = 0;
	//public int multiplayer_NumPlayers = 0;

	//public int maxPlayers = 0;
	//public int privateRoom = 0;
	//public int tournamentRoom = 0;
	//public long hostUserID = 0;
	//public int multiplayer_AllowDifferentDifficulties = 1;
	//public int multiplayer_AllowDifferentGameSequences = 1;
	//public int multiplayer_GameEndsWhenOnePlayerRemains = 1;
	//public int multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = 1;
	//public int multiplayer_DisableVSGarbage = 0;


	public String allFrameStatesZipped = "";
	public String statsUUID = "";
	public String playerIDsCSV = "";//id:`userName`:lost,id:`userName`:won,:

	
	
	public BobsGameRoom room = null;

//game type or sequence,
//sequence options
//sequence uuid or gametype uuid
//time started, time finished, time lasted
//blocks made, pieces made, blocks cleared
//was multiplayer,
//number of players
//multiplayer options,
//whether won / lost
//send replay packet as well

//===============================================================================================
public String encode()
{//===============================================================================================
	String s = "";

	s += "`" + userName + "`" + ","
		+ userID + ","
		+ isGameSequenceOrType + ","
		+ "`" + gameTypeName + "`" + ","
		+ gameTypeUUID + ","
		+ "`" + gameSequenceName + "`" + ","
		+ gameSequenceUUID + ","
		+ difficultyName + ","
		+ "`" + gameTypeEndedOnName + "`" + ","
		+ gameTypeEndedOnUUID + ","
		+ won + ","
		+ died + ","
		+ lost + ","
		+ complete + ","
		+ isLocalMultiplayer + ","
		+ isNetworkMultiplayer + ","
		+ numPlayers + ","
		+ level + ","
		+ timeLasted + ","
		+ timeStarted + ","
		+ timeEnded + ","
		+ blocksMade + ","
		+ piecesMade + ","
		+ blocksCleared + ","
		+ piecesPlaced + ","
		+ combosMade + ","
		+ biggestCombo + ","
		//+ maxPlayers + ","
		//+ privateRoom + ","
		//+ tournamentRoom + ","
		//+ hostUserID + ","
		//+ multiplayer_AllowDifferentDifficulties + ","
		//+ multiplayer_AllowDifferentGameSequences + ","
		//+ multiplayer_GameEndsWhenOnePlayerRemains + ","
		//+ multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel + ","
		//+ multiplayer_DisableVSGarbage + ","
		+ allFrameStatesZipped + ","
		+ statsUUID + ","
		+ playerIDsCSV + ":"
		+ room.encodeRoomData() + ":";


	return s;
}

//===============================================================================================
public BobsGameGameStats(String s)
{//===============================================================================================
	decode(s);
}


//===============================================================================================
public void decode(String s)
{//===============================================================================================



	s = s.substring(s.indexOf("`") + 1);
	userName = s.substring(0, s.indexOf("`"));
	s = s.substring(s.indexOf("`") + 1);
	s = s.substring(s.indexOf(",") + 1);
	String userIDString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	
	isGameSequenceOrType = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	s = s.substring(s.indexOf("`") + 1);
	gameTypeName = s.substring(0, s.indexOf("`"));
	s = s.substring(s.indexOf("`") + 1);
	s = s.substring(s.indexOf(",") + 1);
	gameTypeUUID = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	s = s.substring(s.indexOf("`") + 1);
	gameSequenceName = s.substring(0, s.indexOf("`"));
	s = s.substring(s.indexOf("`") + 1);
	s = s.substring(s.indexOf(",") + 1);
	gameSequenceUUID = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	
	difficultyName = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	
	s = s.substring(s.indexOf("`") + 1);
	gameTypeEndedOnName = s.substring(0, s.indexOf("`"));
	s = s.substring(s.indexOf("`") + 1);
	s = s.substring(s.indexOf(",") + 1);
	
	gameTypeEndedOnUUID = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	

	String wonString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String diedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String lostString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String completeString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String isLocalMultiplayerString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String isNetworkMultiplayerString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String numPlayersString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String levelString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String timeLastedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String timeStartedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String timeEndedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String blocksMadeString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String piecesMadeString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String blocksClearedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String piecesPlacedString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String combosMadeString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	String biggestComboString = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
//	String maxPlayersString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String privateRoomString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String tournamentRoomString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String hostUserIDString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);

	//room_DifficultyName = s.substring(0, s.indexOf(","));
	//s = s.substring(s.indexOf(",") + 1);
//	String singlePlayer_randomizeSequenceString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String endlessModeString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String multiplayer_NumPlayersString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//
//
//	String multiplayer_AllowDifferentDifficultiesString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String multiplayer_AllowDifferentGameSequencesString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String multiplayer_GameEndsWhenOnePlayerRemainsString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String multiplayer_GameEndsWhenSomeoneCompletesCreditsLevelString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
//	String multiplayer_DisableVSGarbageString = s.substring(0, s.indexOf(","));
//	s = s.substring(s.indexOf(",") + 1);
	allFrameStatesZipped = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	statsUUID = s.substring(0, s.indexOf(","));
	s = s.substring(s.indexOf(",") + 1);
	while (s.substring(0, 1).equals(":")==false)//id:`userName`:lost,id:`userName`:won,:
	{
		playerIDsCSV += s.substring(0, s.indexOf("`") + 1);
		s = s.substring(s.indexOf("`") + 1);
		playerIDsCSV += s.substring(0, s.indexOf("`") + 1);
		s = s.substring(s.indexOf("`") + 1);
		playerIDsCSV += s.substring(0, s.indexOf(",") + 1);
		s = s.substring(s.indexOf(",") + 1);
	}
	s = s.substring(s.indexOf(":") + 1);
	room = new BobsGameRoom(s);


	try
	{
		userID = Long.parseLong(userIDString);
	}
	catch (Exception e)
	{
		log.error("Could not parse userID");
		return;
	}

	try
	{
		won = Integer.parseInt(wonString);
	}
	catch (Exception e)
	{
		log.error("Could not parse won");
		return;
	}

	try
	{
		died = Integer.parseInt(diedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse died");
		return;
	}

	try
	{
		lost = Integer.parseInt(lostString);
	}
	catch (Exception e)
	{
		log.error("Could not parse lost");
		return;
	}

	try
	{
		complete = Integer.parseInt(completeString);
	}
	catch (Exception e)
	{
		log.error("Could not parse complete");
		return;
	}

	try
	{
		isLocalMultiplayer = Integer.parseInt(isLocalMultiplayerString);
	}
	catch (Exception e)
	{
		log.error("Could not parse isLocalMultiplayer");
		return;
	}

	try
	{
		isNetworkMultiplayer = Integer.parseInt(isNetworkMultiplayerString);
	}
	catch (Exception e)
	{
		log.error("Could not parse isNetworkMultiplayer");
		return;
	}

	try
	{
		numPlayers = Integer.parseInt(numPlayersString);
	}
	catch (Exception e)
	{
		log.error("Could not parse numPlayers");
		return;
	}

	try
	{
		level = Integer.parseInt(levelString);
	}
	catch (Exception e)
	{
		log.error("Could not parse level");
		return;
	}

	try
	{
		timeLasted = Long.parseLong(timeLastedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse timeLasted");
		return;
	}

	try
	{
		timeStarted = Long.parseLong(timeStartedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse timeStarted");
		return;
	}

	try
	{
		timeEnded = Long.parseLong(timeEndedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse timeEnded");
		return;
	}

	try
	{
		blocksMade = Integer.parseInt(blocksMadeString);
	}
	catch (Exception e)
	{
		log.error("Could not parse blocksMade");
		return;
	}

	try
	{
		piecesMade = Integer.parseInt(piecesMadeString);
	}
	catch (Exception e)
	{
		log.error("Could not parse piecesMade");
		return;
	}

	try
	{
		blocksCleared = Integer.parseInt(blocksClearedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse blocksCleared");
		return;
	}

	try
	{
		piecesPlaced = Integer.parseInt(piecesPlacedString);
	}
	catch (Exception e)
	{
		log.error("Could not parse piecesPlaced");
		return;
	}

	try
	{
		combosMade = Integer.parseInt(combosMadeString);
	}
	catch (Exception e)
	{
		log.error("Could not parse combosMade");
		return;
	}

	try
	{
		biggestCombo = Integer.parseInt(biggestComboString);
	}
	catch (Exception e)
	{
		log.error("Could not parse biggestCombo");
		return;
	}

//	try
//	{
//		maxPlayers = Integer.parseInt(maxPlayersString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse maxPlayers");
//		return;
//	}
//
//	try
//	{
//		privateRoom = Integer.parseInt(privateRoomString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse privateRoom");
//		return;
//	}
//
//	try
//	{
//		tournamentRoom = Integer.parseInt(tournamentRoomString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse tournamentRoom");
//		return;
//	}
//
//	try
//	{
//		hostUserID = Long.parseLong(hostUserIDString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse hostUserID");
//		return;
//	}
//
//
//
//
//
//	try
//	{
//		singlePlayer_randomizeSequence = Integer.parseInt(singlePlayer_randomizeSequenceString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_AllowDifferentDifficulties");
//		return;
//	}
//
//
//
//	try
//	{
//		endlessMode = Integer.parseInt(endlessModeString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_AllowDifferentDifficulties");
//		return;
//	}
//
//
//
//	try
//	{
//		multiplayer_NumPlayers = Integer.parseInt(multiplayer_NumPlayersString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_AllowDifferentDifficulties");
//		return;
//	}
//
//
//
//	try
//	{
//		multiplayer_AllowDifferentDifficulties = Integer.parseInt(multiplayer_AllowDifferentDifficultiesString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_AllowDifferentDifficulties");
//		return;
//	}
//
//	try
//	{
//		multiplayer_AllowDifferentGameSequences = Integer.parseInt(multiplayer_AllowDifferentGameSequencesString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_AllowDifferentGameSequences");
//		return;
//	}
//
//	try
//	{
//		multiplayer_GameEndsWhenOnePlayerRemains = Integer.parseInt(multiplayer_GameEndsWhenOnePlayerRemainsString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_GameEndsWhenOnePlayerRemains");
//		return;
//	}
//
//	try
//	{
//		multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = Integer.parseInt(multiplayer_GameEndsWhenSomeoneCompletesCreditsLevelString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel");
//		return;
//	}
//
//	try
//	{
//		multiplayer_DisableVSGarbage = Integer.parseInt(multiplayer_DisableVSGarbageString);
//	}
//	catch (Exception e)
//	{
//		log.error("Could not parse multiplayer_DisableVSGarbage");
//		return;
//	}


}


//===============================================================================================
public BobsGameGameStats(ResultSet databaseResultSet)
{//===============================================================================================

	try
	{


		userName = databaseResultSet.getString("userName");
		userID = databaseResultSet.getLong("userID");
		isGameSequenceOrType = databaseResultSet.getString("isGameSequenceOrType");
		gameTypeName = databaseResultSet.getString("gameTypeName");
		gameTypeUUID = databaseResultSet.getString("gameTypeUUID");
		
		gameSequenceName = databaseResultSet.getString("gameSequenceName");
		gameSequenceUUID = databaseResultSet.getString("gameSequenceUUID");
		difficultyName = databaseResultSet.getString("difficultyName");
		gameTypeEndedOnName = databaseResultSet.getString("gameTypeEndedOnName");
		gameTypeEndedOnUUID = databaseResultSet.getString("gameTypeEndedOnUUID");
		
		won = databaseResultSet.getInt("won");
		died = databaseResultSet.getInt("died");
		lost = databaseResultSet.getInt("lost");
		complete = databaseResultSet.getInt("complete");
		isLocalMultiplayer = databaseResultSet.getInt("isLocalMultiplayer");
		
		isNetworkMultiplayer = databaseResultSet.getInt("isNetworkMultiplayer");
		numPlayers = databaseResultSet.getInt("numPlayers");
		level = databaseResultSet.getInt("level");
		timeLasted = databaseResultSet.getLong("timeLasted");
		timeStarted = databaseResultSet.getLong("timeStarted");
		
		timeEnded = databaseResultSet.getLong("timeEnded");
		blocksMade = databaseResultSet.getInt("blocksMade");
		piecesMade = databaseResultSet.getInt("piecesMade");
		blocksCleared = databaseResultSet.getInt("blocksCleared");
		piecesPlaced = databaseResultSet.getInt("piecesPlaced");
		
		combosMade = databaseResultSet.getInt("combosMade");
		biggestCombo = databaseResultSet.getInt("biggestCombo");
		//maxPlayers = databaseResultSet.getInt("maxPlayers");
		//privateRoom = databaseResultSet.getInt("privateRoom");
		//tournamentRoom = databaseResultSet.getInt("tournamentRoom");
		//hostUserID = databaseResultSet.getLong("hostUserID");

		//room_DifficultyName = databaseResultSet.getString("room_DifficultyName");
		//singlePlayer_randomizeSequence = databaseResultSet.getInt("singlePlayer_randomizeSequence");
		//endlessMode = databaseResultSet.getInt("endlessMode");
		//multiplayer_NumPlayers = databaseResultSet.getInt("multiplayer_NumPlayers");

		//multiplayer_AllowDifferentDifficulties = databaseResultSet.getInt("multiplayer_AllowDifferentDifficulties");
		//multiplayer_AllowDifferentGameSequences = databaseResultSet.getInt("multiplayer_AllowDifferentGameSequences");
		//multiplayer_GameEndsWhenOnePlayerRemains = databaseResultSet.getInt("multiplayer_GameEndsWhenOnePlayerRemains");
		//multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel = databaseResultSet.getInt("multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel");
		//multiplayer_DisableVSGarbage = databaseResultSet.getInt("multiplayer_DisableVSGarbage");
		allFrameStatesZipped = databaseResultSet.getString("allFrameStatesZipped");
		statsUUID = databaseResultSet.getString("statsUUID");
		playerIDsCSV = databaseResultSet.getString("playerIDsCSV");
		
		room = new BobsGameRoom(databaseResultSet);

		if(userName==null)userName = "";
		if(isGameSequenceOrType==null)isGameSequenceOrType = "";
		if(gameTypeName==null)gameTypeName = "";
		if(gameTypeUUID==null)gameTypeUUID = "";
		if(gameSequenceName==null)gameSequenceName = "";
		if(gameSequenceUUID==null)gameSequenceUUID = "";
		if(gameTypeEndedOnName==null)gameTypeEndedOnName = "";
		if(gameTypeEndedOnUUID==null)gameTypeEndedOnUUID = "";
		if(allFrameStatesZipped==null)allFrameStatesZipped = "";
		if(statsUUID==null)statsUUID = "";
		if(playerIDsCSV==null)playerIDsCSV = "";


	}
	catch (Exception ex)
	{
		log.error("DB ERROR:"+ex.getMessage());
	}
}


//=========================================================================================================================
public PreparedStatement getInsertStatement(Connection databaseConnection, BobsGameClient cc)
{//=========================================================================================================================

//	InetAddress addr = null;
//	try
//	{
//		addr = InetAddress.getByName(cc.channel.getRemoteAddress().toString());
//	}
//	catch(UnknownHostException e)
//	{
//		e.printStackTrace();
//	}
//
//	if(addr!=null)
//	internetProviderString = addr.getHostName();






	PreparedStatement ps = null;

	try
	{
		ps = databaseConnection.prepareStatement(
		"INSERT INTO "+BobNet.Bobs_Game_Game_Stats_DB_Name+" ( "+

		"userName , " +
		"userID , " +
		"isGameSequenceOrType , " +
		"gameTypeName , " +
		"gameTypeUUID , " +
		
		"gameSequenceName , " +
		"gameSequenceUUID , " +
		"difficultyName , " +
		"gameTypeEndedOnName , " +
		"gameTypeEndedOnUUID , " +

		"won , " +
		"died , " +
		"lost , " +
		"complete , " +
		"isLocalMultiplayer , " +

		"isNetworkMultiplayer , " +
		"numPlayers , " +
		"level , " +
		"timeLasted , " +
		"timeStarted , " +

		"timeEnded , " +
		"blocksMade , " +
		"piecesMade , " +
		"blocksCleared , " +
		"piecesPlaced , " +

		"combosMade , " +
		"biggestCombo , " +
		//"maxPlayers , " +
		//"privateRoom , " +
		//"tournamentRoom , " +

		//"hostUserID , " +
		//"room_DifficultyName , " +
		//"singlePlayer_randomizeSequence , " +
		//"endlessMode , " +
		//"multiplayer_NumPlayers , " +

		//"multiplayer_AllowDifferentDifficulties , " +
		//"multiplayer_AllowDifferentGameSequences , " +
		//"multiplayer_GameEndsWhenOnePlayerRemains , " +
		//"multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel , " +
		//"multiplayer_DisableVSGarbage , " +

		"allFrameStatesZipped , " +
		"statsUUID , " +
		"playerIDsCSV, " +
		room.getDBVariables() +

		" ) VALUES ( " +
		"?, ?, ?, ?, ?, " +
		"?, ?, ?, ?, ?, " +

		"?, ?, ?, ?, ?, " +
		"?, ?, ?, ?, ?, " +

		//"?, ?, ?, ?, ?, " +
		//"?, ?, ?, ?, ?, " +

		//"?, ?, ?, ?, ?, " +
		"?, ?, ?, ?, ?, " +
		"?, ?, ?, ?, ?, " +
		room.getDBQuestionMarks() +
		")");

	int c = 1;

	ps.setString	(c++, userName);
	ps.setLong		(c++, userID);
	ps.setString	(c++, isGameSequenceOrType);
	ps.setString	(c++, gameTypeName);
	ps.setString	(c++, gameTypeUUID);

	ps.setString	(c++, gameSequenceName);
	ps.setString	(c++, gameSequenceUUID);
	ps.setString	(c++, difficultyName);
	ps.setString	(c++, gameTypeEndedOnName);
	ps.setString	(c++, gameTypeEndedOnUUID);
	

	ps.setInt		(c++, won);
	ps.setInt		(c++, died);
	ps.setInt		(c++, lost);
	ps.setInt		(c++, complete);
	ps.setInt		(c++, isLocalMultiplayer);

	ps.setInt		(c++, isNetworkMultiplayer);
	ps.setInt		(c++, numPlayers);
	ps.setInt		(c++, level);
	ps.setLong		(c++, timeLasted);
	ps.setLong		(c++, timeStarted);

	ps.setLong		(c++, timeEnded);
	ps.setInt		(c++, blocksMade);
	ps.setInt		(c++, piecesMade);
	ps.setInt		(c++, blocksCleared);
	ps.setInt		(c++, piecesPlaced);

	ps.setInt		(c++, combosMade);
	ps.setInt		(c++, biggestCombo);
	
	
	//ps.setInt		(c++, maxPlayers);
	//ps.setInt		(c++, privateRoom);
	//ps.setInt		(c++, tournamentRoom);

	//ps.setLong		(c++, hostUserID);
	//ps.setString	(c++, room_DifficultyName);
	//ps.setInt		(c++, singlePlayer_randomizeSequence);
	//ps.setInt		(c++, endlessMode);
	//ps.setInt		(c++, multiplayer_NumPlayers);

	//ps.setInt		(c++, multiplayer_AllowDifferentDifficulties);
	//ps.setInt		(c++, multiplayer_AllowDifferentGameSequences);
	//ps.setInt		(c++, multiplayer_GameEndsWhenOnePlayerRemains);
	//ps.setInt		(c++, multiplayer_GameEndsWhenSomeoneCompletesCreditsLevel);
	//ps.setInt		(c++, multiplayer_DisableVSGarbage);

	ps.setString	(c++, allFrameStatesZipped);
	ps.setString	(c++, statsUUID);
	ps.setString	(c++, playerIDsCSV);
	
	room.setDBPreparedStatementVariables(c,ps);


	}
	catch (Exception ex){System.err.println("DB ERROR: "+ex.getMessage());}

	//statement = statement.replace("\\", "\\\\");
	//Using PreparedStatement makes this unnecessary, dont need to escape strings
	//NEVERMIND  clean this better, clean all user input on both client and server side

	//System.out.println(statement);

	return ps;
}



};